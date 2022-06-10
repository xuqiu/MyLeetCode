package com.github.xuqiu.leetcode.p_1_30;

import com.github.xuqiu.leetcode.ListNode;

import java.util.ArrayList;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-17 16:40
 */
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> array = new ArrayList<>(32);
        ListNode thisNode = head;
        int size = 1;
        array.add(thisNode);
        for (int i = 0; i < 32 && thisNode.next!=null; i++) {
            thisNode = thisNode.next;
            array.add(thisNode);
            size ++ ;
        }
        if(n==size){
            return head.next;
        }

        array.get(size-n-1).next=array.get(size-n).next;
        return head;
    }
    @Test
    public void test(){
        int[] list = {1,2,3,4,5};
        int n = 2;
        System.out.println(removeNthFromEnd(ListNode.of(list),n));
    }
}
