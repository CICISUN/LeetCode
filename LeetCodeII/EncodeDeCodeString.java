/**
 * https://www.lintcode.com/problem/encode-and-decode-strings/description
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Please implement encode and decode
Example1

Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]
Explanation:
One possible encode method is: "lint:;code:;love:;you"
Example2

Input: ["we", "say", ":", "yes"]
Output: ["we", "say", ":", "yes"]
Explanation:
One possible encode method is: "we:;say:;:::;yes"
The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.

https://www.cnblogs.com/grandyang/p/5265628.html
*/

 import java.util.*;
import java.util.stream.Collectors;

 class EncodeDeCodeString{
    public static String encode(List<String> strs) {
        return strs.stream()
                   .map(s -> s.replace("/", "//").replace("*", "/*") + "*")
                   .collect(Collectors.joining()); 
    }
    
    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
    
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '/') {
                str.append(s.charAt(++i));
            } else if (s.charAt(i) == '*') { 
                res.add(str.toString()); 
                str.setLength(0); 
            } else {
                str.append(s.charAt(i));
            }
        }
    
        return res;
    }

    public static void main(String[] args) {
        System.out.println(EncodeDeCodeString.decode(EncodeDeCodeString.encode(Arrays.asList("hello", "world", "@#$%@ #$T#6"))));
    }
 }