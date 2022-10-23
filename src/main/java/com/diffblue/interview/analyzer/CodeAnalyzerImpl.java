package com.diffblue.interview.analyzer;

import java.util.HashSet;
import java.util.Set;

public class CodeAnalyzerImpl implements CodeAnalyzer {

    @Override
    public Set<CodeLine> runTest(CodeTest test) {
        return test.getCoveredLines();
    }

    @Override
    public Set<CodeLine> runTestSuite(Set<CodeTest> tests) {
        Set<CodeLine> codeTestSet = new HashSet<>();

        for (CodeTest test : tests) {
            codeTestSet.addAll(test.getCoveredLines());
        }

        return codeTestSet;
    }
}
