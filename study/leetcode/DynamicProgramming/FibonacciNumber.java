class FibonacciNumber {
    public int fib(int n) {
        if (0 == n) {
            return 0;
        }

        if (1 == n || 2 == n) {
            return 1;
        }

        int prev = 1, cur = 1;
        for (int i = 3; i <= n; i++) {
            int count = prev + cur;
            prev = cur;
            cur = count;
        }

        return cur;
    }
}