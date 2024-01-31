package ch9BinaryTree.LevelOrderTraversal;


/*
* Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.*/
public class Problem117 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right,Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    };
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        if(root == null) return root;

        Node cur = root;
        while (cur != null){
            Node dummy = new Node(0);
            Node pre = dummy;
            while (cur != null){
                if (cur.left != null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }


}
