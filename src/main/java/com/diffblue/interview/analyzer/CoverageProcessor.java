package com.diffblue.interview.analyzer;

import java.util.List;
import java.util.Set;

public interface CoverageProcessor {
    Set<CodeLine> getCoveredLines(List<CodeLine> sourceLines);
}
