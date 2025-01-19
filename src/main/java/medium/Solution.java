package medium;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> setCh = new HashSet<>();
        int maxSize = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (setCh.contains(ch)) {
                setCh.remove(s.charAt(left));
                left++;
            }
            setCh.add(ch);
            maxSize = Math.max(maxSize, right - left + 1);
        }
        return maxSize;
    }
}
