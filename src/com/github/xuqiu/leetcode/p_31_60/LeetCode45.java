package com.github.xuqiu.leetcode.p_31_60;

import org.junit.Test;

/**
 * @author xuqiu
 * @since 2024-02-18
 */
public class LeetCode45 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int steps=0;
        int to = nums.length - 1;
        for (int i = 0; i <= to; i++) {
            if (i + nums[i] >= to){
                if (i != 0){
                    to = i;
                    i = -1;
                    steps++;
                }else{
                    return steps + 1;
                }
            }
        }
        return steps;
    }
    @Test
    public void test(){
        System.out.println(jump(new int[]{0}));
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,3,0,1,4}));

    }
}
