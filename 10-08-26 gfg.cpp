class Solution {
public:
    int maxTask(vector<int>& h, vector<int>& l) {
        int n = h.size();
        int noTask = 0;
        int task = 0;
        for (int i = 0; i < n; i++) {
            int newNoTask = max(noTask, task);
            int low = max(noTask, task) + l[i];
            int high = noTask + h[i];
            int newTask = max(low, high);
            noTask = newNoTask;
            task = newTask;
        }
        return max(noTask, task);
    }
};
