package com.diffblue.interview;

import com.diffblue.interview.analyzer.CoveringProcessorStub;
import com.diffblue.interview.scanner.TestScannerStub;

public class Program {
    public static void main(String[] args) {
        CodeAnalyzerRunner runner = new CodeAnalyzerRunner(
                new CoveringProcessorStub(),
                new TestScannerStub());

        //runner.analyzeOneTest();
        //runner.analyzeTestSet();
        //runner.getUniqueTests();

        runner.run();
    }
}
