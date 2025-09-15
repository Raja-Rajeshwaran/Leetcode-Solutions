class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] textArray = text.split(" ");
        boolean[] brokenChars = new boolean[26];
        for(char c:brokenLetters.toCharArray()){
            brokenChars[c-'a']=true;
        }
        int count=0;
        for(String words:textArray){
            boolean hasBroken = true;
            if(isBroken(words,brokenChars)){
                hasBroken=false;
            }
            if(hasBroken){
                count++;
            }
        }
        return count;
    }
    boolean isBroken(String words,boolean[] brokenChars){
        for(char word:words.toCharArray()){
            if(brokenChars[word-'a']) return true;
        }
        return false;
    }
}