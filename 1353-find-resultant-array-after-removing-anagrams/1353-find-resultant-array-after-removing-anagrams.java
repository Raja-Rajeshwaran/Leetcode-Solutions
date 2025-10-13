class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list=new ArrayList<>();
        list.add(words[0]);
        String prev=words[0];
        int j=0;
        for(int i=1;i<words.length;i++){
            if(!Anagram(list.get(j),words[i])){
                list.add(words[i]);
               j++;

            }
        }
        return list;
    }
    static boolean Anagram(String s,String t){
        int[] freq=new int[26];
        for(char c:s.toCharArray()) freq[c-'a']++;
        for(char c:t.toCharArray()) freq[c-'a']--;
        for(int i:freq) if(i!=0) return false;
        return true;
    }
}