package medium;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(solution.compress(chars));
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
