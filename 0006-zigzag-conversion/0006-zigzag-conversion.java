class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] cycle=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            cycle[i]=new StringBuilder();
        }
        char[] str=s.toCharArray();
        int index=0, n=str.length;
        while(index<n){
            for(int i=0;i<numRows && index<n;i++){
                cycle[i].append(str[index++]);
            }
            for(int i=numRows-2;i>0 && index<n;i--){
                cycle[i].append(str[index++]);
            }
        }
        StringBuilder result=cycle[0];
        for(int i=1;i<numRows;i++){
            result.append(cycle[i]);
        }
        return result.toString();
    }
}