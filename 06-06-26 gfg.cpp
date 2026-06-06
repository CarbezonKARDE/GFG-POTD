class Solution {
public:
    int numOfWays(int n, int m) {
        long long cells = 1LL * n * m;
        long long total = cells * (cells - 1);
        long long attacking = 4LL * (
            1LL * (n - 1) * (m - 2) +
            1LL * (n - 2) * (m - 1)
        );
        return (int)(total - attacking);
    }
};
