package com.diffblue.interview.analyzer;

import java.util.Set;

/**
 * An interface representing code analysis functions
 */
public interface CodeAnalyzer {
    /**
     * Runs the given test and returns the covered lines of code
     * @param test to run
     * @return the covered lines of code
     */
    Set<CodeLine> runTest(CodeTest test);

    /**
     * Run all tests and returns the covered lines of code
     * @param tests to run
     * @return the covered lines of code
     */
    Set<CodeLine> runTestSuite(Set<CodeTest> tests);

    /**
     * @param tests to find unique tests
     * @return all tests that cover something not covered by other tests
     */
    Set<String> uniqueTests(Set<CodeTest> tests);
}
