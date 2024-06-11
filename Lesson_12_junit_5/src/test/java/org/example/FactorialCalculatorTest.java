package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    void testCalculateFactorialForZero() {
        long result = FactorialCalculator.calculateFactorial(0);
        assertEquals(1, result);
    }

    @Test
    void testCalculateFactorialForPositiveNumber() {
        long result = FactorialCalculator.calculateFactorial(5);
        assertEquals(120, result);
    }

    @Test
    void testCalculateFactorialForNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-5);
        });
    }

    @Test
    void testCalculateFactorialForOne() {
        long result = FactorialCalculator.calculateFactorial(1);
        assertEquals(1, result);
    }

    @Test
    void testCalculateFactorialForLargeNumber() {
        long result = FactorialCalculator.calculateFactorial(20);
        assertEquals(2432902008176640000L, result);
    }
}
