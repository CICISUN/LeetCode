/*
 * @lc app=leetcode id=1234 lang=java
 *
 * [1234] Replace the Substring for Balanced String
 */

// @lc code=start
class BalancedString {

        public int balancedString(String s) {
            int limit = s.length() / 4;
            int start = 0, minLen=Integer.MAX_VALUE; 
            int[] count = new int[128];
            for(int i=0; i<s.length(); i++) {
                count[s.charAt(i)]++;
            }
            for(int i=0; i<s.length(); i++) {
                count[s.charAt(i)]--;
                while(start < s.length() &&
                     count['Q'] - limit <=0 &&     
                      count['W'] - limit <=0 &&   
                      count['E'] - limit <=0 &&   
                      count['R'] - limit <=0) {
                    count[s.charAt(start)]++;
                    minLen = Math.min(minLen, i-start+1);
                    start++;
                }
            }
            return minLen;
        }
    
    public static void main(String[] args) {
        BalancedString s = new BalancedString();
        System.out.println(s.balancedString("QWER"));
    }
}
// @lc code=end

