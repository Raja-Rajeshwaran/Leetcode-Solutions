class Solution {
    public int totalMoney(int n) {
        int sum=0;
        int i=1;
        int end=7;
        while(n>0){
            for(int j=i;j<end+1 && n>0;j++){
                sum+=j;
                n--;
            }
            end++;
            i++;
            
        }
        return sum;
    }
}