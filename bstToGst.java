/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Stack<TreeNode> st = new Stack<>();
    public TreeNode bstToGst(TreeNode root) {
         inOrder(root);
        int sum = 0;
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            sum += temp.val;
            temp.val = sum;
        }
        return root;
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        st.add(root);
        inOrder(root.right);
    }
}
