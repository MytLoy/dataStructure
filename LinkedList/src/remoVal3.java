/**
 * Created by Administrator on 2018/11/8 0008.
 * leetcode 203 删除链表中等于给定值 val 的所有节点  递归链表
 */
public class remoVal3 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        head.next =  removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new remoVal3()).removeElements(head, 6);
        System.out.println(res);
    }
}
