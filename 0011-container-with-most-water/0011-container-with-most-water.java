class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int maxArea=0;
        while(left<right){
            int minHeight=Math.min(height[left],height[right]);
            int area=minHeight*(right-left);
            maxArea=Math.max(maxArea,area);
            while(left<right && height[left]<=minHeight) left++;
            while(left<right && height[right]<=minHeight) right--;
        }
        return maxArea;
    }
}