package hard;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        String res = "";
        int maxSize = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder temp = new StringBuilder();
            int size = 0;
            for (int j = i; j < s.length(); j++) {
                boolean status = false;
                temp.append(s.charAt(j));
                if ((temp.charAt(temp.length()) == s.charAt(j))) {
                    for (int k = j, t = j; k <= j + size; k++, t--) {
                        if (s.charAt(k) != temp.charAt(t)) {
                            status = true;
                            break;
                        }
                    }
                    if (!status) {
                        if (maxSize < (j + size)) {
                            maxSize = j + size;
                            res = s.substring(j, j + size);
                        }
                    }
                }
                if (status) {
                    break;
                }
                size++;
            }
        }
        return res;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int[] mergedArray = new int[size];
        for (int i = 0; i < nums1.length; i++) {
            mergedArray[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            mergedArray[nums1.length + i] = nums2[i];
        }
        Arrays.sort(mergedArray);
        int sum;
        if (mergedArray.length % 2 == 0) {
            sum = mergedArray[mergedArray.length / 2] + mergedArray[mergedArray.length / 2 - 1];
        } else {
            return mergedArray[mergedArray.length / 2];
        }
        return (double) sum / (double) 2;
    }
}
