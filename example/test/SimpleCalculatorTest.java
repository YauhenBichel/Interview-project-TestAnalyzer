package com.diffblue.interview.test;

import com.diffblue.interview.app.SimpleCalculator;
import org.junit.Assert;
import org.junit.Test;

public class SimpleCalculatorTest {

    @Test
    public void testSum() {
        //arrange
        SimpleCalculator calc = new SimpleCalculator();
        final int expectedResult = 5;

        //act
        int actualResult = calc.sum(2, 3);

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSubtract() {
        //arrange
        SimpleCalculator calc = new SimpleCalculator();
        final int expectedResult = 3;

        //act
        int actualResult = calc.subtract(12, 9);

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}
