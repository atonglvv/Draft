package structure;

/**
 * 求两个无环链表的第一个相交节点。
 * 步骤：
 * 1.遍历两个链表，分别得到长度length1/length2和最后一个节点end1/end2。
 * 2.如果两个链表相交，end一定相同，否则，不相交，直接返回null。
 * 3.确定两个链表长度的差值，让长的链表先走差值这么大的步数，然后两个链表同时走，相遇的时候就是第一个相交节点。
 */
public class NoLoopPoint {

    public static ListNode noLoopPoint(ListNode node1, ListNode node2) {
        int length1 = 0;
        int length2 = 0;
        ListNode end1 = node1;
        ListNode end2 = node2;
        //获取链表1的长度length与最后一个节点end
        while(end1.next != null) {
            end1 = end1.next;
            length1++;
        }
        //获取链表2的长度length与最后一个节点end
        while(end2.next != null) {
            end2 = end2.next;
            length2++;
        }
        //计算两个链表的长度差
        int diff = Math.abs(length1 - length2);

        ListNode longNode = length1 > length2 ? node1 : node2;
        ListNode shortNode = length1 > length2 ? node2 : node1;

        //让长的链表先走差值这么大的步数
        for (int i = 0; i < diff; i++) {
            longNode = longNode.next;
        }
        //然后两个链表同时走，相遇的时候就是第一个相交节点。
        while (longNode != shortNode) {
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return longNode;
    }

}
