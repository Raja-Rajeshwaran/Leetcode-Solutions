class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ls=new ArrayList<>();
        int[] first=intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] temp=intervals[i];
            if(temp[0]<=first[1]){
                first[1]=Math.max(first[1],temp[1]);
            }
            else{
                ls.add(first);
                first=temp;
            }
        }
        ls.add(first);
        return ls.toArray(new int[ls.size()][]);
    }
}