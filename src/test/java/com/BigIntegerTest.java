package com;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by xhans on 2016/5/2.
 */
public class BigIntegerTest {
    @Test
    public void testValueOf1(){
        BigInteger b1 = new BigInteger(String.valueOf(0));
        Assert.assertEquals(b1, BigInteger.valueOf(0));
    }
    @Test
    public void testValueOf2(){

        BigInteger b2 = new BigInteger(String.valueOf(-1));
        Assert.assertEquals(b2, BigInteger.valueOf(-1));

    }

    @Test
    public void testValueOf3(){

        BigInteger b3 = new BigInteger(String.valueOf(1));
        Assert.assertEquals(b3, BigInteger.valueOf(1));

    }

    @Test
    public void testValueOf4(){

        BigInteger b4 = new BigInteger(String.valueOf(Integer.MAX_VALUE + 10));
        Assert.assertEquals(b4, BigInteger.valueOf(Integer.MAX_VALUE + 10));

    }

    @Test
    public void testValueOf5(){

        BigInteger b5 = new BigInteger(String.valueOf(-(Integer.MAX_VALUE + 10)));
        Assert.assertEquals(b5, BigInteger.valueOf(-(Integer.MAX_VALUE + 10)));

    }

    @Test
    public void testAdd1(){
        BigInteger a1 = new BigInteger(String.valueOf(0));
        BigInteger b1 = new BigInteger(String.valueOf(1));
        Assert.assertEquals(a1.add(b1), BigInteger.valueOf(1));
    }

    @Test
    public void testAdd2(){

        BigInteger a2 = new BigInteger(String.valueOf(1));
        BigInteger b2 = new BigInteger(String.valueOf(0));
        Assert.assertEquals(a2.add(b2), BigInteger.valueOf(1));

    }

    @Test
    public void testAdd3(){

        BigInteger a3 = new BigInteger(String.valueOf(1));
        BigInteger b3 = new BigInteger(String.valueOf(1));
        Assert.assertEquals(a3.add(b3), BigInteger.valueOf(2));

    }

    @Test
    public void testAdd4(){

        BigInteger a4 = new BigInteger(String.valueOf(-1));
        BigInteger b4 = new BigInteger(String.valueOf(1));
        Assert.assertEquals(a4.add(b4), BigInteger.valueOf(0));

    }

    @Test
    public void testAdd5(){

        BigInteger a5 = new BigInteger(String.valueOf(-1));
        BigInteger b5 = new BigInteger(String.valueOf(2));
        Assert.assertEquals(a5.add(b5), BigInteger.valueOf(1));

    }

    @Test
    public void testGCD(){
        BigInteger a1 = new BigInteger(String.valueOf(1));
        BigInteger b1 = new BigInteger(String.valueOf(0));
        Assert.assertEquals(a1.gcd(b1), BigInteger.valueOf(1));

    }

    @Test
    public void testGCD2(){

        BigInteger a2 = new BigInteger(String.valueOf(0));
        BigInteger b2 = new BigInteger(String.valueOf(1));
        Assert.assertEquals(a2.gcd(b2), BigInteger.valueOf(1));

   }

    @Test
    public void testGCD3(){
        BigInteger a3 = new BigInteger(String.valueOf(2));
        BigInteger b3 = new BigInteger(String.valueOf(4));
        Assert.assertEquals(a3.gcd(b3), BigInteger.valueOf(2));

    }
    @Test
    public void testShiftLeft(){
        BigInteger a1 = new BigInteger(String.valueOf(0));
        Assert.assertEquals(a1.shiftLeft(0), BigInteger.ZERO);

    }


    @Test
    public void testShiftLeft2(){

        BigInteger a2 = new BigInteger(String.valueOf(1));
        Assert.assertEquals(a2.shiftLeft(1), BigInteger.valueOf(2));

   }

    @Test
    public void testShiftLeft3(){

        BigInteger a3 = new BigInteger(String.valueOf(1));
        Assert.assertEquals(a3.shiftLeft(0), BigInteger.valueOf(1));

    }

    @Test
    public void testShiftLeft4(){

        BigInteger a4 = new BigInteger(String.valueOf(1));
        Assert.assertEquals(a4.shiftLeft(-1), BigInteger.valueOf(0));

    }
}
