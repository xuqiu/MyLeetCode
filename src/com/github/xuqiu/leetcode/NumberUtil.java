package com.github.xuqiu.leetcode;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-20 18:22
 */
public final class NumberUtil {
    public static void printBin(int num){
        for(int i=31;i>=0;i--){
            System.out.print((num & (1<<i))==0 ? "0" : "1");
        }
        System.out.println();
    }

}
