package com.github.xuqiu.leetcode.p_31_60;

import org.junit.Test;

/**
 * @author xuqiu
 * @since 2024-02-18
 */
public class LeetCode45 {
    int steps=0;
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        steps = 0;
        j(nums.length - 1,nums);
        return steps;
    }
    public void j(int to,int[] nums){
        steps++;
        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] >= to){
                if (i != 0){
                    j(i,nums);
                }
                break;
            }
        }
    }
    @Test
    public void test(){
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,3,0,1,4}));

    }
}
