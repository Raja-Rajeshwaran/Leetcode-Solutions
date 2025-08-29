class Solution {
    public long flowerGame(int n, int m) {
       long even1=n/2;
       long even2=m/2;
       long odd1=n-even1;
       long odd2=m-even2;
       return ((even1*odd2)+(odd1*even2));
    }
}