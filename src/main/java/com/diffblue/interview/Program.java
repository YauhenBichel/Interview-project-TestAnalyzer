package com.diffblue.interview;

import com.diffblue.interview.analyzer.CodeAnalyzer;
import com.diffblue.interview.analyzer.CodeAnalyzerImpl;
import com.diffblue.interview.analyzer.CodeClass;
import com.diffblue.interview.analyzer.CodeClassImpl;
import com.diffblue.interview.analyzer.CodeLine;
import com.diffblue.interview.analyzer.CodeTest;
import com.diffblue.interview.analyzer.CodeTestImpl;
import com.diffblue.interview.runner.TestRunner;
import com.diffblue.interview.runner.TestRunnerImpl;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        String currentDir = new File("").getAbsoluteFile().getAbsolutePath();
        final String javaSrcPath1 = currentDir + Constants.javaSrcFile1;
        final String javaTestPath1 = currentDir + Constants.javaTestFile1;
        final String javaSrcPath2 = currentDir + Constants.javaSrcFile2;
        final String javaTestPath2 = currentDir + Constants.javaTestFile2;

        CodeTest codeTest1 = prepareCodeTest(javaSrcPath1, javaTestPath1);
        CodeTest codeTest2 = prepareCodeTest(javaSrcPath2, javaTestPath2);

        Set<CodeTest> codeTestSet = new HashSet<>();
        codeTestSet.add(codeTest1);
        codeTestSet.add(codeTest2);

        TestRunner testRunner = new TestRunnerImpl();
        CodeAnalyzer codeAnalyzer = new CodeAnalyzerImpl(testRunner);
        Set<CodeLine> test1CodeLines = codeAnalyzer.runTest(codeTest1);
        printResults(codeTest1.getName(), test1CodeLines);

        Set<CodeLine> suiteCodeLines = codeAnalyzer.runTestSuite(codeTestSet);
    }

    private static void printResults(String testName, Set<CodeLine> coveredLines) {
        System.out.println("-------");
        System.out.println("Test: " + testName);
        System.out.println("Covered lines:");

        for (CodeLine codeLine : coveredLines) {
            System.out.println(codeLine.getLineNumber() + ": " + codeLine.getContents());
        }

        System.out.println("-------");
    }

    private static CodeTest prepareCodeTest(String srcFile, String testFile) {
        CodeClass srcCodeClass = new CodeClassImpl(srcFile);
        return new CodeTestImpl(testFile, srcCodeClass);
    }
}
