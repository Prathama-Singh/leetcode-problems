package com.example.hello.leet;

import java.util.HashSet;

public class LongestSubstring {

    public int getLongestSubstringWithUniqueChar(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args){
        LongestSubstring longestSubstring =  new LongestSubstring();
        System.out.println(longestSubstring.getLongestSubstringWithUniqueChar("abcabcbb"));
        System.out.println(longestSubstring.getLongestSubstringWithUniqueChar("bbbbb"));
        System.out.println(longestSubstring.getLongestSubstringWithUniqueChar("pwwkew"));
    }
}
