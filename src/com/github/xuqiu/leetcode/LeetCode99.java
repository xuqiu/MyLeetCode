package com.github.xuqiu.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-19 19:34
 */
public class LeetCode99 {
    public void recoverTree(TreeNode root) {
        checkTwoSide(root, null, true);
    }
    public void checkTwoSide(TreeNode node, TreeNode father,boolean fathersLeft){
        if (node == null) {
            return;
        }
        while(switchSide(true, node, node.left) ||
            switchSide(false, node, node.right)){
            //continue;
        }
        checkTwoSide(node.left, node, true);
        checkTwoSide(node.right, node, false);
    }
    private boolean switchSide(boolean leftSide, TreeNode thisNode, TreeNode desNode){
        if (thisNode==null || desNode == null) {
            return false;
        }
        if (leftSide ? desNode.val > thisNode.val : desNode.val < thisNode.val){
            //swap
            int thisVal = thisNode.val;
            thisNode.val = desNode.val;
            desNode.val = thisVal;

            return true;
        }
        return switchSide(leftSide,thisNode,desNode.left)
        || switchSide(leftSide,thisNode,desNode.right);
    }


    @Test
    public void test(){
        Integer[] arg = {3,1,4,null,null,2};
        final TreeNode treeNode = TreeNode.of(arg);
        recoverTree(treeNode);
        System.out.println(TreeNode.toString(treeNode));
    }

}
