package com.diffblue.interview;

import com.diffblue.interview.analyzer.CodeAnalyzer;
import com.diffblue.interview.analyzer.CodeAnalyzerImpl;
import com.diffblue.interview.analyzer.CodeClass;
import com.diffblue.interview.analyzer.CodeClassImpl;
import com.diffblue.interview.analyzer.CodeLine;
import com.diffblue.interview.analyzer.CodeTest;
import com.diffblue.interview.analyzer.CodeTestImpl;
import com.diffblue.interview.analyzer.CoveringProcessor;
import com.diffblue.interview.model.Pair;
import com.diffblue.interview.runner.TestRunner;
import com.diffblue.interview.runner.TestRunnerStub;
import com.diffblue.interview.scanner.TestScanner;

import java.util.HashSet;
import java.util.Set;

public class CodeAnalyzerRunner {

    private TestScanner testScanner;
    private CoveringProcessor coveringProcessor;

    public CodeAnalyzerRunner(CoveringProcessor coveringProcessor, TestScanner testScanner) {
        this.coveringProcessor = coveringProcessor;
        this.testScanner = testScanner;
    }

    public void run() {
        Set<CodeTest> codeTestSet = prepareCodeTests();

        TestRunner testRunner = new TestRunnerStub();
        CodeAnalyzer codeAnalyzer = new CodeAnalyzerImpl(testRunner);
        CodeTest codeTest = codeTestSet.stream().findFirst().get();
        Set<CodeLine> test1CodeLines = codeAnalyzer.runTest(codeTest);
        printResults(codeTest.getName(), test1CodeLines);

        Set<CodeLine> suiteCodeLines = codeAnalyzer.runTestSuite(codeTestSet);
        Set<String> uniqueTests = codeAnalyzer.uniqueTests();
    }

    public void analyzeOneTest() {
        Set<CodeTest> codeTestSet = prepareCodeTests();
        CodeTest codeTest = codeTestSet.stream().findFirst().get();

        TestRunner testRunner = new TestRunnerStub();
        CodeAnalyzer codeAnalyzer = new CodeAnalyzerImpl(testRunner);
        Set<CodeLine> test1CodeLines = codeAnalyzer.runTest(codeTest);
        printResults(codeTest.getName(), test1CodeLines);
    }

    public void analyzeTestSet() {
        Set<CodeTest> codeTestSet = prepareCodeTests();

        TestRunner testRunner = new TestRunnerStub();
        CodeAnalyzer codeAnalyzer = new CodeAnalyzerImpl(testRunner);

        Set<CodeLine> suiteCodeLines = codeAnalyzer.runTestSuite(codeTestSet);
    }

    public void getUniqueTests() {
        Set<CodeTest> codeTestSet = prepareCodeTests();

        TestRunner testRunner = new TestRunnerStub();
        CodeAnalyzer codeAnalyzer = new CodeAnalyzerImpl(testRunner);

        Set<String> uniqueTests = codeAnalyzer.uniqueTests();
    }

    private void printResults(String testName, Set<CodeLine> coveredLines) {
        System.out.println("-------");
        System.out.println("Test: " + testName);
        System.out.println("Covered lines:");

        for (CodeLine codeLine : coveredLines) {
            System.out.println(codeLine.getLineNumber() + ": " + codeLine.getContents());
        }

        System.out.println("-------");
    }

    private CodeTest prepareCodeTest(Pair<String, String> srcTestPair) {
        CodeClass srcCodeClass = new CodeClassImpl(srcTestPair.getSourceFile());
        return new CodeTestImpl(srcTestPair.getTestFile(), srcCodeClass, coveringProcessor);
    }

    private Set<CodeTest> prepareCodeTests() {
        Set<Pair<String, String>> srcTestPairs = testScanner.getSourceTestPairs();
        Set<CodeTest> codeTestSet = new HashSet<>();

        for(Pair<String, String> srcTestPair: srcTestPairs) {
            CodeTest codeTest = prepareCodeTest(srcTestPair);
            codeTestSet.add(codeTest);
        }

        return codeTestSet;
    }
}
