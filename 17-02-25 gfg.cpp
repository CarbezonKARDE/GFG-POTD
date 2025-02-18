class Solution {
  public:
  int distance(const vector<int>& p) {
        return p[0] * p[0] + p[1] * p[1];
    }
    int partition(vector<vector<int>>& points, int left, int right) {
        int pivot = distance(points[right]);
        int i = left;
        for (int j = left; j < right; j++) {
            if (distance(points[j]) <= pivot) {
                swap(points[i], points[j]);
                i++;
            }
        }
        swap(points[i], points[right]);
        return i;
    }
    void quickSelect(vector<vector<int>>& points, int left, int right, int k) {
        if (left >= right) return;
        int pivotIndex = partition(points, left, right);
        if (pivotIndex == k) return;
        else if (pivotIndex < k)
            quickSelect(points, pivotIndex + 1, right, k);
        else
            quickSelect(points, left, pivotIndex - 1, k);
    }
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        quickSelect(points, 0, points.size() - 1, k);
        return vector<vector<int>>(points.begin(), points.begin() + k);
    }
};
