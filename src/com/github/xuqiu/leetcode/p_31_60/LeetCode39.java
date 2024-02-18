package com.github.xuqiu.leetcode.p_31_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-06-28 15:42
 */
public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        checkLoop(candidates, target,0, list, result);
        return result;
    }

    private static void checkLoop(int[] candidates, int target, int index,  List<Integer> list, List<List<Integer>> result) {
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (candidate < target) {
                list.add(candidate);
                checkLoop(candidates, target - candidate, i, list, result);
            } else if (candidate == target) {
                list.add(candidate);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                break;
            } else {
                break;
            }
            list.remove(list.size() - 1);
        }
    }



    @Test
    public void test() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
        candidates = new int[]{2, 3, 5};
        target = 8;
        System.out.println(combinationSum(candidates, target));
    }
}