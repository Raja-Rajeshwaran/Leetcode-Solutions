class Solution {
    List<String> letters=new ArrayList<>();
    String[] alphabets={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return letters;
        backtrack(digits,new StringBuilder(),0);
        return letters;
    }
    void backtrack(String digits,StringBuilder letter,int i){
        if(i==digits.length()){
            letters.add(letter.toString());
            return;
        }
        for(char c:alphabets[digits.charAt(i)-'2'].toCharArray()){
            letter.append(c);
            backtrack(digits,letter,i+1);
            letter.delete(letter.length()-1,letter.length());
        }
    }
}