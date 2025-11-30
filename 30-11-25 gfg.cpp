class Solution {
public:
    struct State {
        int link;
        int len;
        int next[26];
        State() {
            link = -1;
            len = 0;
            fill(next, next + 26, -1);
        }
    };
    vector<State> st;
    int last;

    void sa_init() {
        st.clear();
        st.push_back(State());
        last = 0;
    }
    void sa_extend(char c) {
        int cur = st.size();
        st.push_back(State());
        st[cur].len = st[last].len + 1;
        int p = last;
        int cidx = c - 'a';
        while (p != -1 && st[p].next[cidx] == -1) {
            st[p].next[cidx] = cur;
            p = st[p].link;
        }
        if (p == -1) {
            st[cur].link = 0;
        } else {
            int q = st[p].next[cidx];
            if (st[p].len + 1 == st[q].len) {
                st[cur].link = q;
            } else {
                int clone = st.size();
                st.push_back(st[q]);
                st[clone].len = st[p].len + 1;

                while (p != -1 && st[p].next[cidx] == q) {
                    st[p].next[cidx] = clone;
                    p = st[p].link;
                }

                st[q].link = st[cur].link = clone;
            }
        }
        last = cur;
    }
    int countSubs(string &s) {
        sa_init();
        for (char c : s)
            sa_extend(c);

        long long ans = 0;
        for (int i = 1; i < st.size(); i++) {
            ans += st[i].len - st[st[i].link].len;
        }
        return ans;
    }
};
