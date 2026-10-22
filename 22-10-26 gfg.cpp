class Solution {
public:
    int minimumSum(string &s) {
        int n = s.size();
        for (int i = 0; i < n / 2; i++) {
            int j = n - 1 - i;
            if (s[i] != '?' && s[j] != '?' && s[i] != s[j]) {
                return -1;
            }
        }
        int m = (n + 1) / 2;
        vector<char> a(m);
        for (int i = 0; i < m; i++) {
            char left = s[i];
            char right = s[n - 1 - i];
            if (left != '?')
                a[i] = left;
            else if (right != '?')
                a[i] = right;
            else
                a[i] = '?';
        }
        for (int i = 0; i < m; ) {
            if (a[i] != '?') {
                i++;
                continue;
            }
            int j = i;
            while (j < m && a[j] == '?')
                j++;
            if (i == 0 && j == m) {
                for (int k = i; k < j; k++)
                    a[k] = 'a';
            } else if (i == 0) {
                for (int k = i; k < j; k++)
                    a[k] = a[j];
            } else if (j == m) {
                for (int k = i; k < j; k++)
                    a[k] = a[i - 1];
            } else {
                int l = a[i - 1] - 'a';
                int r = a[j] - 'a';
                char fill = (l <= r) ? a[i - 1] : a[j];

                for (int k = i; k < j; k++)
                    a[k] = fill;
            }
            i = j;
        }
        int sum = 0;
        for (int i = 1; i < n; i++) {
            char left = a[min(i, n - 1 - i)];
            char right = a[min(i - 1, n - i)];

            sum += abs(left - right);
        }
        return sum;
    }
};
