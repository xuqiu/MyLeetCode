package com.github.xuqiu.leetcode.p_1_25;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-17 17:47
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int c : s.toCharArray()) {
            final Integer peek = stack.peek();
            if (peek == null) {
                stack.push(c);
                continue;
            }
            if (c > peek && c - peek <= 2) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        System.out.println(isValid("(){}[]"));
        System.out.println(isValid("(){[]"));
        System.out.println(isValid("(){[]}"));
    }

}
