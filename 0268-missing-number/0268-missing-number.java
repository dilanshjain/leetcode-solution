class Solution {
    int missingNumber(int arr[]) {
        
        int n = arr.length;
        int i = 0;
        while(i<arr.length){
            if(arr[i] == i || arr[i] == n) i++;
            else{
                int idx = arr[i];
                swap(arr , i , idx);
            }
        }
        for(i = 0 ; i < n ; i++){
            if(arr[i] != i) return i;
        }
        return n;
    }
    
    private void swap(int[] arr , int i , int idx){
        int temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }
    
    
}