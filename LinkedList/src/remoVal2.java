/**
 * Created by Administrator on 2018/11/6 0006.
 * leetcode 203 删除链表中等于给定值 val 的所有节点  使用虚拟头结点
 */
public class remoVal2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new remoVal2()).removeElements(head, 6);
        System.out.println(res);
    }
}
