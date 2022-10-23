package com.diffblue.interview.scanner;

import java.io.File;

public class FileHelperImpl implements FileHelper {
    @Override
    public String getAbsolutePath() {
        return new File("").getAbsoluteFile().getAbsolutePath();
    }
}
