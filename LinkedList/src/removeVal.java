/**
 * Created by Administrator on 2018/11/6 0006.
 * leetcode 203 删除链表中等于给定值 val 的所有节点
 */
public class removeVal {
    public ListNode removeElements(ListNode head, int val) {

        // 头结点
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        // 所有结点都需要删除
        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }
}
