class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        String palindrome="";
        for(int i=1;i<s.length();i++){
            palindrome=expand(s,i,i,palindrome);
            palindrome=expand(s,i-1,i,palindrome);
        }
        return palindrome;
    }
    String expand(String s,int l,int r,String result){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        String palindrome=s.substring(l+1,r);
        if(result.length()<palindrome.length()){
            result=palindrome;
        }
        return result;
    }
}