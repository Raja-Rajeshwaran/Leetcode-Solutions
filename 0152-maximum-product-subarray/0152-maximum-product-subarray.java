class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
       int prod=1;
        int max=0;
        for(int i=0;i<nums.length;i++){
            prod*=nums[i];
            if(max<prod) max=prod;
            if(prod==0) prod=1;
        }
        int prod1=1;
        int max1=0;
        for(int i=nums.length-1;i>=0;i--){
            prod1*=nums[i];
            if(max1<prod1) max1=prod1;
            if(prod1==0) prod1=1;
        }
        return Math.max(max,max1); 
    }
}