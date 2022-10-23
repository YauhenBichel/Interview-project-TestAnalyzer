package com.diffblue.interview.analyzer;

import java.util.List;
import java.util.Set;

public class CodeTestImpl implements CodeTest {

    private String testFile;
    private CodeClass codeClass;
    private CoveringProcessor coveringProcessor;

    public CodeTestImpl(String testFile, CodeClass codeClass, CoveringProcessor coveringProcessor) {
        this.testFile = testFile;
        this.codeClass = codeClass;
        this.coveringProcessor = coveringProcessor;
    }

    @Override
    public String getName() {
        return testFile;
    }

    @Override
    public Set<CodeLine> getCoveredLines() {

        List<CodeLine> lines = codeClass.getLinesOfCode();
        Set<CodeLine> coveredLines = coveringProcessor.getCoveredLines(lines);

        return coveredLines;
    }
}
