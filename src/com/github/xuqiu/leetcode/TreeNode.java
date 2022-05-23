package com.github.xuqiu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-19 19:36
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode of(Integer[] arg){
        Map<Integer, TreeNode> nodeMap = new HashMap<>(arg.length);
        TreeNode root = null;
        for (int i = 1; i <= arg.length; i++) {
            Integer val = arg[i-1];
            if (val == null) {
                continue;
            }
            final TreeNode thisNode = new TreeNode(val);
            nodeMap.put(i, thisNode);
            if(i==1) {
                root = thisNode;
                continue;
            }
            TreeNode father = nodeMap.get(i/2);
            boolean left = i%2 == 0;
            if (left) {
                father.left=thisNode;
            }else{
                father.right=thisNode;
            }
        }
        return root;
    }

    @Override
    public String toString(){
        return String.valueOf(val);
    }

    public static String toString(TreeNode root){
        final List<TreeNode> children = new ArrayList<>(2);
        children.add(root.left);
        children.add(root.right);
        return "["+root.val + toString(children,1);
    }

    private static String toString(List<TreeNode> treeNodeList,int deep){
        if (deep>100){
            return "....";
        }
        StringBuilder thisGenerationString = new StringBuilder();
        if(emptyList(treeNodeList)){
            return "]";
        }
        List<TreeNode> nextGeneration = new ArrayList<>(treeNodeList.size()*2);
        for (Iterator<TreeNode> iterator = treeNodeList.iterator(); iterator.hasNext(); ) {
            if(emptyList(treeNodeList) && emptyList(nextGeneration)){
                return thisGenerationString+"]";
            }
            TreeNode treeNode = iterator.next();
            if (treeNode == null) {
                thisGenerationString.append(",null");
                nextGeneration.add(null);
                nextGeneration.add(null);
            } else {
                thisGenerationString.append(",").append(treeNode.val);
                nextGeneration.add(treeNode.left);
                nextGeneration.add(treeNode.right);
            }
            iterator.remove();
        }
        return thisGenerationString + toString(nextGeneration,++deep);

    }

    private static boolean emptyList(List<?> list){
        return list.stream().filter(Objects::nonNull).findFirst().isEmpty();
    }
}
