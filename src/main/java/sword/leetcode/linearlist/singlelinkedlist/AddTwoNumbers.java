package sword.leetcode.linearlist.singlelinkedlist;

/**
 * @program: draft
 * @description:
 * Add Two Numbers
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Solution:
 * 由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。
 * 我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。
 * 具体而言，如果当前两个链表处相应位置的数字为 n1,n2，进位值为 carry，则它们的和为 n1+n2+carry；
 * 其中，答案链表处相应位置的数字为 (n1+n2+carry)%10，而新的进位值为(n1+n2+carry)/10
 * 如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个 0。
 * 此外，如果链表遍历结束后，有 carry>0，还需要在答案链表的后面附加一个节点，节点的值为 carry。
 * @author: atong
 * @create: 2021-02-25 10:15
 */
public class AddTwoNumbers {



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //声明链表result 头尾
        ListNode head = null, tail = null;
        //声明 进位
        int carry = 0;
        //遍历两个链表 逐位计算它们的和，并与当前位置的进位值相加。
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = head = new ListNode(sum % 10);
            }else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            //更新进位值
            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        //如果遍历完后,进位大于0 则需要加一个节点保存进位值[最高位]
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

}

