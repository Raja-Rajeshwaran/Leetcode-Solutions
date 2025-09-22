class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq=new int[101];
        for(int i:nums) freq[i]++;
        int max=Integer.MIN_VALUE;
        for(int i:freq) max=Math.max(i,max);
        int c=0;
        for(int i:nums) if(freq[i]==max) c++;
        return c;
    }
}