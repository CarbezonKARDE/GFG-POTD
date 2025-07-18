class Solution {
public:
    long long gcd(long long a, long long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    long long lcm(long long a, long long b) {
        return (a * b) / gcd(a, b);
    }
    long long lcm(long long a, long long b, long long c) {
        return lcm(lcm(a, b), c);
    }
    int lcmTriplets(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 6;
        long long res = 0;
        if (n % 2 == 0) {
            res = max(res, lcm(n, n-1, n-3));
            res = max(res, lcm(n-1, n-2, n-3));
        } else {
            res = max(res, lcm(n, n-1, n-2));
        }
        res = max(res, lcm(n, n-1, n-2));
        res = max(res, lcm(n, n-1, n-3));
        res = max(res, lcm(n, n-2, n-3));
        res = max(res, lcm(n, n-1, n-4));
        res = max(res, lcm(n, n-3, n-4));
        return res;
    }
};
