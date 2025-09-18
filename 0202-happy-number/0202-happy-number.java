class Solution {
    public boolean isHappy(int n) {
        if(n==1){
            return true;
        } 
        return square(n);
    }
    public boolean square(int n){
        int copy = n;
        int count = 0,c=0;
        while(n!=0){
            count += (n%10)*(n%10);
            c++;
            n/=10;
        }
        if(count==1||copy==7){
            return true;
        }
        if(c>1){
        return square(count);
        }
        return false;
    }
}