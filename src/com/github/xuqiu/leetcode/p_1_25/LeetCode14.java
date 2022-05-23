package com.github.xuqiu.leetcode.p_1_25;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-29 10:56
 */
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 200; i++) {
            int finalI = i;
            final List<Character> collect = Arrays
                .stream(strs).map(s -> s.length()>finalI?s.charAt(finalI):null).distinct().collect(Collectors.toList());
            if (collect.contains(null) || collect.size()>1) {
                break;
            }
            sb.append(collect.get(0));
        }
        return sb.toString();
    }
    @Test
    public void test(){
        final String result = longestCommonPrefix(new String[] { "" });
        System.out.println(result);
    }
}
