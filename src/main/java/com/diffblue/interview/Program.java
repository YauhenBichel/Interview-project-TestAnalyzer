package com.diffblue.interview;

import com.diffblue.interview.analyzer.CodeAnalyzer;
import com.diffblue.interview.analyzer.CodeAnalyzerImpl;
import com.diffblue.interview.analyzer.CodeClass;
import com.diffblue.interview.analyzer.CodeClassImpl;
import com.diffblue.interview.analyzer.CodeLine;
import com.diffblue.interview.analyzer.CodeTest;
import com.diffblue.interview.analyzer.CodeTestImpl;

import java.io.File;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        String currentDir = new File("").getAbsoluteFile().getAbsolutePath();
        final String javaFile = currentDir + "/example/app/SimpleCalculator.java";
        CodeClass codeClass = new CodeClassImpl(javaFile);

        List<CodeLine> lines = codeClass.getLinesOfCode();

        CodeTest codeTest = new CodeTestImpl();
        CodeAnalyzer codeAnalyzer = new CodeAnalyzerImpl();
        codeAnalyzer.runTest(codeTest);
    }
}
