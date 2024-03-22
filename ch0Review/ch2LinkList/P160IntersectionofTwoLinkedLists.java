package ch0Review.ch2LinkList;

public class P160IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA  == null || headB == null) return null;
        int lenA = 0;
        int lenB = 0;
        ListNode temp = headA;
        while (temp != null){
            lenA++;
            temp = temp.next;
        }
        temp = headB;
        while (temp!=null){
            lenB++;
            temp = temp.next;
        }
        ListNode nodeA = headA,nodeB = headB;
        if(lenA <= lenB){
            int diff = lenB - lenA;
            while (diff > 0){
                nodeB = nodeB.next;
                diff--;
            }
            while (nodeA != null){
                if(nodeA == nodeB){
                    return nodeA;
                }else {
                    nodeA = nodeA.next;
                    nodeB = nodeB.next;
                }
            }
            return null;
        }else {
            int diff = lenA - lenB;
            while (diff > 0){
                nodeA = nodeA.next;
                diff--;
            }
            while (nodeA != null){
                if(nodeA == nodeB){
                    return nodeA;
                }else {
                    nodeA = nodeA.next;
                    nodeB = nodeB.next;
                }
            }
            return null;
        }
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if(headA  == null || headB == null) return null;
        ListNode nodeA = headA,nodeB = headB;
        while (nodeA != nodeB){
            if(nodeA != null){
                nodeA = nodeA.next;
            }else {
                nodeA = headB;
            }
            if(nodeB != null){
                nodeB = nodeB.next;
            }else {
                nodeB = headA;
            }
        }
        return nodeA;
    }
}
