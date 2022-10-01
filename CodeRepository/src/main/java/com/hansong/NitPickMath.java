package com.hansong;

/**
 * Created by xhans on 2016/4/24.
 */
public class NitPickMath {

    static class OverflowException extends Exception {
    }
    static class UnderflowException extends Exception {
    }
    static class DivideByZeroException extends Exception {
    }

    static int remainder(int dividend, int divisor)
            throws DivideByZeroException {
        try {
            return dividend % divisor;
        }
        catch (ArithmeticException e) {
            throw new DivideByZeroException();
        }
    }

    static int inc(){
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e){
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}
