
class Solution {
    public void inorder(TreeNode root , ArrayList<TreeNode> arr){
        if(root == null) return;
        inorder(root.left , arr);
        arr.add(root);
        inorder(root.right , arr);
    }
    public TreeNode bstToGst(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        inorder(root , arr);
        Collections.reverse(arr);
        int sum = 0;
        for(int i = 0 ; i < arr.size() ; i++){
            int val = arr.get(i).val;
            sum += val;
            arr.get(i).val = sum;
        }

        return root;

    }
}