package com.github.xuqiu.leetcode.p_1_25;

import com.github.xuqiu.leetcode.ListNode;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-18 15:12
 */
public class LeetCode23_2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) {
            return null;
        }
        ListNode root = null;
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                if (root == null){
                    root = lists[i];
                    break;
                }
                final ListNode[] pop = pop(lists[i]);
                root = sortedPut(root,pop[0]);
                lists[i] = pop[1];
            }
        }
        return root;
    }

    public static ListNode sortedPut(ListNode root, ListNode node){
        if (node == null){
            return root;
        }
        if (node.val < root.val){
            node.next=root;
            return node;
        }else if(root.next == null){
            root.next = node;
        }else if(node.val < root.next.val){
            node.next=root.next;
            root.next=node;
        }else{
            root.next=sortedPut(root.next, node);
        }
        return root;
    }
    public static ListNode[] pop(ListNode root){
        ListNode nextNode = root.next;
        root.next=null;
        return new ListNode[]{root, nextNode};
    }
    @Test
    public void test(){
//        System.out.println(
//            mergeKLists(new ListNode[]{
//                ListNode.of(new int[]{1,2,3}),
//                ListNode.of(new int[]{1,3,4}),
//                ListNode.of(new int[]{2,6})
//            })
//        );
        System.out.println(
            mergeKLists(new ListNode[]{
                ListNode.of(new int[]{1,2,3}),
                ListNode.of(new int[]{4,5,6,7})
            })
        );
    }

}
