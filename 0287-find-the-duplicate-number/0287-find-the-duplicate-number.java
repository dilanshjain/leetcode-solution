class Solution {
    public int findDuplicate(int[] nums) {
      int i = 0;

      while(i<nums.length){
        int idx = nums[i] - 1;

        if(nums[i] == nums[idx]){
            if(i != idx){
                return nums[i];
            }
            i++;
        }
        else{
            swap(nums , i , idx);
        }
      }
      return -1;


    }

    private void swap(int[] nums , int i , int idx){
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    } 
}