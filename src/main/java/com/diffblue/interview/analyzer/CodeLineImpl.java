package com.diffblue.interview.analyzer;

public class CodeLineImpl implements CodeLine {

    private int lineNumber;
    private String content;
    private int coveredByTestsAmount;

    public CodeLineImpl(int lineNumber, String content, int coveredByTestsAmount) {
        this.lineNumber = lineNumber;
        this.content = content;
        this.coveredByTestsAmount = coveredByTestsAmount;
    }

    @Override
    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public String getContents() {
        return content;
    }

    @Override
    public int getCoveredByTestsAmount() {
        return coveredByTestsAmount;
    }

    @Override
    public void setCoveredByTestsAmount(int amount) {
        coveredByTestsAmount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CodeLineImpl)) return false;

        CodeLineImpl codeLine = (CodeLineImpl) o;

        if (lineNumber != codeLine.lineNumber) return false;
        return content != null ? content.equals(codeLine.content) : codeLine.content == null;
    }

    @Override
    public int hashCode() {
        int result = lineNumber;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
