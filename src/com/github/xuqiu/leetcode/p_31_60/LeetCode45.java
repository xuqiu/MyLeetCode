package com.github.xuqiu.leetcode.p_31_60;

import org.junit.Test;

/**
 * @author xuqiu
 * @since 2024-02-18
 * refine to 2ms
 */
public class LeetCode45 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] >= nums.length - 1) return 1;
        int stepFrom = 1;
        int stepTo = nums[0];
        for (int step = 1; step < nums.length; step++) {
            int nextTo = stepTo;
            for (int i = stepFrom; i <= stepTo; i++) {
                if (i + nums[i] >= nums.length - 1) {
                    return step + 1;
                }
                nextTo = Math.max(nextTo, i + nums[i]);
            }
            stepFrom = stepTo+1;
            stepTo = nextTo;
        }
        return 0;
    }
    @Test
    public void test(){
        System.out.println(jump(new int[]{1,1,1,1}));
        System.out.println(jump(new int[]{0}));
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,3,0,1,4}));

    }
}
