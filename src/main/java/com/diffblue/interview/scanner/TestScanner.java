package com.diffblue.interview.scanner;

import com.diffblue.interview.model.Pair;

import java.util.Set;

public interface TestScanner {
    Set<String> getSourceFiles();

    Set<String> getTestFiles();

    Set<Pair<String, String>> getSourceTestPairs();
}
