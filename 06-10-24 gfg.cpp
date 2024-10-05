class Solution {
  private:
  static const std::size_t theSize{8};
  int dx[theSize] = {1,1,1,-1,-1,-1,0,0};
  int dy[theSize] = {-1,0,1,-1,0,1,1,-1};
  int n{};
  int m{};
  std::function<bool(int,int)> isGood = [this](int i,int j){
      return i>=0 and j>=0 and i<n and j<m;
  };
  static const std::size_t theMaxSize{501};
  bool visited[theMaxSize][theMaxSize];
  int theIslands{};
  void dfs(int i,int j,const vector<vector<char>>& grid){
      visited[i][j]=true;
      for(int k{};k<theSize;++k){
          auto ni{i+dx[k]};
          auto nj{j+dy[k]};
          if(isGood(ni,nj) and grid[ni][nj]=='1' and !visited[ni][nj]){
              dfs(ni,nj,grid);
          }
      }
  }
  public:
    int numIslands(vector<vector<char>>& grid) {
        this->n=int(grid.size());
        this->m=int(grid.front().size());
        memset(visited,0,sizeof visited);
        for(int i{};i<n;++i){
            for(int j{};j<m;++j){
                if(grid[i][j]=='1' and !visited[i][j]){
                    dfs(i,j,grid);
                    ++theIslands;
                }
            }
        }
        return theIslands;
    }
};
