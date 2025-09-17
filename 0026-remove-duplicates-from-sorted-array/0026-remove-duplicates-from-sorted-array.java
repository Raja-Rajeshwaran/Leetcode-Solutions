class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1, i;
        for(i = 1;i < nums.length;i++) {
            if(nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}