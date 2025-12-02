#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
private:
    const long long UNREACHABLE = -2e18;

public:
    int maxScore(string &s, vector<vector<char>> &jumps) {
        int N = s.length();
        if (N == 0) return 0;

        vector<vector<bool>> is_valid_jump(26, vector<bool>(26, false));
        for (const auto& jump : jumps) {
            is_valid_jump[jump[0] - 'a'][jump[1] - 'a'] = true;
        }
        for (int i = 0; i < 26; ++i) {
            is_valid_jump[i][i] = true;
        }

        vector<long long> P(N + 1, 0);
        for (int k = 0; k < N; ++k) {
            P[k + 1] = P[k] + (int)s[k];
        }

        vector<vector<int>> CountPrefix(26, vector<int>(N + 1, 0));
        for (int k = 0; k < N; ++k) {
            int char_idx = s[k] - 'a';
            for (int c = 0; c < 26; ++c) {
                CountPrefix[c][k + 1] = CountPrefix[c][k];
            }
            CountPrefix[char_idx][k + 1]++;
        }

        vector<long long> DP(N, UNREACHABLE);
        DP[0] = 0;

        vector<long long> Global_Max_Prev(26, UNREACHABLE);

        char s0 = s[0];
        int s0_idx = s0 - 'a';
        for (int target_c_idx = 0; target_c_idx < 26; ++target_c_idx) {
            if (is_valid_jump[s0_idx][target_c_idx]) {
                long long new_prefix_score = DP[0] - 0; 
                Global_Max_Prev[target_c_idx] = max(Global_Max_Prev[target_c_idx], new_prefix_score);
            }
        }

        for (int j = 1; j < N; ++j) {
            char c = s[j];
            int c_idx = c - 'a';
            long long ascii_c = (long long)c;
            
            long long Term_A = P[j] - (long long)CountPrefix[c_idx][j] * ascii_c;

            if (Global_Max_Prev[c_idx] != UNREACHABLE) {
                 DP[j] = Term_A + Global_Max_Prev[c_idx];
            }
            
            if (DP[j] == UNREACHABLE) continue;

            char s1 = s[j];
            int s1_idx = s1 - 'a';

            for (int target_c_idx = 0; target_c_idx < 26; ++target_c_idx) {
                if (is_valid_jump[s1_idx][target_c_idx]) {
                    char target_c = 'a' + target_c_idx;
                    long long ascii_target_c = (long long)target_c;
                    
                    long long Term_B = P[j] - (long long)CountPrefix[target_c_idx][j] * ascii_target_c;
                    
                    long long new_prefix_score = DP[j] - Term_B;

                    Global_Max_Prev[target_c_idx] = 
                        max(Global_Max_Prev[target_c_idx], new_prefix_score);
                }
            }
        }

        long long max_score = 0;
        for (long long score : DP) {
            max_score = max(max_score, score);
        }

        return (int)max_score;
    }
};
