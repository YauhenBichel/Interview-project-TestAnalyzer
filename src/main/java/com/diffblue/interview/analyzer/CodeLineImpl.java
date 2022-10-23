package com.diffblue.interview.analyzer;

public class CodeLineImpl implements CodeLine {

    private int lineNumber;
    private String content;

    public CodeLineImpl(int lineNumber, String content) {
        this.lineNumber = lineNumber;
        this.content = content;
    }

    @Override
    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public String getContents() {
        return content;
    }
}
