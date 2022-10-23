package com.diffblue.interview.runner;

public class TestRunnerStub implements TestRunner {
    @Override
    public void run(String testName) {
        System.out.println("Test " + testName + " is running");
    }
}
