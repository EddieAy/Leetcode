package ch9BinaryTree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import ch9BinaryTree.TreeNode;

public class Problem144 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4, node1, node2);
        TreeNode node6 = new TreeNode(6);
        TreeNode root = new TreeNode(5, node4, node6);

        // 调用函数
        List<Integer> res = preorderTraversal2(root);

        // 输出结果
        System.out.println(res);  // 应当输出 [5, 4, 1, 2, 6]
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,res);
        return res;
    }

    public static void traversal(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        traversal(root.left,res);
        traversal(root.right,res);
    }

    //迭代
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        if (root == null) return res;
        st.push(root);
        while (!st.isEmpty()){
            TreeNode temp = st.peek();
            st.pop();
            res.add(temp.val);
            if (temp.right != null) st.push(temp.right);
            if (temp.left != null) st.push(temp.left);
        }
        return res;

    }

}
