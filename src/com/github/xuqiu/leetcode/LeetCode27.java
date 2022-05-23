package com.github.xuqiu.leetcode;

import com.alibaba.fastjson.JSON;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-20 15:32
 */
public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int cursor = 0;
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            if (nums[i] != val) {
                nums[cursor] = nums[i];
                cursor ++;
            }
        }
        return cursor;
    }
    @Test
    public void test(){
        final int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
        System.out.println(JSON.toJSONString(nums));
    }

}
