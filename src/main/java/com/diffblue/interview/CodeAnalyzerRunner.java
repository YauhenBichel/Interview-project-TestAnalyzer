package com.diffblue.interview;

import com.diffblue.interview.analyzer.CodeAnalyzer;
import com.diffblue.interview.analyzer.CodeAnalyzerImpl;
import com.diffblue.interview.analyzer.CodeClass;
import com.diffblue.interview.analyzer.CodeClassImpl;
import com.diffblue.interview.analyzer.CodeLine;
import com.diffblue.interview.analyzer.CodeTest;
import com.diffblue.interview.analyzer.CodeTestImpl;
import com.diffblue.interview.analyzer.CoverageProcessor;
import com.diffblue.interview.analyzer.CoverageProcessorStub;
import com.diffblue.interview.runner.TestRunner;
import com.diffblue.interview.runner.TestRunnerStub;
import com.diffblue.interview.scanner.TestScanner;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class CodeAnalyzerRunner {

    private TestScanner testScanner;
    private CoverageProcessor coverageProcessor;
    private final String javaSrcPath1;
    private final String javaTestPath1;
    private final String javaSrcPath2;
    private final String javaTestPath2;

    public CodeAnalyzerRunner(CoverageProcessor coverageProcessor, TestScanner testScanner) {
        this.coverageProcessor = coverageProcessor;
        this.testScanner = testScanner;

        String currentDir = new File("").getAbsoluteFile().getAbsolutePath();
        javaSrcPath1 = currentDir + Constants.javaSrcFile1;
        javaTestPath1 = currentDir + Constants.javaTestFile1;
        javaSrcPath2 = currentDir + Constants.javaSrcFile2;
        javaTestPath2 = currentDir + Constants.javaTestFile2;
    }

    public void run() {
        CodeTest codeTest1 = prepareCodeTest(javaSrcPath1, javaTestPath1);
        CodeTest codeTest2 = prepareCodeTest(javaSrcPath2, javaTestPath2);

        Set<CodeTest> codeTestSet = new HashSet<>();
        codeTestSet.add(codeTest1);
        codeTestSet.add(codeTest2);

        TestRunner testRunner = new TestRunnerStub();
        CodeAnalyzer codeAnalyzer = new CodeAnalyzerImpl(testRunner);
        Set<CodeLine> test1CodeLines = codeAnalyzer.runTest(codeTest1);
        printResults(codeTest1.getName(), test1CodeLines);

        Set<CodeLine> suiteCodeLines = codeAnalyzer.runTestSuite(codeTestSet);

        Set<String> uniqueTests = codeAnalyzer.uniqueTests();
    }

    public void analyzeOneTest() {
        CodeTest codeTest1 = prepareCodeTest(javaSrcPath1, javaTestPath1);

        TestRunner testRunner = new TestRunnerStub();
        CodeAnalyzer codeAnalyzer = new CodeAnalyzerImpl(testRunner);
        Set<CodeLine> test1CodeLines = codeAnalyzer.runTest(codeTest1);
        printResults(codeTest1.getName(), test1CodeLines);
    }

    public void analyzeTestSet() {
        CodeTest codeTest1 = prepareCodeTest(javaSrcPath1, javaTestPath1);
        CodeTest codeTest2 = prepareCodeTest(javaSrcPath2, javaTestPath2);

        Set<CodeTest> codeTestSet = new HashSet<>();
        codeTestSet.add(codeTest1);
        codeTestSet.add(codeTest2);

        TestRunner testRunner = new TestRunnerStub();
        CodeAnalyzer codeAnalyzer = new CodeAnalyzerImpl(testRunner);

        Set<CodeLine> suiteCodeLines = codeAnalyzer.runTestSuite(codeTestSet);
    }

    public void getUniqueTests() {
        CodeTest codeTest1 = prepareCodeTest(javaSrcPath1, javaTestPath1);
        CodeTest codeTest2 = prepareCodeTest(javaSrcPath2, javaTestPath2);

        Set<CodeTest> codeTestSet = new HashSet<>();
        codeTestSet.add(codeTest1);
        codeTestSet.add(codeTest2);

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

    private CodeTest prepareCodeTest(String srcFile, String testFile) {
        CodeClass srcCodeClass = new CodeClassImpl(srcFile);
        return new CodeTestImpl(testFile, srcCodeClass, coverageProcessor);
    }
}
