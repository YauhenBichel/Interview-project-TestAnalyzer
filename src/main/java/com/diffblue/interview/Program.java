package com.diffblue.interview;

import com.diffblue.interview.analyzer.CodeAnalyzer;
import com.diffblue.interview.analyzer.CodeAnalyzerImpl;
import com.diffblue.interview.analyzer.CodeClass;
import com.diffblue.interview.analyzer.CodeClassImpl;
import com.diffblue.interview.analyzer.CodeLine;
import com.diffblue.interview.analyzer.CodeTest;
import com.diffblue.interview.analyzer.CodeTestImpl;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        String currentDir = new File("").getAbsoluteFile().getAbsolutePath();
        final String javaSrcFile1 = currentDir + "/example/app/IntegerCalculator.java";
        final String javaSrcFile2 = currentDir + "/example/app/FloatCalculator.java";
        final String javaTestFile1 = currentDir + "/example/test/IntegerCalculatorTest.java";
        final String javaTestFile2 = currentDir + "/example/test/FloatCalculatorTest.java";

        CodeTest codeTest1 = prepareCodeTest(javaSrcFile1, javaTestFile1);
        CodeTest codeTest2 = prepareCodeTest(javaSrcFile2, javaTestFile2);

        Set<CodeTest> codeTestSet = new HashSet<>();
        codeTestSet.add(codeTest1);
        codeTestSet.add(codeTest2);

        CodeAnalyzer codeAnalyzer = new CodeAnalyzerImpl();
        Set<CodeLine> test1CodeLines = codeAnalyzer.runTest(codeTest1);
        Set<CodeLine> suiteCodeLines = codeAnalyzer.runTestSuite(codeTestSet);
    }

    private static CodeTest prepareCodeTest(String srcFile, String testFile) {
        CodeClass srcCodeClass = new CodeClassImpl(srcFile);
        return new CodeTestImpl(testFile, srcCodeClass);
    }
}
