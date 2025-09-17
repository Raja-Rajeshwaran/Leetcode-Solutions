class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) 
            return (Math.abs((dividend/divisor)+1));
        return dividend/divisor;
    }
}