package com.diffblue.interview.analyzer;

import java.util.List;
import java.util.Set;

public class CodeTestImpl implements CodeTest {

    private String testFile;
    private CodeClass codeClass;

    public CodeTestImpl(String testFile, CodeClass codeClass) {
        this.testFile = testFile;
        this.codeClass = codeClass;
    }

    @Override
    public String getName() {
        return testFile;
    }

    @Override
    public Set<CodeLine> getCoveredLines() {

        List<CodeLine> lines = codeClass.getLinesOfCode();

        return null;
    }
}
