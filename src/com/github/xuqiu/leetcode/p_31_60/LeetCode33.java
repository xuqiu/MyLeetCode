package com.github.xuqiu.leetcode.p_31_60;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-06-10 18:00
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        final int len = nums.length;
        if(len==1){
            return nums[0]==target?0:-1;
        }
        if (nums[0]<target){
            if (nums[len-1]>nums[0] && nums[len-1]<target){
                return -1;
            }
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                if(num==target){
                    return i;
                }
                if (num<nums[i-1]){
                    return -1;
                }
                if (num>target){
                    return -1;
                }
            }
        }else if (nums[0]>target){
            if (nums[len-1]>nums[0]){
                return -1;
            }
            for (int i = len-1; i > 0; i--) {
                int num = nums[i];
                if(num==target){
                    return i;
                }
                if (num<nums[i-1]){
                    return -1;
                }
                if (num<target){
                    return -1;
                }
            }
        }
        return 0;
    }
    @Test
    public void test(){
        System.out.println(search(new int[]{1,2},0));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2},6));
//        System.out.println(search(new int[]{4,5,6,7},8));
//        System.out.println(search(new int[]{4,5,6,7},6));
//        System.out.println(search(new int[]{4,5,6,7},3));
    }

}
