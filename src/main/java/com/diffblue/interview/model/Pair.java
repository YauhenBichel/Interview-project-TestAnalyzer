package com.diffblue.interview.model;

public class Pair<S, T> {
    private S sourceFile;
    private T testFile;

    public Pair(S srcFile, T testFile) {
        this.sourceFile = srcFile;
        this.testFile = testFile;
    }

    public S getSourceFile() {
        return sourceFile;
    }

    public T getTestFile() {
        return testFile;
    }

    public void setSourceFile(S sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void setTestFile(T testFile) {
        this.testFile = testFile;
    }
}
