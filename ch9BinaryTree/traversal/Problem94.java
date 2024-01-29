package ch9BinaryTree.traversal;

import ch9BinaryTree.TreeNode;

import java.util.*;

public class Problem94 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4, node1, node2);
        TreeNode node6 = new TreeNode(6);
        TreeNode root = new TreeNode(5, node4, node6);


        // 调用函数
        List<Integer> res = inorderTraversal3(root);

        // 输出结果
        System.out.println(res);  // 应当输出 [5, 4, 1, 2, 6]
/*        TreeNode n1 = new TreeNode();
        if (n1.left == null) System.out.println("yes");
        System.out.println(n1.val);*/
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,res);
        return res;
    }

    public static void traversal(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        traversal(root.left,res);
        res.add(root.val);
        traversal(root.right,res);
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur!=null || !st.isEmpty()){
            if (cur!=null){
                st.push(cur);
                cur = cur.left;
            }else {
                cur = st.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    public static List<Integer> inorderTraversal3(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<Object> st = new LinkedList<>();
        if (root == null) return res;
        st.push("white");
        st.push(root);
        while (!st.isEmpty()){
            TreeNode cur = (TreeNode) st.pop();
            String color = (String) st.pop();
            if (cur == null) continue;
            if (color.equals("white")){
                st.push("white");
                st.push(cur.right);
                st.push("gray");
                st.push(cur);
                st.push("white");
                st.push(cur.left);
            }else {
                res.add(cur.val);
            }
        }
        return res;
    }


}
