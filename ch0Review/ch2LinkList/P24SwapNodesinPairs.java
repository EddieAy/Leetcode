package ch0Review.ch2LinkList;

public class P24SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode first = dummyHead.next;
        ListNode second;
        boolean flag = true;
        while (first != null){
            second = first.next;
            if(second == null){
                break;
            }else {
                ListNode temp = second.next;
                first.next = temp;
                second.next = first;
                first = temp;
                if(flag){
                    dummyHead.next = second;
                    flag = false;
                }
            }
        }
        return dummyHead.next;
    }

    public ListNode swapPairs2(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;

        while (prev.next!=null && prev.next.next!=null){
            ListNode first = prev.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;

            //这就是 我没想出来 出错的地方
            prev.next = second;
            prev = first;
        }
        return dummyHead.next;
    }
}
