package sword.leetcode.linearlist.singlelinkedlist;

/**
 * @program: draft
 * @description:
 * Definition for singly-linked list.
 * @author: atong
 * @create: 2021-02-26 09:32
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
