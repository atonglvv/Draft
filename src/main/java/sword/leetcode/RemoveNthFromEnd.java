package sword.leetcode;

import sword.leetcode.linearlist.singlelinkedlist.ListNode;

/**
 * @program: draft
 * @description: 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 * @author: atong
 * @create: 2023-11-14 20:57
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        removeNthFromEnd(head, 3);
        System.out.println(head.val + "," + head.next.val + "," + head.next.next.val + "," + head.next.next.next.val);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 为什么这个地方要用dummy? 因为考虑head只有一个元素的时候,删除最后一个元素, 会导致 【second.next = second.next.next;】npe
        ListNode dummy = new ListNode(0, head);
        ListNode second = dummy;
        ListNode first = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while(first != null) {
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
