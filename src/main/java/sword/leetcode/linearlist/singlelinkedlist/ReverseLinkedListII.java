package sword.leetcode.linearlist.singlelinkedlist;

/**
 * @program: draft
 * @description:
 * Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example: Given 1->2->3->4->5->nullptr, m = 2 and n = 4,
 * return 1->4->3->2->5->nullptr.
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 *
 * Solution:
 * 方法一:
 * 第1步：先将待反转的区域反转;
 * 第2步：把 pre 的 next 指针指向反转以后的链表头节点，把反转以后的链表的尾节点的 next 指针指向 succ。
 * 注意: 链接什么时候切断，什么时候补上去，先后顺序一定要想清楚，如果想不清楚，可以在纸上模拟，让思路清晰。
 * 方法二:
 * 方法一的缺点是：如果 left 和 right 的区域很大，恰好是链表的头节点和尾节点时，
 * 找到 left 和 right 需要遍历一次，反转它们之间的链表还需要遍历一次，虽然总的时间复杂度为 O(N)，
 * 但遍历了链表 2 次，可不可以只遍历一次呢？答案是可以的。
 *
 * @author: atong
 * @create: 2021-02-26 10:13
 */
public class ReverseLinkedListII {

    public static void main(String[] args) {
        //构造链表
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        //循环打印链表
        ListNode head = listNode1;
        while (head != null) {
            if (head.next == null) {
                System.out.println(head.val);
            }else {
                System.out.print(head.val + " --> ");
            }
            head = head.next;
        }

        //反转链表
        reverseBetween(listNode1, 2, 4);

        //循环打印链表
        ListNode heada = listNode1;
        while (heada != null) {
            if (heada.next == null) {
                System.out.println(heada.val);
            }else {
                System.out.print(heada.val + " --> ");
            }
            heada = heada.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private static void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }



    public ListNode reverseBetweenII(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
