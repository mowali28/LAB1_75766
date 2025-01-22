package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest
{
    // Constructor and Add function tests as provided

    /**
     * Test the OR function with two binary numbers of the same length
     */
    @Test
    public void orSameLength() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("1100");
        Binary result = Binary.OR(binary1, binary2);
        assertTrue(result.getValue().equals("1110"));
    }

    /**
     * Test the OR function with two binary numbers, where the first argument is shorter
     */
    @Test
    public void orFirstShorter() {
        Binary binary1 = new Binary("10");
        Binary binary2 = new Binary("1110");
        Binary result = Binary.OR(binary1, binary2);
        assertTrue(result.getValue().equals("1110"));
    }

    /**
     * Test the OR function with a binary number and zero
     */
    @Test
    public void orWithZero() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("0");
        Binary result = Binary.OR(binary1, binary2);
        assertTrue(result.getValue().equals("1010"));
    }

    /**
     * Test the AND function with two binary numbers of the same length
     */
    @Test
    public void andSameLength() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("1100");
        Binary result = Binary.AND(binary1, binary2);
        assertTrue(result.getValue().equals("1000"));
    }

    /**
     * Test the AND function with two binary numbers, where the second argument is shorter
     */
    @Test
    public void andSecondShorter() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("11");
        Binary result = Binary.AND(binary1, binary2);
        assertTrue(result.getValue().equals("10"));
    }

    /**
     * Test the AND function with two binary numbers where one is zero
     */
    @Test
    public void andWithZero() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("0");
        Binary result = Binary.AND(binary1, binary2);
        assertTrue(result.getValue().equals("0"));
    }

    /**
     * Test the Multiply function with two binary numbers
     */
    @Test
    public void multiplyNormal() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("10");
        Binary result = Binary.Multiply(binary1, binary2);
        assertTrue(result.getValue().equals("10100"));
    }

    /**
     * Test the Multiply function where one binary number is zero
     */
    @Test
    public void multiplyWithZero() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("0");
        Binary result = Binary.Multiply(binary1, binary2);
        assertTrue(result.getValue().equals("0"));
    }

    /**
     * Test the Multiply function where both binary numbers are one
     */
    @Test
    public void multiplyWithOne() {
        Binary binary1 = new Binary("1");
        Binary binary2 = new Binary("1");
        Binary result = Binary.Multiply(binary1, binary2);
        assertTrue(result.getValue().equals("1"));
    }
}
