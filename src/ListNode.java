/**
 * ListNode
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-05-17 16:50
 */
public class ListNode {
    private int deep=0;
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int[] nums) {
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
}
