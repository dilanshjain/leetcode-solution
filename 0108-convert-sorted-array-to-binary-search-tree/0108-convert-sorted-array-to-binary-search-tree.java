
class Solution {
    public TreeNode sortedArrayToBST(int[] arr) {
        int n = arr.length;
        return convert(arr , 0 , n-1); 
    }

    public TreeNode convert(int[] arr , int low , int high){
        if(low > high)return null;
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = convert(arr , low , mid - 1);
        root.right = convert(arr , mid + 1 , high);
        return root;
    }
}