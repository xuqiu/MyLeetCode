package com.github.xuqiu.leetcode.p_1_25;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-05 17:15
 */
public class LeetCode17 {
    final Map<Character, String> PHONE_DIGITS = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );
    public List<String> letterCombinations(String digits) {

        List<String> result = new LinkedList<>();
        for (Character digit : digits.toCharArray()) {
            final String letters = PHONE_DIGITS.get(digit);
            if (result.isEmpty()) {
                for (Character letter : letters.toCharArray()) {
                    result.add(String.valueOf(letter));
                }
            }else{
                List<String> newResult = new LinkedList<>();
                for (String oldStrings : result) {
                    for (Character letter : letters.toCharArray()) {
                        newResult.add(oldStrings + letter);
                    }
                }
                result = newResult;
            }
        }
        return result;
    }
    @Test
    public void test(){
        final List<String> strings = letterCombinations("232");
        System.out.println(JSON.toJSONString(strings));
    }
}
