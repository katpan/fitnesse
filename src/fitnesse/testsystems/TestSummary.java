// Copyright (C) 2003-2009 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the CPL Common Public License version 1.0.
package fitnesse.testsystems;


public class TestSummary {
  public int right = 0;
  public int wrong = 0;
  public int ignores = 0;
  public int exceptions = 0;

  public TestSummary(int right, int wrong, int ignores, int exceptions) {
    this.right = right;
    this.wrong = wrong;
    this.ignores = ignores;
    this.exceptions = exceptions;
  }

  public TestSummary(TestSummary testSummary) {
    right = testSummary.getRight();
    wrong = testSummary.getWrong();
    ignores = testSummary.getIgnores();
    exceptions = testSummary.getExceptions();
  }

  public TestSummary() {
  }

  public String toString() {
    return getRight() + " right, " + getWrong() + " wrong, " + getIgnores()
    + " ignored, " + getExceptions() + " exceptions";
  }

  public boolean equals(Object o) {
    if (o == null || !(o instanceof TestSummary))
      return false;
    TestSummary other = (TestSummary) o;
    return getRight() == other.getRight() && getWrong() == other.getWrong()
    && getIgnores() == other.getIgnores()
    && getExceptions() == other.getExceptions();
  }

  public int hashCode() {
    assert false : "hashCode not designed";
  return 42;
  }

  public void tallyPageCounts(ExecutionResult result) {
	switch (result) {
	case ERROR:
		exceptions += 1;
		break;
	case FAIL:
		wrong += 1;
		break;
	case IGNORE:
		ignores += 1;
		break;
	case PASS:
		right += 1;
	}
  }

  public void add(TestSummary testSummary) {
    right = getRight() + testSummary.getRight();
    wrong = getWrong() + testSummary.getWrong();
    ignores = getIgnores() + testSummary.getIgnores();
    exceptions = getExceptions() + testSummary.getExceptions();
  }

  public void clear() {
    right = 0;
    wrong = 0;
    ignores = 0;
    exceptions = 0;
  }

  public int getRight() {
    return right;
  }

  public int getWrong() {
    return wrong;
  }

  public int getIgnores() {
    return ignores;
  }

  public int getExceptions() {
    return exceptions;
  }

  public void add(ExecutionResult executionResult) {
    if (executionResult != null) {
     switch (executionResult) {
       case PASS:
         right++;
         break;
       case FAIL:
         wrong++;
         break;
       case IGNORE:
         ignores++;
         break;
       case ERROR:
         exceptions++;
         break;
     }
    }
  }
}
