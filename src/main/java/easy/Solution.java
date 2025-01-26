package easy;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution res = new Solution();
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(res.maxVowels2("nowels", 1));
    }

//    public int pivotIndex(int[] nums) {
//
//    }

    public int largestAltitude(int[] gain) {
        int max = 0;
        int curr = 0;
        for (int alt : gain) {
            curr += alt;
            max = Math.max(max, curr);
        }
        return max;
    }

    public int maxVowels(String s, int k) {
        int maxCount = 0;
        HashSet<Character> set = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
        int count = 0;
        int lIndex = 0;
        for (int rIndex = 0; rIndex < s.length(); rIndex++) {
            if (set.contains(s.charAt(rIndex))) {
                count++;
            }
            if (rIndex - lIndex == k - 1) {
                maxCount = Math.max(maxCount, count);
                if (set.contains(s.charAt(lIndex))) {
                    count--;
                }
                lIndex++;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    public int maxVowels2(String s, int k) {
        int maxCount = 0;
        HashSet<Character> set = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                count++;
            }
            if (i >= k -1) {
                maxCount = Math.max(maxCount, count);
                if (set.contains(chars[i -(k - 1)])) count--;
            }
            if (maxCount >= k) return k;
        }
        return maxCount;
    }

    public double findMaxAverage(int[] nums, int k) {
        double currentSum = 0;
        double maxAverage = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (i >= k - 1) {
                double curAve = currentSum / (double) k;
                maxAverage = Math.max(maxAverage, curAve);
                currentSum -= nums[i - (k - 1)];
            }
        }
        return maxAverage;
    }

    public int maxOperations(int[] nums, int k) {
        int operation = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            int complement = k - num;
            if (freqMap.getOrDefault(complement, 0) > 0) {
                operation++;
                freqMap.put(complement, freqMap.get(complement) - 1);
            } else {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        }
        return operation;
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int lIndex = 0;
        int rIndex = height.length - 1;
        while (lIndex < rIndex) {
            int size = rIndex - lIndex;
            int min = Math.min(height[lIndex], height[rIndex]);
            int currArea = size * min;
            maxArea = Math.max(maxArea, currArea);
            if (height[lIndex] < height[rIndex]) {
                int currentLeft = height[lIndex];
                while (lIndex < rIndex && height[lIndex] <= currentLeft) {
                    lIndex++;
                }
            } else {
                int currentRight = height[rIndex];
                while (lIndex < rIndex && height[rIndex] <= currentRight) {
                    rIndex--;
                }
            }
        }
        return maxArea;
    }

    public boolean isSubsequence(String s, String t) {
        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }

    public String reverseWords(String s) {
        String[] result = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            if (!result[i].isEmpty()) {
                stringBuilder.append(result[i]).append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] res = s.toCharArray();
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !vowels.contains(res[l])) {
                l++;
            }
            while (l < r && !vowels.contains(res[r])) {
                r--;
            }
            if (l < r) {
                char temp = res[l];
                res[l] = res[r];
                res[r] = temp;
                l++;
                r--;
            }
        }
        return new String(res);
    }


    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if (flowerbed.length == 1) {
            count = flowerbed[0] == 0 ? 1 : 0;
            return count >= n;
        } else if (flowerbed.length == 2) {
            count = (flowerbed[0] == 0 && flowerbed[1] == 0) ? 1 : 0;
            return count >= n;
        }
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            count++;
            flowerbed[0] = 1;
        }
        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            count++;
            flowerbed[flowerbed.length - 1] = 1;
        }
        for (int i = 2; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0) {
                if (flowerbed[i - 1] == 0 && flowerbed[i - 2] == 0) {
                    count++;
                    flowerbed[i - 1] = 1;
                }
            }
        }
        return count >= n;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (Integer can : candies) {
            max = can > max ? can : max;
        }
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Find the GCD of the lengths
        int gcdLength = gcd(str1.length(), str2.length());

        // The potential common divisor string
        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) stringBuilder.append(word1.charAt(i++));
            if (j < word2.length()) stringBuilder.append(word2.charAt(j++));
        }
        return stringBuilder.toString();
    }

    public static int argumentsLength(int[] args) {
        return args.length;
    }

    public static LinkedList<Integer> insertGreatestCommonDivisors(LinkedList<Integer> head) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < head.size() - 1; i++) {
            int f1 = head.get(i);
            int f2 = head.get(i + 1);
            int comD = commonDivisor(f1, f2);
            res.add(f1);
            res.add(comD);
        }
        res.add(head.get(head.size() - 1));
        return res;
    }

    private static int commonDivisor(int x, int y) {
        int temp = 1;
        int min = Math.min(x, y);
        for (int i = 1; i <= min; i++) {
            if (x % i == 0 && y % i == 0) {
                temp = i;
            }
        }
        return temp;
    }
}
