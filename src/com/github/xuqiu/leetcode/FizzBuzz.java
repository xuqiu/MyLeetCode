package com.github.xuqiu.leetcode;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.List;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-08-25 15:09
 */
public class FizzBuzz {

    @Test
    public void test(){

        for (int i = 0; i < 25; i++) {
            System.out.println((combine(24,i) % 1000000007));
        }
//        for (int i = 0; i < 25; i++) {
//            System.out.println((combine(24,i)));
//        }
//        System.out.println(volleyball(30,28));
    }
    public static int volleyball(int A, int B){
        int win = Math.max(A, B);
        if (win < 25){
            return 0;
        }
        int lose = Math.min(A, B);
        if (win==25 && lose>=24){
            return 0;
        }
        if (win>25 && lose!=win-2){
            return 0;
        }
        long result;
        if (lose<24){
            result = combine(24,lose);
        }else if (lose==24){
            result = 603457371;
        }else {
            result = 603457371;
            for (int i = 0; i < lose-24; i++) {
                result = (result << 1) % 1000000007;
            }
        }

        return (int) (result % 1000000007);
    }
    public static long combine(int win, int loss) {
        long res = 1;
        for (int i = 1; i <= loss; i++) {
            res = res * (win + i) / i;
        }

        return res;
    }
//    public static long combine(int win, int loss) {
//        BigInteger res = new BigInteger("1");
//        for (int i = 1; i <= loss; i++) {
//            res = res.multiply(new BigInteger(String.valueOf(win + i))).divide(String.valueOf(i));
//        }
//        return res.longValue();
//    }
//    public static long combine(int win, int loss) {
//        BigInteger result = new BigInteger("1");
//        for (int i = win+loss; i > win; i--) {
//            result = result.multiply(new BigInteger(String.valueOf(i)));
//        }
//        for (int i = 2; i <= loss; i++) {
//            result = result.divide(new BigInteger(String.valueOf(i)));
//        }
//        return result.longValue();
//    }
    public static long fact(long n)
    {
        long sum=1;
        for(int i=2; i<=n; i++)
        {
            sum*=i;
        }
        return sum;
    }

    /**
     * 取字符交集
     */


    public static int gemstones(List<String> rocks) {
        int result = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int contain = 1;
            for (String rock : rocks) {
                if (rock.indexOf(c) == -1) {
                    contain = 0;
                    break;
                }
            }
            result += contain;
        }
        return result;
    }

    /**
     * isPangram("The quick brown fox jumps over the lazy dog")
     */
    public static String isPangram(List<String> pangram) {
        StringBuilder result = new StringBuilder();
        for (String str : pangram) {
            char isP = '1';
            for (char c = 'a'; c <= 'z'; c++) {
                if (str.indexOf(c) == -1) {
                    isP ='0';
                    break;
                }
            }
            result.append(isP);
        }
        return result.toString();
    }

    /**
     * 给定1和0的个数,求组合数
     */
    public static int countBinarySubstrings(String s) {
        int result = 0;
        int last = 0;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                result += Math.min(last, cur);
                last = cur;
                cur = 1;
            }
        }
        result += Math.min(last, cur);
        return result;
    }



}
