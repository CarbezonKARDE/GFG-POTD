class Solution {
  public:
    struct meeting {
        int start;
        int end;
        int index;
    };
    static bool compare(meeting m1,meeting m2){
        if(m1.end == m2.end){
            return m1.index < m2.index;
        }
        return m1.end < m2.end;
    }
    int maxMeetings(int n, int start[], int end[]) {
        vector<meeting> meetings(n);
        for(int i=0; i < n; i++){
            meetings[i].start = start[i];
            meetings[i].end = end[i];
            meetings[i].index = i;
        }
        sort(meetings.begin(),meetings.end(),compare);
        int count = 1;
        int lastEndTime = meetings[0].end;
        for(int i=1; i < n ; i++){
            if(meetings[i].start > lastEndTime){
                count++;
                lastEndTime = meetings[i].end;
            }
        }
        return count;
    }
};
