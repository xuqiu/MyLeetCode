package com.github.xuqiu.leetcode.p_1_25;

import com.github.xuqiu.leetcode.ListNode;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-17 18:00
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultFather = new ListNode(0);
        ListNode currentNode = resultFather;
        for (int i = 0; i <100; i++) {
            if (list1 == null) {
                currentNode.next=list2;
                break;
            }
            if (list2 == null) {
                currentNode.next=list1;
                break;
            }
            if(list1.val < list2.val){
                currentNode.next=list1;
                list1=list1.next;
            }else{
                currentNode.next=list2;
                list2=list2.next;
            }
            currentNode=currentNode.next;
        }
        return resultFather.next;
    }
    @Test
    public void test(){
        int[] l1 = {1,2,4};
        int[] l2 = {1,3,4};
        System.out.println(mergeTwoLists(ListNode.of(l1), ListNode.of(l2)));
    }
}
