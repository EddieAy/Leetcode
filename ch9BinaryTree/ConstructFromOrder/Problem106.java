package ch9BinaryTree.ConstructFromOrder;

import ch9BinaryTree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem106 {
    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode root = buildTree(inorder, postorder);

        // 打印结果
        printTreePreOrder(root);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder){
        if (inorder.length == 0 || postorder.length == 0) {
            return null;  // 当数组为空时，应返回null
        }
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);

        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
        }

        if(i > 0){//有左子树        inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
            //                   index = 1
            int[] leftInorder = Arrays.copyOfRange(inorder,0,i);
            int[] leftPostorder = Arrays.copyOfRange(postorder,0,i);
            root.left = buildTree(leftInorder,leftPostorder);
        }

        if(i < inorder.length - 1){//有右子树
            int[] rightInorder = Arrays.copyOfRange(inorder,i + 1,inorder.length);
            int[] rightPostorder = Arrays.copyOfRange(postorder,i,postorder.length - 1);
            root.right = buildTree(rightInorder,rightPostorder);
        }

        return root;
    }

    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
        if(inorder.length == 1){
            TreeNode temp1 = new TreeNode(inorder[0],null,null);
            return temp1;
        }else {
            int rootVal = postorder[postorder.length - 1];
            int i;
            for (i = 0; i < inorder.length; i++) {
                if(inorder[i] == rootVal){
                    break;
                }
            }
            int[] leftInorder;
            int[] rightInorder;
            int[] leftPostorder;
            int[] rightPostorder;
            TreeNode temp;
            if(i != inorder.length - 1 && i!= 0){
                leftInorder = Arrays.copyOfRange(inorder,0,i);
                rightInorder = Arrays.copyOfRange(inorder,i+1,inorder.length);
                leftPostorder = Arrays.copyOfRange(postorder,0,i);
                rightPostorder = Arrays.copyOfRange(postorder,i,postorder.length - 1);
                temp = new TreeNode(rootVal,buildTree(leftInorder,leftPostorder),buildTree(rightInorder,rightPostorder));
            }else if(i!=0){ //走到尾了 右子树为空

                leftInorder = Arrays.copyOfRange(inorder,0,i);
                rightInorder = new int[]{inorder[i]};
                leftPostorder = Arrays.copyOfRange(postorder,0,i);
                temp = new TreeNode(rootVal,buildTree(leftInorder,leftPostorder),buildTree(rightInorder,rightInorder));
            }else {
                leftInorder = new int[]{inorder[i]};
                rightInorder = Arrays.copyOfRange(inorder,i+1,inorder.length);
                rightPostorder = Arrays.copyOfRange(postorder,i,postorder.length - 1);
                temp = new TreeNode(rootVal,buildTree(leftInorder,leftInorder),buildTree(rightInorder,rightPostorder));
            }
            return temp;
        }
    }


    static Map<Integer,Integer> map;
    public static TreeNode buildTree3(int[] inorder, int[] postorder){
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return helper(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    private static TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int pstart, int pend) {
        if(instart >= inend || pstart >= pend){
            return null;
        }
        int rootIndex = map.get(postorder[pend - 1]);  //inside is value         map value --> index
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int leftNum = rootIndex - instart;
        root.left = helper(inorder,instart,rootIndex,postorder,pstart,pstart + leftNum);
        root.right = helper(inorder,rootIndex + 1,inend,postorder,pstart + leftNum,pend - 1);

        return root;
    }


    public static void printTreePreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            printTreePreOrder(node.left);
            printTreePreOrder(node.right);
        }
    }


}
