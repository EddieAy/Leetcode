package ch5linkList;

public class Problem142 {
    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head,slow = head;

        while (true){
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
