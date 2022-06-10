package com.github.xuqiu.leetcode.p_1_30;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-24 14:25
 */
public class LeetCode8 {
    public int myAtoi(String s) {
        long resultLong = 0;
        boolean trimmed = false;
        boolean signed = false;
        boolean negative = false;
        for (int i = 0; i < s.length(); i++) {
            if (!trimmed && s.charAt(i)==' '){
                continue;
            }
            trimmed = true;
            if (!signed){
                signed = true;
                if(s.charAt(i)=='+') {
                    continue;
                }
                if(s.charAt(i)=='-') {
                    negative = true;
                    continue;
                }
            }

            if(s.charAt(i)>'9'||s.charAt(i)<'0'){
                break;
            }
            resultLong = resultLong * 10 + (s.charAt(i)-48);
            if (resultLong > Integer.MAX_VALUE){
                return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
        }
        if (negative) {
            resultLong = resultLong * -1;
        }
        if (resultLong >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (resultLong <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)resultLong;
    }
    @Test
    public void test(){
        System.out.println(myAtoi("-2147483647"));
//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("     -42"));
//        System.out.println(myAtoi("4193 with words"));
    }

}
