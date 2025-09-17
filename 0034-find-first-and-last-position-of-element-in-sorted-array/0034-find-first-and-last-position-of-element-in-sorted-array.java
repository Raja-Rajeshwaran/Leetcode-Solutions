class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index1=binarySearch(nums,target,true);
        int index2=binarySearch(nums,target,false);
        return new int[]{index1,index2};
    }
    int binarySearch(int[] nums,int target,boolean found){
        int start=0,end=nums.length-1;
        int index=-1;
        while(start<=end){
            int mid=start+(end-start)/2; 
            if(nums[mid]==target){
                index=mid;
                if(found){
                    end=mid-1;
                }
                else start=mid+1;
            }
            else if(nums[mid]<target) start=mid+1;
            else end=mid-1;
        }
        return index;
    }
    //     StringBuilder sb=new StringBuilder();
    // for(int i:nums){
    //     sb.append(i+"");
    // }
    //     //System.out.println(sb);
    //     int index1=sb.indexOf(target+"");
    //     if(index1!=-1){
    //         int index2=sb.lastIndexOf(target+"");
    //         return new int[]{index1,index2};
    //     }
    //     return new int[]{-1,-1};
}