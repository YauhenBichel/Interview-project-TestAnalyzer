package com.diffblue.interview.analyzer;

import com.diffblue.interview.runner.TestRunner;

import java.util.HashSet;
import java.util.Set;

public class CodeAnalyzerImpl implements CodeAnalyzer {

    private TestRunner testRunner;

    public CodeAnalyzerImpl(TestRunner testRunner) {
        this.testRunner = testRunner;
    }

    @Override
    public Set<CodeLine> runTest(CodeTest test) {
        testRunner.run(test.getName());

        return test.getCoveredLines();
    }

    @Override
    public Set<CodeLine> runTestSuite(Set<CodeTest> tests) {
        Set<CodeLine> codeTestSet = new HashSet<>();

        for (CodeTest test : tests) {
            testRunner.run(test.getName());
            codeTestSet.addAll(test.getCoveredLines());
        }

        return codeTestSet;
    }

    @Override
    public Set<String> uniqueTests() {
        return null;
    }
}
