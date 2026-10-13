class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        boolean pInLeft = exists(root.left , p.val);
        boolean qInLeft = exists(root.left , q.val);
        if(pInLeft && qInLeft) return lowestCommonAncestor(root.left , p , q);
        else if(!pInLeft && !qInLeft) return lowestCommonAncestor(root.right , p , q);
        else return root;
    }

    private boolean exists(TreeNode root , int data){
        if(root == null) return false;
        if(root.val == data) return true;
        return exists(root.left , data) || exists(root.right , data);
    }
}