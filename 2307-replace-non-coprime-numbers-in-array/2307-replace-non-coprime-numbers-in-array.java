class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            stack.addLast(num); 
            while (stack.size() >= 2) {
                int a = stack.removeLast();
                int b = stack.removeLast();
                int g = gcd(a, b);
                if (g > 1) {
                    long lcm = lcm((long) a, (long) b);
                    stack.addLast((int) lcm);
                } else {
                    stack.addLast(b);
                    stack.addLast(a);
                    break;
                }
            }
        }
        return new ArrayList<>(stack);
    }

    private int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b,a%b);
    }

    private long lcm(long a, long b) {
        long g = gcd((int) a, (int) b); 
        return (a / g) * b;
    }
}
