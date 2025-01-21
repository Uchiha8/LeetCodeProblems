package easy;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution res = new Solution();
        System.out.println(res.reverseWords("a good   example"));
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

    // Helper method to find the GCD of two numbers
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
