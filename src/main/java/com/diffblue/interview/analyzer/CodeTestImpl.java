package com.diffblue.interview.analyzer;

import java.util.List;
import java.util.Set;

public class CodeTestImpl implements CodeTest {

    private String testFile;
    private CodeClass codeClass;
    private CoverageProcessor coverageProcessor;

    public CodeTestImpl(String testFile, CodeClass codeClass, CoverageProcessor coverageProcessor) {
        this.testFile = testFile;
        this.codeClass = codeClass;
        this.coverageProcessor = coverageProcessor;
    }

    @Override
    public String getName() {
        return testFile;
    }

    @Override
    public Set<CodeLine> getCoveredLines() {

        List<CodeLine> lines = codeClass.getLinesOfCode();
        Set<CodeLine> coveredLines = coverageProcessor.getCoveredLines(lines);

        return coveredLines;
    }
}
