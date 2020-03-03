import java.util.*;

class ShortestEncodeDecodeString{


    private static int i;
    //dfs O(K*n)
    public static String decodeStringDFS(String s) {
        StringBuilder sb = new StringBuilder();
        int num=0;
        for(;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='['){
                i++;
                String word = decodeStringDFS(s);
                for(int j=0; j<num; j++){
                    sb.append(word);
                }
                num=0;
            } else if (c==']'){
                return sb.toString();
            } else if(c>='0' && c<='9'){
                num=num*10+c-'0';
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //stack
    public static String decodeStringStack(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }

    //encode shortest https://www.jianshu.com/p/31f7207c3c24
    public static String encode(String s) {
        String[][] dp = new String[s.length()][s.length()];
        
        for(int l=0;l<s.length();l++) {
            for(int i=0;i<s.length()-l;i++) {
                int j = i+l;
                String substr = s.substring(i, j+1);
                // Checking if string length < 5. In that case, we know that encoding will not help.
                if(l < 4) {
                    dp[i][j] = substr;
                } else {
                    dp[i][j] = substr;
                    // Loop for trying all results that we get after dividing the strings into 2 and combine the results of 2 substrings
                    for(int k = i; k<j;k++) {
                        if((dp[i][k] + dp[k+1][j]).length() < dp[i][j].length()){
                            dp[i][j] = dp[i][k] + dp[k+1][j];
                        }
                    }
                    
                    // Loop for checking if string can itself found some pattern in it which could be repeated.
                    for(int k=0;k<substr.length();k++) {
                        String repeatStr = substr.substring(0, k+1);
                        if(repeatStr != null 
                           && substr.length()%repeatStr.length() == 0 
                           && substr.replaceAll(repeatStr, "").length() == 0) {
                              String ss = substr.length()/repeatStr.length() + "[" + dp[i][i+k] + "]";
                              if(ss.length() < dp[i][j].length()) {
                                dp[i][j] = ss;
                              }
                         }
                    }
                }
            }
        }
        
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        // System.out.println(decodeStringDFS("2[abc]3[cd]ef"));
        // System.out.println(decodeStringStack("2[abc]3[cd]ef"));
        System.out.println(encode("abbbabbbcabbbabbbc"));
    }
}