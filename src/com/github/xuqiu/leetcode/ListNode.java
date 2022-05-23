package com.github.xuqiu.leetcode;

/**
 * ListNode
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-17 16:50
 */
public class ListNode {
    private int deep;
    public int val;
    public ListNode next;
    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int[] nums) {
        if (nums == null) {
            return null;
        }
        ListNode root = new ListNode(nums[0]);
        ListNode last = root;
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            ListNode cur = new ListNode(val);
            last.next = cur;
            last = cur;
        }
        return root;
    }

    @Override
    public String toString() {
        if (this.deep>100){
            return "...";
        }
        if (this.next == null) {
            return String.valueOf(this.val);
        }
        this.next.deep=this.deep+1;
        return this.val + "," + this.next;
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
}
