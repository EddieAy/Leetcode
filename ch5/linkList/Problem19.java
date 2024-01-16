package ch5.linkList;

/*19. 删除链表的倒数第 N 个结点*/
public class Problem19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 打印原始链表
        printList(head);

        // 反转链表
        head = removeNthFromEnd(head,2);

        // 打印反转后的链表
        printList(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode slow = dummyHead.next;
        ListNode fast = dummyHead.next;      // 1 2 3 4 5           2
        ListNode preSlow = dummyHead;
        int i = 0;

        while (i != n){
            fast = fast.next;
            i++;
        }

        while (fast != null){
            preSlow = slow;
            slow = slow.next;
            fast = fast.next;
        }
        preSlow.next = slow.next;

        return dummyHead.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
