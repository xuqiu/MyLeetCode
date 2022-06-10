package com.github.xuqiu.leetcode.p_1_30;
import com.github.xuqiu.leetcode.ListNode;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-18 15:47
 */
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode nextNode = head.next;
        if (nextNode != null) {
            head.next = swapPairs(nextNode.next);
            nextNode.next=head;
            return nextNode;
        }else{
            return head;
        }
    }
    @Test
    public void test(){
        System.out.println(swapPairs(ListNode.of(new int[]{1})));
    }
}
