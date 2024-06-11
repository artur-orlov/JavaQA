package org.example;

import org.example.FactorialCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test
    public void testCalculateFactorialForZero() {
        int number = 0;
        long expectedFactorial = 1;
        long actualFactorial = FactorialCalculator.calculateFactorial(number);
        Assert.assertEquals(actualFactorial, expectedFactorial, "Factorial calculation is incorrect for zero");
    }

    @Test
    public void testCalculateFactorialForPositiveNumber() {
        int number = 5;
        long expectedFactorial = 120;
        long actualFactorial = FactorialCalculator.calculateFactorial(number);
        Assert.assertEquals(actualFactorial, expectedFactorial, "Factorial calculation is incorrect for positive number");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateFactorialForNegativeNumber() {
        int number = -5;
        FactorialCalculator.calculateFactorial(number);
    }

    @Test
    public void testCalculateFactorialForOne() {
        int number = 1;
        long expectedFactorial = 1;
        long actualFactorial = FactorialCalculator.calculateFactorial(number);
        Assert.assertEquals(actualFactorial, expectedFactorial, "Factorial calculation is incorrect for one");
    }

    @Test
    public void testCalculateFactorialForLargeNumber() {
        int number = 20;
        long expectedFactorial = 2432902008176640000L; // Факториал 20
        long actualFactorial = FactorialCalculator.calculateFactorial(number);
        Assert.assertEquals(actualFactorial, expectedFactorial, "Factorial calculation is incorrect for large number");
    }
}
