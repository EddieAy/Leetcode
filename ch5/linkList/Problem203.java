package ch5.linkList;

public class Problem203 {
    public static void main(String[] args) {

    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode virtualHead = new ListNode();
        virtualHead.next = head;

        if (head == null){
            return null;
        }else {
            ListNode preHead = virtualHead;
            ListNode currentNode = preHead.next;

            while (currentNode != null){
                if(currentNode.val == val){
                    preHead.next = currentNode.next;
                }else {
                    preHead = currentNode;
                }
                currentNode = currentNode.next;

            }
        }

        return virtualHead.next;
    }
}
