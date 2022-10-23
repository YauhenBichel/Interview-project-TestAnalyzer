package com.diffblue.interview.analyzer;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CoveringProcessorStub implements CoveringProcessor {
    public Set<CodeLine> getCoveredLines(List<CodeLine> sourceLines) {
        Set<CodeLine> coveredLines = sourceLines.stream()
                .sorted(Comparator.comparingInt(CodeLine::getLineNumber))
                .filter(line -> line.getLineNumber() % 5 != 0 &&
                        line.getLineNumber() % 3 != 0)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        return coveredLines;
    }
}
