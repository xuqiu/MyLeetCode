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
 * @since 2022-06-28 16:32
 */
public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        checkLoop(candidates, target,0, list, result);
        return result;
    }

    private static void checkLoop(int[] candidates, int target, int index,  List<Integer> list, List<List<Integer>> result) {
        boolean loop = false;
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (loop && candidate == candidates[i-1]) {
                continue;
            }
            if (candidate < target) {
                list.add(candidate);
                checkLoop(candidates, target - candidate, i+1, list, result);
            } else if (candidate == target) {
                list.add(candidate);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                break;
            } else {
                break;
            }
            list.remove(list.size() - 1);
            loop = true;
        }
    }

    @Test
    public void test(){
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));

    }





}
