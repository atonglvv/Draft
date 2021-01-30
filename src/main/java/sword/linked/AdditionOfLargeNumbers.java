package sword.linked;

/**
 * @Auther: carver
 * @Date: 2019/3/6 19:49
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 * Addition of large numbers
 */
public class AdditionOfLargeNumbers {

    public static void main(String[] args) {

        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        System.out.println(new AdditionOfLargeNumbers().addTwoNumbers(a1, b1).val);
        System.out.println(new AdditionOfLargeNumbers().addTwoNumbers(a1, b1).next.val);
        System.out.println(new AdditionOfLargeNumbers().addTwoNumbers(a1, b1).next.next.val);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return result.next;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}