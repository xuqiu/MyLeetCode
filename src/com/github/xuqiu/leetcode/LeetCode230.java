package com.github.xuqiu.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-18 21:33
 */
public class LeetCode230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> valList = new ArrayList<>();
        copyToArrayList(valList, root);
        valList.sort(Integer::compareTo);
        return valList.get(k-1);
    }

    private static void copyToArrayList(List<Integer> valList, TreeNode treeNode) {
        valList.add(treeNode.val);
        if(treeNode.left != null){
            copyToArrayList(valList, treeNode.left);
        }
        if(treeNode.right != null){
            copyToArrayList(valList, treeNode.right);
        }
    }

    @Test
    public void test(){
        Integer[] arg = {5,6,6,2,6,null,null,1};
        final TreeNode of = TreeNode.of(arg);
//        final int i = kthSmallest(of, 3);
        System.out.println(TreeNode.toString(of));
    }


}
