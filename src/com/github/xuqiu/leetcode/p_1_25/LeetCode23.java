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
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        ListNode resultHead = new ListNode();
        ListNode last = resultHead;
        while(true) {
            int minIndex = 0;
            ListNode minNode = lists[0];
            for (int i = 1, listsLength = lists.length; i < listsLength; i++) {
                if (minNode == null) {
                    minNode = lists[i];
                    minIndex = i;
                    if(i==listsLength-1&&minNode==null){
                        return resultHead.next;
                    }
                    continue;
                }
                ListNode curNode = lists[i];
                if (curNode == null){
                    continue;
                }
                if (curNode.val < minNode.val){
                    minNode = curNode;
                    minIndex = i;
                }
            }
            last.next = new ListNode(minNode.val);
            last=last.next;
            lists[minIndex]=minNode.next;
        }
    }
    @Test
    public void test(){
        System.out.println(
            mergeKLists(new ListNode[]{
                ListNode.of(new int[]{1,4,5}),
                ListNode.of(new int[]{1,3,4}),
                ListNode.of(new int[]{2,6})
            })
        );
    }

}
