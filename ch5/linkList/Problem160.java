package ch5.linkList;

public class Problem160 {
    public static void main(String[] args) {
        int intersectVal = 8;
        int[] listAValues = {4, 1}; // Values before the intersection
        int[] listBValues = {5, 6, 1}; // Values before the intersection
        int[] commonValues = {8, 4, 5}; // Values at and after the intersection

        // Create non-intersecting parts of lists
        ListNode headA = createList(listAValues);
        ListNode headB = createList(listBValues);

        // Create intersecting part of lists
        ListNode common = createList(commonValues);

        // Attach the intersecting part to both lists
        appendList(headA, common);
        appendList(headB, common);

        // Test the method
        ListNode intersectionNode = getIntersectionNode(headA, headB);
        if (intersectionNode != null && intersectionNode.val == intersectVal) {
            System.out.println("Intersected at '" + intersectionNode.val + "'");
        } else {
            System.out.println("No intersection found.");
        }
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Utility method to create a list from an array
    private static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Utility method to find a node with a specific value
    private static ListNode findNode(ListNode head, int value) {
        while (head != null) {
            if (head.val == value) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    // Utility method to append a list to a node
    private static void appendList(ListNode node, ListNode appendHead) {
        while (node.next != null) {
            node = node.next;
        }
        node.next = appendHead;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode currentNode = headA;
        int lenA = 0,lenB = 0;
        while (currentNode != null){
            lenA++;
            currentNode = currentNode.next;
        }
        currentNode = headB;
        while (currentNode != null){
            lenB++;
            currentNode = currentNode.next;
        }
        int step;
        if (lenA <= lenB){
            step = lenB - lenA;
            currentNode = headB;
            while (step > 0){
                currentNode = currentNode.next;
                step--;
            }
            ListNode currentNodeA = headA;
            while (currentNode != null){
                if (currentNode == currentNodeA){
                    return currentNode;
                }else {
                    currentNode = currentNode.next;
                    currentNodeA = currentNodeA.next;
                }
            }
        }else {
            step = lenA - lenB;
            currentNode = headA;
            while (step > 0){
                currentNode = currentNode.next;
                step--;
            }
            ListNode currentNodeB = headB;
            while (currentNode != null){
                if (currentNode == currentNodeB){
                    return currentNode;
                }else {
                    currentNode = currentNode.next;
                    currentNodeB = currentNodeB.next;
                }
            }
        }

        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB){
            nodeA = (nodeA == null)?headB:headA.next;
            nodeB = (nodeB == null)?headA:headB.next;
        }

        return nodeA;
    }
}
