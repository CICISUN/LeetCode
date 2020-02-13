import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int res=0, start=0;
        Set<Character> set =new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            while(set.contains(s.charAt(i))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(i));
            res = Math.max(res, i-start+1);
        }
        return res;
    }

    /**
     * build array to record current index of char
     *  int[26] for Letters 'a' - 'z' or 'A' - 'Z'
        int[128] for ASCII
        int[256] for Extended ASCII
     * @param s
     * @return
     * Time O(n) Space O(1)
     */

    public int lengthOfLongestSubstring2(String s) {
        int res=0, start=0;
        int[] arr = new int[128];
        for(int i=0; i<s.length(); i++) {
            start = Math.max(start, arr[s.charAt(i)]);
            res = Math.max(res, i-start+1);
            arr[s.charAt(i)] = i+1;
        }
        return res;
    }
    public static void main(String[] args) {
        LengthOfLongestSubstring s = new LengthOfLongestSubstring();
        System.out.println(s.lengthOfLongestSubstring2("tmmzuxt"));
    }
}
// @lc code=end