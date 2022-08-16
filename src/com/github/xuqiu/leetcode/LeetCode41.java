package com.github.xuqiu.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-06-28 16:45
 */
public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    @Test
    public void test() {
        int[] nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{1,1};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{1};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{-1};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{-1,0};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{-1,0,1};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{-1,0,1,2};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{-1,0,1,2,3};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{-1,0,1,2,3,4};
        System.out.println(firstMissingPositive(nums));

    }
}

