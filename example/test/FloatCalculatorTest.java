package com.diffblue.interview.test;

import com.diffblue.interview.app.SimpleCalculator;
import org.junit.Assert;
import org.junit.Test;

public class FloatCalculatorTest {

    @Test
    public void testSum() {
        //arrange
        FloatCalculator calc = new FloatCalculator();
        final float expectedResult = 5.2;

        //act
        float actualResult = calc.sum(2.1, 3.1);

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSubtract() {
        //arrange
        FloatCalculator calc = new FloatCalculator();
        final float expectedResult = 3.0;

        //act
        float actualResult = calc.subtract(12.2, 9.2);

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}
