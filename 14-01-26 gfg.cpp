class Solution {
public:
    int catchThieves(vector<char> &arr, int k) {
        vector<int> police, thieves;
        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] == 'P') police.push_back(i);
            else thieves.push_back(i);
        }
        int i = 0, j = 0, caught = 0;
        while (i < thieves.size() && j < police.size()) {
            if (abs(thieves[i] - police[j]) <= k) {
                caught++;
                i++;
                j++;
            }
            else if (thieves[i] < police[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        return caught;
    }
};
