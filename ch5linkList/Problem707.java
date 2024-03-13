package ch5linkList;

//class ListNode{
//    ListNode next;
//    int val;
//    public ListNode(){};
//    public ListNode(int val){
//        this.val = val;
//    }
//    public ListNode(int val, ListNode node){
//        this.val = val;
//        this.next = node;
//    }
//}

public class Problem707 {

    int size;
    ListNode head;

    public Problem707() {
        size = 0;
        this.head = new ListNode(0);
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        int i = 0;
        ListNode node = head;
        while(i != index + 1){
            node = node.next;   // 1         
            i++;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0){
            index = 0;
        }
        if(index > size){
            return;
        }
        size++;
        ListNode pre = head;
        // 6    8
        for(int i = 0;i < index;i++){
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;

    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        size--;
        if(index == 0){
            head = head.next;
            return;
        }
        ListNode pre = head;
        for(int i = 0;i < index;i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */