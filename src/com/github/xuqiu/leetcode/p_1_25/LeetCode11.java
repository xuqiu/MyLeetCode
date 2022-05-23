package com.github.xuqiu.leetcode.p_1_25;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-25 10:43
 */
public class LeetCode11 {
    public int maxArea(int[] height) {
        int longest = 0;
        int longestIndex = 0;
        int maxArea = 0;
        for (int i = 0, heightLength = height.length; i < heightLength; i++) {
            if(height[i]==0){
                continue;
            }
            if (Math.max(i,height.length-i-1)*height[i]<maxArea){
                continue;
            }
            if (height[i] > longest) {
                longest = height[i];
                longestIndex = i;
            }

            for (int start = longestIndex;start>=0;start--){
                int thisArea = Math.min(height[i],height[start]) * (i-start);
                maxArea = Math.max(thisArea,maxArea);
            }
        }
        return maxArea;
    }
    @Test
    public void test(){
        System.out.println(maxArea(new int[]{0,14,6,2,10,9,4,1,10,3}));
//        System.out.println(maxArea(new int[]{1,1}));
//        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
