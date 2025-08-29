class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=1;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int index = j-i;
                if(nums[index]+nums[j]==target) return new int[]{index,j};
            }
        }
        return new int[]{-1,-1};
    }
}