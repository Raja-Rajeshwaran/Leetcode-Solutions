class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set=new HashSet<>();
        HashMap<String, String> wordMap=new HashMap<>();
        HashMap<String, String> computed=new HashMap<>();
        for(String word:wordlist){
            set.add(word);
            wordMap.putIfAbsent(word.toLowerCase(),word);
            computed.putIfAbsent(change(word.toLowerCase()),word);
        }
        String[] corrected=new String[queries.length];
        int i=0;
        for(String query:queries){
            if(set.contains(query)) corrected[i]=query;
            else if(wordMap.containsKey(query.toLowerCase())) corrected[i]=wordMap.get(query.toLowerCase());
            else if(computed.containsKey(change(query.toLowerCase()))) corrected[i]=computed.get(change(query.toLowerCase())); 
            else corrected[i]="";
            i++;
        }
        return corrected;
    }
    String change(String word){
        char[] arr=word.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='a' || arr[i]=='e' || arr[i]=='o' || arr[i]=='i' || arr[i]=='u'){
                arr[i]='*';
            }
        }
        return String.valueOf(arr);
    }
}