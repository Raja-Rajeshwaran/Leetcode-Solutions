class Solution {
    public String sortVowels(String s) {
        StringBuilder extracted=new StringBuilder();
        for(char c:s.toCharArray()) if("AEIOUaeiou".indexOf(c)!=-1) extracted.append(c);
        char[] vowelArray=extracted.toString().toCharArray();
        char[] array=s.toCharArray();
        Arrays.sort(vowelArray);
        int j=0;
        for(int i=0;i<array.length;i++){
            if("AEIOUaeiou".indexOf(array[i])!=-1){
                array[i]=vowelArray[j];
                j++;
            }
        }
        return String.valueOf(array);
    }
}