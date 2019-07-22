package com.jacken.test.algorithm;

/**
 * @author jacken
 * @date 2018/02/13
 */
public class Fib {

    private static int[] result;

    public static void main(String[] args) {

//        System.out.println(fib(3));
    }

    public static Integer fib(Integer number) {

        return fibFilter(1, 0, number);
    }

    private static Integer fibFilter(int i, int j, Integer number) {
        if(number <= 0) {
            return j;
        }

        return fibFilter(i+j, i, --number);
    }

}
