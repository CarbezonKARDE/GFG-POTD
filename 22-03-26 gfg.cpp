class Solution {
public:
    int orangesRot(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();
        queue<pair<int,int>> q;
        int fresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 2){
                    q.push({i, j});
                }
                else if(mat[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int time = 0;
        vector<int> dx = {-1, 1, 0, 0};
        vector<int> dy = {0, 0, -1, 1};
        while(!q.empty()){
            int sz = q.size();
            bool rotted = false;
            for(int i = 0; i < sz; i++){
                auto [x, y] = q.front();
                q.pop();
                for(int k = 0; k < 4; k++){
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && mat[nx][ny] == 1){
                        mat[nx][ny] = 2;
                        q.push({nx, ny});
                        fresh--;
                        rotted = true;
                    }
                }
            }
            if(rotted) time++;
        }
        return (fresh == 0) ? time : -1;
    }
};
