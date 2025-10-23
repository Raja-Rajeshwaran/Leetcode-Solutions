class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb=new StringBuilder(s);
        while(sb.length()>2){
        StringBuilder ans=new StringBuilder();
            for(int i=0;i<sb.length()-1;i++){
                int a=(sb.charAt(i)-'0')+(sb.charAt(i+1)-'0');
                a%=10;
                ans.append((char)(a+'0'));
            }
            sb.setLength(0);
            sb.append(ans);
        }
        return sb.charAt(0)==sb.charAt(1);
    }
}