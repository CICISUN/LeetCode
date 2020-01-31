import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class MinWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> dict = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        String res = "";
        for(char c: t.toCharArray()){
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }
        int start = 0, minWindow = Integer.MAX_VALUE, matched = 0;;
        for(int i=0; i<s.length(); i++) {
            if(dict.containsKey(s.charAt(i))) {   
                window.put(s.charAt(i), window.getOrDefault(s.charAt(i), 0) + 1);  
                if (window.get(s.charAt(i)) <= dict.get(s.charAt(i))) {
                    matched++;
                }
            }
            while(matched == t.length() && start<s.length()) {
                if(dict.containsKey(s.charAt(start))) {
                    window.put(s.charAt(start), window.get(s.charAt(start)) -1); 
                    if (window.get(s.charAt(start)) < dict.get(s.charAt(start))) {
                        matched--;
                    }
                    window.remove(s.charAt(start), 0);
                    if((i-start+1) < minWindow) {
                        minWindow = i-start+1; 
                        res = s.substring(start, i+1);
                    }
                }
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinWindow s = new MinWindow();
        System.out.println(s.minWindow("ADOBECODEBANC", "BANC"));
    }
}
// @lc code=end

