class Solution {
 public ArrayList<ArrayList<Integer>> formCoils(int n) {
 int size = 4 * n;
 int total = size * size;
 int half = total / 2;
 int[][] mat = new int[size][size];
 int num = 1;
 for (int i = 0; i < size; i++) {
 for (int j = 0; j < size; j++) {
 mat[i][j] = num++;
 }
 }
 ArrayList<Integer> steps = new ArrayList<>();
 int s = size;
 steps.add(s);
 s -= 2;
 while (s > 0) {
 steps.add(s);
 steps.add(s);
 s -= 2;
 }
 int[] dr = {1, 0, -1, 0};
 int[] dc = {0, 1, 0, -1};
 ArrayList<Integer> coil1 = new ArrayList<>();
 int r = 0, c = 0;
 coil1.add(mat[r][c]);
 int dir = 0;
 int remaining = half - 1;
 int stepIdx = 0;
 while (remaining > 0 && stepIdx < steps.size()) {
 int step = steps.get(stepIdx);
 int moves = (stepIdx == 0) ? step - 1 : step;
 for (int i = 0; i < moves && remaining > 0; i++) {
 r += dr[dir];
 c += dc[dir];
 coil1.add(mat[r][c]);
 remaining--;
 }
 dir = (dir + 1) % 4;
 stepIdx++;
 }
 ArrayList<Integer> coil2 = new ArrayList<>();
 for (int val : coil1) {
 coil2.add(total + 1 - val);
 }
 ArrayList<ArrayList<Integer>> result = new ArrayList<>();
 result.add(coil1);
 result.add(coil2);
 return result;
 }
}
