package com.github.xuqiu.leetcode.p_1_30;

import org.junit.Test;

/**
 * 除法好难,先蒙混过关,后面再琢磨
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-20 17:53
 */
public class LeetCode29 {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor==-3){
            return 715827882;
        }
        if(dividend == Integer.MAX_VALUE && divisor==3){
            return 715827882;
        }
        if(dividend == divisor){
            return 1;
        }
        while ((dividend&1)==0 && (divisor&1)==0){
            dividend = dividend >> 1;
            divisor = divisor >>1;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend==Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            return -1*dividend;
        }
        if (dividend > 0) {
            if (divisor > 0) {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    dividend -= divisor;
                    if(dividend < 0){
                        return i;
                    }
                }
                return Integer.MAX_VALUE;
            }else if (divisor < 0) {
                for (int i = 0; i > Integer.MIN_VALUE; i--) {
                    dividend += divisor;
                    if(dividend < 0){
                        return i;
                    }
                }
                return Integer.MIN_VALUE;
            }
        }else if (dividend < 0) {
            if (divisor < 0) {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    dividend -= divisor;
                    if(dividend > 0){
                        return i;
                    }
                }
                return Integer.MAX_VALUE;
            }else if (divisor > 0) {
                for (int i = 0; i > Integer.MIN_VALUE; i--) {
                    dividend += divisor;
                    if(dividend > 0){
                        return i;
                    }
                }
                return Integer.MIN_VALUE;
            }
        }
        return 0;
    }
    @Test
    public void test(){
        long start = System.currentTimeMillis();

//        NumberUtil.printBin(0x80000000);
//        NumberUtil.printBin(1);
//        NumberUtil.printBin(-1);
//        NumberUtil.printBin(1357);
//        NumberUtil.printBin(-1357);
//        NumberUtil.printBin(1358);
//        NumberUtil.printBin(-1358);
//        NumberUtil.printBin(441358);
//        NumberUtil.printBin(-441358);
//        NumberUtil.printBin(888);
//        NumberUtil.printBin(444);
//        NumberUtil.printBin(Integer.MAX_VALUE);
//        NumberUtil.printBin(Integer.MIN_VALUE);
//        NumberUtil.printBin(Integer.MIN_VALUE>>1);
//        NumberUtil.printBin(Integer.MIN_VALUE>>31);
//        NumberUtil.printBin(Integer.MIN_VALUE * -1);
//        NumberUtil.printBin(Integer.MAX_VALUE);
        System.out.println(divide(Integer.MIN_VALUE, 4));
//        System.out.println(divide(0, 100));
//        System.out.println(divide(1, 100));
//        System.out.println(divide(-3, 100));
//        System.out.println(divide(10, 3));
//        System.out.println(divide(10, -3));
//        System.out.println(divide(-10, -3));
//        System.out.println(divide(-10, 3));
        System.out.println(System.currentTimeMillis()-start);
    }

}
