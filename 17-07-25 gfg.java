import java.util.*;
class Solution {
    public int maxKPower(int n, int k) {
        Map<Integer, Integer> primeFactors = factorize(k);
        int minPower = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int expInK = entry.getValue();
            int expInNFact = countPrimeInFactorial(n, prime);
            int possibleX = expInNFact / expInK;
            minPower = Math.min(minPower, possibleX);
        }
        return minPower;
    }
    private Map<Integer, Integer> factorize(int num) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                num /= i;
            }
        }
        if (num > 1) {
            factors.put(num, factors.getOrDefault(num, 0) + 1);
        }
        return factors;
    }
    private int countPrimeInFactorial(int n, int p) {
        int count = 0;
        while (n > 0) {
            n /= p;
            count += n;
        }
        return count;
    }
}
