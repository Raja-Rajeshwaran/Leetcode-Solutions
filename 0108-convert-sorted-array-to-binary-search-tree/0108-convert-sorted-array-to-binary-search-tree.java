class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return produce(nums,0,nums.length-1);
    }
    TreeNode produce(int[] nums,int start,int end){
        if(start>end) return null;
        int mid=(start+end)/2;
        TreeNode t=new TreeNode(nums[mid]);
        t.left=produce(nums,start,mid-1);
        t.right=produce(nums,mid+1,end);
        return t;
    }
}