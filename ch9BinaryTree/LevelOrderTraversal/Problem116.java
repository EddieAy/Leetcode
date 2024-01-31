package ch9BinaryTree.LevelOrderTraversal;

/*
* You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
* */


import ch9BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem116 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    };

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root = connect2(root);
        printLevelNext(root.left);  // 应该输出：2 -> 3 -> NULL
        printLevelNext(root.left.left);
    }

    public static Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        Node rt = root;
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            while (len > 0){
                Node temp = queue.poll();
                len--;
                if (len > 0){
                    Node tempright = queue.peek();
                    temp.next = tempright;
                }
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
        }
        return rt;
    }
    public static Node connect2(Node root) {
        if(root == null) return null;

        if(root.left!=null){
            root.left.next = root.right;

            if(root.next!=null){
                root.right.next = root.next.left;
            }
            connect2(root.left);
            connect2(root.right);
        }
        return root;
    }

    private static void printLevelNext(Node node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }
}
