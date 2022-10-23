package com.diffblue.interview.scanner;

import java.util.Set;

public interface TestScanner {
    Set<String> getSourceFiles();
    Set<String> getTestFiles();
}
