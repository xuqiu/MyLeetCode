package com.github.xuqiu.leetcode.p_1_30;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-10 16:46
 */
public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //        final long start = System.currentTimeMillis();
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        final int num1end =  nums.length - 3;
        for (int i = 0; i < num1end; i++) {
            int n1 = nums[i];
            if (i > 0 && n1 == nums[i - 1]) {
                continue;
            }
            for (int ij = i + 1; ij < nums.length - 1; ij++) {
                int n2 = nums[ij];
                if (ij - 1 > i && n2 == nums[ij - 1]) {
                    continue;
                }
//                final int sum12 = n2 + n1;
//                if (sum12 > target) {
//                    continue;
//                }
                for (int j = ij + 1; j < nums.length - 1; j++) {
                    int n3 = nums[j];
                    if (j - 1 > ij && n3 == nums[j - 1]) {
                        continue;
                    }
//                    final int sum123 = n3 + n2 + n1;
//                    if (sum123 > target) {
//                        continue;
//                    }
                    for (int k = j + 1; k < nums.length; k++) {
                        int n4 = nums[k];
                        if (k - 1 > j && n4 == nums[k - 1]) {
                            continue;
                        }
                        if (n1 + n2 + n3 + n4 == target) {
                            result.add(List.of(n1, n2, n3, n4));
                            break;
                        }
                    }
                }
            }
        }
        //        System.out.println(System.currentTimeMillis()-start);
        return result;
    }
    @Test
    public void test(){
        final List<List<Integer>> lists = fourSum(new int[] {1,-2,-5,-4,-3,3,3,5},-11);
        System.out.println(lists);
    }
}
