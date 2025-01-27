package medium;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution result = new Solution();
        int[][] grid = new int[2][2];
        System.out.println(result.equalPairs(grid));
    }

    public int equalPairs(int[][] grid) {
        int answer = 0;

        return answer;
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        // Maps to count frequency of each character
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Fill maps with character frequencies
        for (char ch : word1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : word2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        // Check if both maps have the same characters
        if (!map1.keySet().equals(map2.keySet())) return false;

        // Check if the frequency distributions match
        int[] freq1 = new int[map1.size()];
        int[] freq2 = new int[map2.size()];

        int index = 0;
        for (Integer val : map1.values()) {
            freq1[index++] = val;
        }

        index = 0;
        for (Integer val : map2.values()) {
            freq2[index++] = val;
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        // Compare the sorted frequency arrays
        return Arrays.equals(freq1, freq2);
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int maxLen = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public int compress(char[] chars) {
        int write = 0;
        int read = 0;
        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }
            chars[write++] = currentChar;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write;
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] results = new int[length];
        results[0] = 1;
        for (int i = 1; i < length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }
        System.out.println(Arrays.toString(results));
        int suffixProduct = 1;
        for (int i = length - 1; i >= 0; i--) {
            results[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return results;
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
