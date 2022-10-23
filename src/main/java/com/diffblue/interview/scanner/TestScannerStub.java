package com.diffblue.interview.scanner;

import com.diffblue.interview.Constants;
import com.diffblue.interview.model.Pair;

import java.util.HashSet;
import java.util.Set;

public class TestScannerStub implements TestScanner {

    private FileHelper fileHelper;

    public TestScannerStub(FileHelper fileHelper) {
        this.fileHelper = fileHelper;
    }

    @Override
    public Set<String> getSourceFiles() {
        return null;
    }

    @Override
    public Set<String> getTestFiles() {
        return null;
    }

    @Override
    public Set<Pair<String, String>> getSourceTestPairs() {
        String currentDir = fileHelper.getAbsolutePath();
        final String javaSrcPath1 = currentDir + Constants.javaSrcFile1;
        final String javaTestPath1 = currentDir + Constants.javaTestFile1;
        final String javaSrcPath2 = currentDir + Constants.javaSrcFile2;
        final String javaTestPath2 = currentDir + Constants.javaTestFile2;

        Set<Pair<String, String>> srcTestPairs = new HashSet<>();
        srcTestPairs.add(new Pair<>(javaSrcPath1, javaTestPath1));
        srcTestPairs.add(new Pair<>(javaSrcPath2, javaTestPath2));

        return srcTestPairs;
    }
}
