package ch9BinaryTree.LevelOrderTraversal;
/*
* Given an n-ary tree, return the level order traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal,
* each group of children is separated by the null value (See examples).*/

import ch9BinaryTree.TreeNode;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class Problem429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> res1 = new ArrayList<>();

            while (len > 0){
                Node temp = queue.poll();
                res1.add(temp.val);
                for (int i = 0; i < temp.children.size(); i++) {
                    if(temp.children.get(i) != null) queue.offer(temp.children.get(i));
                }
                len--;
            }
            res.add(res1);
        }
        return res;
    }
}
