package com.github.xuqiu.leetcode;

import com.alibaba.fastjson.JSON;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-06-16 17:50
 */
public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        final int len = nums.length;
        if (len == 0) {
            return 0;
        }else if (len==1){
            return target <= nums[0]? 0:1;
        }
        if (nums[0]>=target){
            return 0;
        }
        if (nums[len-1]<target){
            return len;
        }
        int left = 0;
        int right = len-1;
        while(true){
            final int middleIndex = (left + right) / 2;
            int middleNum= nums[middleIndex];
            if (middleNum < target) {
                left = middleIndex+1;
            }else if(middleNum > target){
                right = middleIndex-1;
            }else{
                return middleIndex;
            }
            if (left>=right){
                final int newMiddle = (left + right) / 2;
                return nums[newMiddle]<target?newMiddle+1:newMiddle;
            }
        }
    }
    @Test
    public void test(){
        System.out.println(searchInsert(new int[]{1}, 0));
//        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
//        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
//        System.out.println(searchInsert(new int[]{1,2,3,5,6}, 0));
//        System.out.println(searchInsert(new int[]{1,2,3,5,6}, 1));
//        System.out.println(searchInsert(new int[]{1,2,3,5,6}, 2));
//        System.out.println(searchInsert(new int[]{1,2,3,5,6}, 3));
//        System.out.println(searchInsert(new int[]{1,2,3,5,6}, 4));
//        System.out.println(searchInsert(new int[]{1,2,3,5,6}, 5));
//        System.out.println(searchInsert(new int[]{1,2,3,5,6}, 6));
//        System.out.println(searchInsert(new int[]{1,2,3,5,6}, 7));
    }
}
