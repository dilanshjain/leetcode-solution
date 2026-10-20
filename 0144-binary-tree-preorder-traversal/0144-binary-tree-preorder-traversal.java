class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(st.size() > 0){
            TreeNode top = st.pop();
            ans.add(top.val);
            if(top.right != null) st.push(top.right);
            if(top.left != null) st.push(top.left);
        }

        return ans;
    }
}