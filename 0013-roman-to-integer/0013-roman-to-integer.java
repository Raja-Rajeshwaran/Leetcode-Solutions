class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int prev = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int value = 0;
            
            if (c == 'I') value = 1;
            else if (c == 'V') value = 5;
            else if (c == 'X') value = 10;
            else if (c == 'L') value = 50;
            else if (c == 'C') value = 100;
            else if (c == 'D') value = 500;
            else if (c == 'M') value = 1000;

            if (value < prev) {
                sum -= value;
            } else {
                sum += value;
            }
            
            prev = value;
        }
        
        return sum;
    }
}