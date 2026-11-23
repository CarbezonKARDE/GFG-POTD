class Solution {
    public char posInfinite(String s, int pos) {
        long length = s.length();
        long p = pos;
        long step = 1;
        while (length < p) {
            length = 2 * length + step;
            step++;
        }
        step--;
        while (step > 0) {
            long previousLength = (length - step) / 2;
            if (p <= previousLength) {
                length = previousLength;
                step--;
                continue;
            }
            if (p <= previousLength + step) {
                return '$';
            }
            p = length - p + 1;
            length = previousLength;
            step--;
        }
        return s.charAt((int) p - 1);
    }
}
