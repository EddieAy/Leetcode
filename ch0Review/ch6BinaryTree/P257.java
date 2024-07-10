package ch0Review.ch6BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        Deque<Integer> st = new ArrayDeque<>();
        if(root == null){
            return res;
        }
        dfs(root,res,st);
        return res;
    }

    private void dfs(TreeNode root, List<String> res, Deque<Integer> st) {
        if(root == null) return;

        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int val:st){
                sb.append(val).append("->");
            }
            sb.append(root.val);
            res.add(sb.toString());
            return;
        }

        st.add(root.val);
        dfs(root.left,res,st);
        dfs(root.right,res,st);
        st.removeLast();
    }
}
