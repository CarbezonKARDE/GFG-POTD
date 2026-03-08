class Solution {
  public:
    bool pythagoreanTriplet(vector<int>& arr) {
        const int MAX = 1000;
        vector<int> freq(MAX + 1, 0);
        for(int x : arr)
            freq[x]++;
        for(int a = 1; a <= MAX; a++) {
            if(freq[a] == 0) continue;
            for(int b = a; b <= MAX; b++) {
                if(freq[b] == 0) continue;
                int c2 = a*a + b*b;
                int c = sqrt(c2);
                if(c*c == c2 && c <= MAX && freq[c] > 0) {
                    if(a == b && b == c) {
                        if(freq[a] >= 3) return true;
                    }
                    else if(a == b) {
                        if(freq[a] >= 2) return true;
                    }
                    else if(b == c) {
                        if(freq[b] >= 2) return true;
                    }
                    else if(a == c) {
                        if(freq[a] >= 2) return true;
                    }
                    else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
};
