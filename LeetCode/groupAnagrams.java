package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class groupAnagrams {
	

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> dict = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedString = String.valueOf(chars);
            if (dict.containsKey(sortedString)) {
                dict.get(sortedString).add(s);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                dict.put(sortedString, list);
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for (List<String> list : dict.values()) {
            if (list.size() >= 1)
            	Collections.sort(list);
                res.add(list);
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] A={""};
		System.out.println(groupAnagrams(A));
	}

}
