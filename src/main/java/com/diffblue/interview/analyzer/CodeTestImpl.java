package com.diffblue.interview.analyzer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

        Set<CodeLine> coveredLines = lines.stream()
                .sorted(Comparator.comparingInt(CodeLine::getLineNumber))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        return coveredLines;
    }
}
