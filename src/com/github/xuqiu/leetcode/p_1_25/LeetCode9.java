package com.github.xuqiu.leetcode.p_1_25;

import java.util.stream.IntStream;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-24 14:54
 */
public class LeetCode9 {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x<10){
            return true;
        }
        final String s = String.valueOf(x);
        return IntStream.range(0, s.length() / 2).parallel().noneMatch(i -> s.charAt(i) != s.charAt(s.length() - i - 1));
    }
}
