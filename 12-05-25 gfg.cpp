class Solution {
  public:
    int mostBooked(int n, vector<vector<int>> &meetings) {
        sort(meetings.begin(), meetings.end());
        vector<int> roomCount(n, 0);
        vector<long long> roomEndTime(n, 0);
        priority_queue<int, vector<int>, greater<int>> availableRooms;
        for (int i = 0; i < n; i++) {
            availableRooms.push(i);
        }
        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> busyRooms;
        for (auto& meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;
            while (!busyRooms.empty() && busyRooms.top().first <= start) {
                availableRooms.push(busyRooms.top().second);
                busyRooms.pop();
            }
            if (!availableRooms.empty()) {
                int room = availableRooms.top();
                availableRooms.pop();
                roomCount[room]++;
                busyRooms.push({end, room});
            } else {
                long long endTime = busyRooms.top().first;
                int room = busyRooms.top().second;
                busyRooms.pop();
                roomCount[room]++;
                busyRooms.push({endTime + duration, room});
            }
        }
        int maxBookings = 0;
        int maxBookedRoom = 0;
        for (int i = 0; i < n; i++) {
            if (roomCount[i] > maxBookings) {
                maxBookings = roomCount[i];
                maxBookedRoom = i;
            }
        }
        return maxBookedRoom;
    }
};
