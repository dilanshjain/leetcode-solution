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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOf(preorder , preorder.length);
        Arrays.sort(inorder);
        int n = inorder.length;
        return build(0 , n-1 , 0 , n-1 , preorder , inorder);
    }

    TreeNode build(int prelow , int prehigh , int inlow , int inhigh , int[] preorder , int[] inorder){
        if(prelow > prehigh || inlow > inhigh) return null;
        int val = preorder[prelow];
        TreeNode root = new TreeNode(val);
        int r = 0;
        for(int i = inlow ; i <= inhigh ; i++){
            if(inorder[i] == val){
                r = i;
                break;
            }
        }

        int cnt = r-inlow;
        root.left = build(prelow + 1 , prelow + cnt , inlow , r-1 , preorder , inorder);
        root.right = build(prelow + cnt + 1 , prehigh , r+1 , inhigh , preorder , inorder);
        return root;
    }
}