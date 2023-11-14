package sword.leetcode.linearlist;

import java.util.List;

/**
 * @program: draft
 * @description: 重排链表
 * https://leetcode.cn/problems/reorder-list
 * https://leetcode.cn/problems/middle-of-the-linked-list/(找链表中点)
 * https://leetcode.cn/problems/reverse-linked-list/(反转列表)
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 *
 * 提示：
 * 链表的长度范围为 [1, 5 * 104]
 * 1 <= node.val <= 1000
 *
 * @author: atong
 * @create: 2023-11-14 16:13
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNodeA head = new ListNodeA(1);
        ListNodeA listNode2 = new ListNodeA(2);
        ListNodeA listNode3 = new ListNodeA(3);
        ListNodeA listNode4 = new ListNodeA(4);
        ListNodeA listNode5 = new ListNodeA(5);

        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        System.out.println(head.val + "," + head.next.val + "," + head.next.next.val + "," + head.next.next.next.val + "," + head.next.next.next.next.val);

        ReorderList.reorderList(head);

        System.out.println(head.val + "," + head.next.val + "," + head.next.next.val + "," + head.next.next.next.val + "," + head.next.next.next.next.val);

    }


    public static void reorderList(ListNodeA head) {
        if (null == head) {
            return;
        }
        ListNodeA mid = middleNode(head);
        ListNodeA l1 = head;
        ListNodeA l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    /**
     * 找到原链表的中点
     * https://leetcode.cn/problems/middle-of-the-linked-list/
     */
    private static ListNodeA middleNode(ListNodeA head) {
        ListNodeA slow = head;
        ListNodeA fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 列表反转
     * https://leetcode.cn/problems/reverse-linked-list/
     */
    private static ListNodeA reverseList(ListNodeA head) {
        ListNodeA prev = null;
        ListNodeA curr = head;
        while (curr != null) {
            ListNodeA tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        return prev;
    }

    private static void mergeList(ListNodeA l1, ListNodeA l2) {
        ListNodeA l1Temp;
        ListNodeA l2Temp;
        while(l1 != null && l2 != null) {
            l1Temp = l1.next;
            l2Temp = l2.next;

            l1.next = l2;
            l1 = l1Temp;

            l2.next = l1;
            l2 = l2Temp;
        }
    }

}
class ListNodeA {
    int val;
    ListNodeA next;
    ListNodeA() {}
    ListNodeA(int val) { this.val = val; }
    ListNodeA(int val, ListNodeA next) { this.val = val; this.next = next; }
}