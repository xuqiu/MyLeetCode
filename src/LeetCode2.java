import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-04-18 22:35
 */
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultFather = new ListNode(0);
        ListNode last = resultFather;
        int inc = 0;
        while(l1 != null || l2 != null){
            int n1 = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            int n2 = 0;
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }
            int curVal = n1 + n2 + inc;
            final ListNode curNode = new ListNode(curVal % 10);
            last.next= curNode;
            last = curNode;
            inc = curVal/10;
        }
        if(inc == 1){
            last.next = new ListNode(1);
        }
        return resultFather.next;

    }

    @Test
    public void test(){
        int[] l1 = {9}, l2 = {1,9,9,9,9,9,9,9,9,9};
        final ListNode listNode = addTwoNumbers(ListNode.of(l1), ListNode.of(l2));
        System.out.println(listNode.toString());
    }


}
