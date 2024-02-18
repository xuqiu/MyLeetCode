package com.github.xuqiu.leetcode.p_1_30;

import com.alibaba.fastjson2.JSON;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-20 15:32
 */
public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        int cursor = 0;
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            if (i == cursor) {
                continue;
            }
            if (nums[i] != nums[cursor]) {
                cursor ++;
                nums[cursor] = nums[i];
            }
        }
        return cursor+1;
    }
    @Test
    public void test(){
        final int[] nums = {0};
        System.out.println(removeDuplicates(nums));
        System.out.println(JSON.toJSONString(nums));
    }

}
