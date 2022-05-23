package com.github.xuqiu.leetcode.p_1_25;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-18 22:08
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>target) {
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]>target) {
                    continue;
                }
                if (nums[i]+nums[j]==target){
                    return new int[] { i,j };
                }
            }
        }
        return null;
    }
    @Test
    public void test(){
        int[] nums = {0,4,3,0};
        int target = 0;
        final int[] ints = twoSum(nums, target);
        System.out.println(ints[0]);
        System.out.println(ints[1]);

    }

}
