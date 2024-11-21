class Solution {
  public:
    double findSmallestMaxDist(vector<int> &stations, int k) {
        priority_queue<pair<double,int>>pq;
        int n=stations.size();
        vector<int>addedStations(n-1,0);
        for(int i=0;i<n-1;i++)
        {
            pq.push({stations[i+1]-stations[i],i});
        }
        for(int i=1;i<=k;i++)
        {
            auto top = pq.top(); pq.pop();
            int index = top.second;
            addedStations[index]++;
            double difference = stations[index+1]-stations[index];
            double numberSections =  addedStations[index]+1;
            double sectionDiff = difference / numberSections;
            pq.push({sectionDiff,index});
        }
        return round(pq.top().first * 100) / 100.0;
    }
};
