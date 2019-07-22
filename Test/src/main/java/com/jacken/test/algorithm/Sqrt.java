package com.jacken.test.algorithm;

/**
 * @author jacken
 * @date 2018/02/13
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(sqrt(9D, 1D, 0.01D));
    }

    public static Double sqrt(Double num, Double initNum, Double errorNum) {
        if(Math.abs(num - sqre(initNum)) <= errorNum) {
            return initNum;
        }

        initNum = (initNum + num/initNum) / 2;
        return sqrt(num, initNum, errorNum);
    }

    public static Double sqre(Double num) {
        return num * num;
    }
}
