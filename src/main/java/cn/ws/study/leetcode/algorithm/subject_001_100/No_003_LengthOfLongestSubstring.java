package cn.ws.study.leetcode.algorithm.subject_001_100;

import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 */
public class No_003_LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int length = start - i;
            for (int j = start; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    start = j;
                    break;
                }
                else {
                    set.add(s.charAt(j));
                    length++;
                }
            }
            if (length > max) {
                max = length;
            }
            set.remove(s.charAt(i));
        }

        return max;
    }
}
