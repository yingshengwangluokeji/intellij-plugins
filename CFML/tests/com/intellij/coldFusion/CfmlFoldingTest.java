/*
 * Copyright 2000-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.coldFusion;

import com.intellij.codeInsight.folding.CodeFoldingSettings;

/**
 * @author vnikolaenko
 * @date 14.02.11
 */
public class CfmlFoldingTest extends CfmlCodeInsightFixtureTestCase {
  @Override
  protected String getBasePath() {
    return "/folding";
  }

  private void doTest() {
    myFixture.testFolding(getTestDataPath() + "/" + getTestName(false) + ".test.cfml");
  }

  public void testComments() throws Throwable {
    doTest();
  }

  public void testMethods() throws Throwable {
    boolean oldValue = CodeFoldingSettings.getInstance().isCollapseMethods();
    CodeFoldingSettings.getInstance().setCollapseMethods(true);
    myFixture.testFoldingWithCollapseStatus(getTestDataPath() + "/" + getTestName(false) + ".test.cfml");
    CodeFoldingSettings.getInstance().setCollapseMethods(oldValue);
  }

  public void testIfSwitchLoop() throws Throwable {
    myFixture.testFoldingWithCollapseStatus(getTestDataPath() + "/" + getTestName(false) + ".test.cfml");
  }
}
