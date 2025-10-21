class Solution {
    public int trailingZeroes(int num) {
        int zero = 0;
        while (num > 0) {
            zero += num / 5;
            num /= 5;
        }
        return zero;
    }
}