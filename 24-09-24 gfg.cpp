class Solution
{
    public:
    string smallestWindow (string &s, string &p)
    {
        int n = s.length(), m = p.length();
        vector<int> freq(26, -1), vis(26, 0);
        for(int i = 0; i < m; i++) {
            if(freq[p[i] - 'a'] == -1) {
                freq[p[i] - 'a']++;
                vis[p[i] - 'a']++;
            }
            freq[p[i] - 'a']++;
        }
        int i = 0, j = 0;
        int cnt = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] != -1) {
                cnt++;
            }
        }
        int idx = -1, len = INT_MAX;
        while(j < n){
            if(vis[s[j] - 'a']){
                freq[s[j] - 'a']--;
                if(freq[s[j] - 'a'] == 0) {
                    cnt--;
                }
            }
            while(cnt == 0){
                
                if(j - i + 1 < len){
                    len = j - i + 1;
                    idx = i;
                }
                if(vis[s[i] - 'a']) {
                    freq[s[i] - 'a']++;
                    
                    if(freq[s[i] - 'a'] == 1){
                        cnt++;
                    }
                }
                i++;
            }
            j++;
        }
        if(idx == -1) return "-1";
        return s.substr(idx, len);
    }
};
