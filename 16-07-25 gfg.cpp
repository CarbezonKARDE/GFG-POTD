class Solution {
  public:
    int countNumbers(int n) {
        vector<int> primes;
        int limit = sqrt(n) + 1;
        vector<bool> isPrime(limit + 1, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= limit; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i)
                    isPrime[j] = false;
            }
        }
        for (int i = 2; i <= limit; ++i) {
            if (isPrime[i]) primes.push_back(i);
        }
        int count = 0;
        for (int i = 0; i < primes.size(); ++i) {
            long long power = 1;
            for (int j = 0; j < 8; ++j) {
                power *= primes[i];
                if (power > n) break;
            }
            if (power <= n)
                count++;
        }
        int sz = primes.size();
        for (int i = 0; i < sz; ++i) {
            for (int j = i + 1; j < sz; ++j) {
                long long val = 1LL * primes[i] * primes[i] * primes[j] * primes[j];
                if (val <= n)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
};
