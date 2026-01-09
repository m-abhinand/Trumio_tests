class Ugly{
    public int nthUglyNumber(int n, int a, int b, int c) {
        long left = 1;
        long right = (long) n * Math.min(a, Math.min(b, c));

        long ab = lcm(a, b);
        long ac = lcm(a, c);
        long bc = lcm(b, c);
        long abc = lcm(a, (int) bc);

        while (left < right) {
            long mid = left + (right - left) / 2;

            long count =
                    mid / a + mid / b + mid / c
                            - mid / ab - mid / ac - mid / bc
                            + mid / abc;

            if (count < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) left;
    }

    private long lcm(int x, int y) {
        return (long) x * y / gcd(x, y);
    }

    private long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
