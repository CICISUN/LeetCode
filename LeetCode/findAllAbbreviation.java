package LeetCode;

import java.util.*;
/*
 * This solution deals with two cases on an subproblem
 * If we keep the next character unchanged, append it and recurse substring
 * If we change the next character to number, check if previous ('current') ends with a number, if not then add the number(from 1 to left.length) and recurse substring.
 * also check if previous current is empty, if yes add the number as well
 * If previous ends with not a number, then ignore. Cuz we will/have dealt with those cases by adding all possible numbers
 */

public class findAllAbbreviation {
	private static void dfs(String left, List<String> result, String current) {
		if (left.equals("")) {
			result.add(current);
			return;
		}
		String currentCopy = current;
		int length = left.length();
		current += left.charAt(0);
		dfs(left.substring(1), result, current);
		current = currentCopy;
		if (!(current.length()>0 && current.charAt(current.length()-1)>='0' && current.charAt(current.length()-1)<='9')) {//if previous is not number, or previous is empty
			for (int i=1;i<=length;i++) {
				current += Integer.toString(i);
				dfs(left.substring(i), result, current);
				current = currentCopy;
			}
		}
	}

	private static List<String> findAll(String target) {
		List<String> result = new ArrayList<String>();
		if (target==null || target.length()==0) return result;
		dfs(target, result, "");
		return result;
	}

	public static void main(String[] args) {
		String target = "abc";
		List<String> result = findAll(target);
		for (String tmp : result) {
			System.out.println(tmp);
		}
	}
}