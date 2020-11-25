package structure;

public class IsRing {

    public boolean isRing(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while(quick != null && quick.next != null) {
            quick = quick.next.next;    //快指针一次两个节点
            slow = slow.next;           //慢指针一次一个节点
            if  (quick == slow) {
                //如果快慢指针相遇则说明链表有环
                return true;
            }
        }
        //快慢指针没相遇则说明没环
        return false;
    }
}

//构建链表数据结构
class ListNode {
    int value;
    ListNode next;
    ListNode(int v, ListNode node) {
        this.value = v;
        this.next = node;
    }
}