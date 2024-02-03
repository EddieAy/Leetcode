package ch9BinaryTree.ConstructFromOrder;

import ch9BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Problem105 {
    public static void main(String[] args) {
        Problem105 solution = new Problem105();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};

        solution.buildTree(pre,in);
    }

    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(inorder,0,inorder.length,preorder,0,preorder.length);
    }

    private TreeNode helper(int[] inorder, int istart, int iend, int[] preorder, int pstart, int pend) {
        if(istart >= iend || pstart >= pend){
            return null;
        }

        int rootIndex = map.get(preorder[pstart]);//最大的错误 全局 不能用0 用下标
        int rootVal = inorder[rootIndex];
        int leftNum = rootIndex - istart;

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(inorder,istart,rootIndex,preorder,pstart + 1,pstart + 1 + leftNum);
        root.right = helper(inorder,rootIndex + 1,iend,preorder,pstart + 1 + leftNum,pend);

        return root;
        //preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        //     left 0 1
    }
}
