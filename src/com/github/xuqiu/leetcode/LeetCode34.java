package com.github.xuqiu.leetcode;

import com.alibaba.fastjson.JSON;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-06-13 14:17
 */
public class LeetCode34 {
    int[] NO_MATCH = {-1,-1};
    public int[] searchRange(int[] nums, int target) {
        final int len = nums.length;
        if (len == 0) {
            return NO_MATCH;
        }else if (len==1){
            return target == nums[0]? new int[]{0,0}:NO_MATCH;
        }
        int left = 0;
        int right = len-1;
        int eLeft = -1;
        int eRight = -1;
        while(true){
            final int middleIndex = (left + right) / 2;
            int middleNum= nums[middleIndex];
            if (middleNum < target) {
                left = middleIndex+1;
            }else if(middleNum > target){
                right = middleIndex-1;
            }else{
                eLeft = eRight = middleIndex;
                break;
            }
            if (left>=right){
                return target == nums[left]? new int[]{left,left}:NO_MATCH;
            }
        }
        while(eLeft>left){
            final int middleIndex = (left + eLeft) / 2;
            int middleNum= nums[middleIndex];
            if (middleNum < target) {
                left = middleIndex+1;
            }else{
                eLeft = middleIndex-1;
            }
        }
        if(eLeft<0||nums[eLeft]<target) {
            eLeft ++;
        }
        while(right>eRight){
            final int middleIndex = (eRight + right) / 2;
            int middleNum= nums[middleIndex];
            if (middleNum > target) {
                right = middleIndex-1;
            }else{
                eRight = middleIndex+1;
            }
        }
        if (eRight>len-1||nums[eRight]>target) {
            eRight --;
        }
        return new int[]{eLeft, eRight};
    }
    @Test
    public void test(){
        System.out.println(JSON.toJSONString(searchRange(new int[]{1,1,2}, 1)));
    }

}
