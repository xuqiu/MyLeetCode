package com.github.xuqiu.leetcode;

import com.alibaba.fastjson.JSON;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-06-10 15:31
 */
public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        int numsLength = nums.length;
        //find the last increase index
        int lastDecreaseIndex = -1;
        int toSwitchIndex=-1;
        int lastDecreaseNum = 0;
        int toSwitchNum = 0;
        for (int i = 1; i < numsLength; i++) {
            if (nums[i]>nums[i-1]) {
                lastDecreaseIndex = i-1;
                lastDecreaseNum = nums[lastDecreaseIndex];
                toSwitchIndex = i;
                toSwitchNum = nums[toSwitchIndex];
            }
        }
        if (lastDecreaseIndex == -1){
            reverse(nums);
            return;
        }
        for (int i = toSwitchIndex+1; i < numsLength; i++) {
            if(lastDecreaseNum <nums[i] && nums[i]<toSwitchNum){
                toSwitchIndex = i;
                toSwitchNum = nums[toSwitchIndex];
            }
        }
        //switch
        if (lastDecreaseIndex>-1) {
            int i = nums[lastDecreaseIndex];
            nums[lastDecreaseIndex] = nums[toSwitchIndex];
            nums[toSwitchIndex] = i;
        }
        //sort the rest of numbers

        for (int i = 1; i < numsLength; i++) {
            boolean flag = true;
            for (int j = lastDecreaseIndex+1; j < numsLength - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;

                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
    //反转数组
    private static void reverse(int[] arr){
        for (int start=0,end=arr.length-1;start<=end;start++,end--){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
        }
    }
    @Test
    public void test(){
        int[] nums = {3,2,5,4,1};
        System.out.println(JSON.toJSONString(nums));
        nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
