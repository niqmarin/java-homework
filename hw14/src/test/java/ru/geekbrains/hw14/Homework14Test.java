package ru.geekbrains.hw14;

import org.junit.Assert;
import org.junit.Test;

public class Homework14Test {

    @Test
    public void arrayAfter4V1() {

        int[] testArr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {5, 6, 7, 8};
        int[] actual = new int[4];
        System.arraycopy(Homework14.arrayAfter4(testArr), 0, actual,0, actual.length);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayAfter4V2() {

        int[] testArr = {4, 5, 4, 5, 4, 7, 0};
        int[] expected = {7, 0};
        int[] actual = new int[2];
        System.arraycopy(Homework14.arrayAfter4(testArr), 0, actual,0, actual.length);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayAfter4V3() {
        int[] testArr = {1, 8, 6, -5, 9, 12};
        int[] actual = new int[6];
        try {
            System.arraycopy(Homework14.arrayAfter4(testArr), 0, actual,0, actual.length);
            Assert.fail("RuntimeException expected");
        }
        catch (RuntimeException e) {
            Assert.assertEquals("Массив не содержит 4.", e.getMessage());
        }
    }

    @Test
    public void arrayAfter4V4() {
        int[] testArr = {1, 8, 4, -5, 9, 4};
        int[] actual = new int[6];
        try {
            System.arraycopy(Homework14.arrayAfter4(testArr), 0, actual,0, actual.length);
            Assert.fail("RuntimeException expected");
        }
        catch (RuntimeException e) {
            Assert.assertEquals("Массив не содержит элементов после последней 4.", e.getMessage());
        }
    }

    @Test
    public void array1n4V1() {
        int[] testArr = {1, 4, 1, 1, 4, 1, 4, 4, 4, 4, 4, 1};
        Assert.assertTrue(Homework14.array1n4(testArr));
    }

    @Test
    public void array1n4V2() {
        int[] testArr = {1, 1, 1, 1, 1, 1};
        Assert.assertFalse(Homework14.array1n4(testArr));
    }

    @Test
    public void array1n4V3() {
        int[] testArr = {4, 4, 4, 4, 4, 4};
        Assert.assertFalse(Homework14.array1n4(testArr));
    }

    @Test
    public void array1n4V4() {
        int[] testArr = {1, 4, 4, 1, 4, 1, 5, 4};
        Assert.assertFalse(Homework14.array1n4(testArr));
    }

    @Test
    public void array1n4V5() {
        int[] testArr = {0, 5, 2, 19, 4, -3};
        Assert.assertFalse(Homework14.array1n4(testArr));
    }
}
