package ch9BinaryTree.ConstructFromOrder;

import ch9BinaryTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem654 {

    public static void main(String[] args) {
        int[] a = {3,2,1,6,0,5};
        TreeNode root = new Problem654().constructMaximumBinaryTree(a);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length);
    }

    public TreeNode constructMaximumBinaryTree2(int[] nums){
        Stack<TreeNode> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode node = new TreeNode(nums[i]);
            while (!st.isEmpty()){
                TreeNode top = st.peek();
                if (top.val > node.val){
                    st.push(node);
                    top.right = node;
                    break;
                }else {
                    st.pop();
                    node.left = top;
                }
            }
            if(st.isEmpty()) st.push(node);
        }
        return st.peek();
    }

    public TreeNode helper(int[] nums,int start,int end){
        if(start >= end) return null;
        if(end - start == 1){
            TreeNode temp = new TreeNode(nums[start]);
            temp.left = null;
            temp.right = null;
            return temp;
        }
        int index = getMax(nums,start,end);
        TreeNode root = new TreeNode(nums[index]);
        if(index != start && index != end - 1){
            root.left = helper(nums,start,index);
            root.right = helper(nums,index + 1,end);
        }else if(index == start){
            root.left = null;
            root.right = helper(nums,start + 1,end);
        }else {
            root.left = helper(nums,start,end - 1);
            root.right = null;
        }
        return root;
    }


    public TreeNode helper2(int[] nums,int start,int end){
        if(start >= end) return null;
        int index = getMax(nums,start,end);

        TreeNode root = new TreeNode(nums[index]);
        root.left = helper2(nums,start,index);
        root.right = helper2(nums,index + 1,end);
        return root;
    }
    public int getMax(int[] nums,int start,int end){
        if (nums.length == 1) return start;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i < end; i++) {
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
