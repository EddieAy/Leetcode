package ch5linkList;

public class Problem206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 打印原始链表
        printList(head);

        // 反转链表
        head = reverseList(head);

        // 打印反转后的链表
        printList(head);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode currentNode = head;
        ListNode preNode = null;
        while (currentNode != null){
            ListNode temp = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = temp;
        }

        return preNode;
    }

    public static ListNode reverseList2(ListNode head) {
        // 边缘条件判断
        if (head == null) return null;
        if (head.next == null) return head;
        // 递归调用，翻转第二个节点开始往后的链表
        ListNode last = reverseList2(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;//head.next 指的是 4的next 5 的next  指向了 4
        // 此时的 head 节点为尾节点，next 需要指向 NULL
        head.next = null;      //4的next 指向了Null
        return last;
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
