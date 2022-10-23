package com.diffblue.interview.analyzer;

import java.util.List;
import java.util.Set;

public interface CoveringProcessor {
    Set<CodeLine> getCoveredLines(List<CodeLine> sourceLines);
}
