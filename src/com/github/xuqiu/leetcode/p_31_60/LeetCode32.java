package com.github.xuqiu.leetcode.p_31_60;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;
import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-06-10 17:25
 */
public class LeetCode32 {
    public int longestValidParentheses(String s) {
        if (s.length()<2) {
            return 0;
        }
        BitSet bitSet = new BitSet(s.length());
        Deque<Integer> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i]=='(') {
                stack.push(i);
            }else{
                try {
                    final Integer pop = stack.pop();
                    bitSet.set(pop);
                    bitSet.set(i);
                } catch (Exception notCare) {
                    //notCare
                }
            }
        }
        int result = 0;
        int last = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(bitSet.get(i)) {
                last++;
                if (last>result) {
                    result = last;
                }
            }else{
                last = 0;
            }
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(longestValidParentheses("(()(()(()"));
        System.out.println(longestValidParentheses("(()(()(()))"));
        System.out.println(longestValidParentheses("))(((("));
    }
}
