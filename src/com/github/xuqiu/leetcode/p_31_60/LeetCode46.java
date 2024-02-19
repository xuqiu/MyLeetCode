package com.github.xuqiu.leetcode.p_31_60;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 链表方案4ms竟然 beats 9%, 可能数组方案更快? 不纠结了,下一关
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new));
        for (int i = 0; i < numList.size(); i++) {
            if (i>0) {
                Collections.swap(numList, i-1, i);
            }
            result.addAll(permute(numList, numList.get(i), i));
        }
        return result;
    }
    public List<List<Integer>> permute(LinkedList<Integer> numList, int num, int pos) {
        LinkedList<Integer> copiedList = new LinkedList<>(numList);
        if (copiedList.size() <= 2) {
            return Collections.singletonList(copiedList);
        }
        List<List<Integer>> result = new LinkedList<>();
        copiedList.remove(pos);
        for (int i = 0; i < copiedList.size(); i++) {
            if (i>0) {
                Collections.swap(copiedList, i-1, i);
            }
            List<List<Integer>> permute = permute(copiedList, copiedList.get(i), i);
            for (List<Integer> integers : permute) {
                integers.add(pos, num);
            }
            result.addAll(permute);
        }
        return result;
    }
    @Test
    public void test() {
//        System.out.println(permute(new int[]{1}));
//        System.out.println();
//        System.out.println(permute(new int[]{1,2}));
//        System.out.println();
        System.out.println(permute(new int[]{1,2,3}));
        System.out.println();
        System.out.println(permute(new int[]{1,2,3,4}));
        System.out.println();
        System.out.println(permute(new int[]{1,2,3,4,5}));
    }
}
