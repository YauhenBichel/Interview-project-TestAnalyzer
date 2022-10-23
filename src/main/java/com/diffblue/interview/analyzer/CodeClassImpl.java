package com.diffblue.interview.analyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CodeClassImpl implements CodeClass {

    private String javaFileName;

    public CodeClassImpl(String javaFileName) {
        this.javaFileName = javaFileName;
    }

    @Override
    public List<CodeLine> getLinesOfCode() {
        final Path filePath = this.getFile().toPath();

        List<CodeLine> codeLines = new ArrayList<>();

        List<String> lines = new ArrayList<>();
        try {
            lines = Files.lines(filePath, Charset.defaultCharset())
                    .collect(Collectors.toList());

            for (int i = 0; i < lines.size(); i++) {

                CodeLine codeLine = new CodeLineImpl(i + 1, lines.get(i), 1);

                if(codeLines.contains(codeLine)) {
                    codeLine.setCoveredByTestsAmount(codeLine.getCoveredByTestsAmount() + 1);
                }

                codeLines.add(codeLine);
            }

        } catch (IOException ex) {
            ex.printStackTrace();//replace by logging and exception for user
        }

        return codeLines;
    }

    @Override
    public File getFile() {
        return new File(javaFileName);
    }
}
