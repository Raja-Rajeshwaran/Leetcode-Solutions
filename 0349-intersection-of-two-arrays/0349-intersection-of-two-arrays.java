class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] freq1 = new int[1001];
        int[] freq2 = new int[1001];
        for(int i:nums1) freq1[i]++;
        for(int i:nums2) freq2[i]++;
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<1001;i++){
            if(freq1[i]>0&&freq2[i]>0) arr.add(i);
        }
        int[] arr1=new int[arr.size()];
        for(int i=0;i<arr.size();i++) arr1[i]=arr.get(i);
        return arr1;
    }
}