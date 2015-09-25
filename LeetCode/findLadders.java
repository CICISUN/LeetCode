package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class findLadders {
	public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        HashMap<String, List<String>> neighbors = new HashMap<String, List<String>>();
        HashMap<String, Integer> ladder = new HashMap<String, Integer>();
        bfs(beginWord, endWord, wordList, neighbors, ladder);
        List<String> path=new ArrayList<String>();
        List<List<String>> res= new ArrayList<List<String>>();
        dfs(neighbors, ladder, path, res, endWord, beginWord);
        return res;
    }
    
    private static void dfs( HashMap<String, List<String>> neighbors, HashMap<String, Integer> ladder, List<String> path, List<List<String>> res, String end, String start){
        path.add(end);
        if(end.equals(start)){
            Collections.reverse(path);
            res.add(new ArrayList<String>(path));
            Collections.reverse(path);
            path.remove(path.size()-1);
            return;
        }
        List<String> parents = neighbors.get(end);
        for(String s : parents){
            if(ladder.containsKey(s) && ladder.get(s) == (ladder.get(end)-1)){
                dfs(neighbors, ladder, path, res, s, start);
            }            
        }
        path.remove(path.size()-1);
    }
    private static void bfs(String begin, String end, Set<String> wordlist, HashMap<String, List<String>> neighbors, HashMap<String, Integer> ladder){
        wordlist.add(begin); wordlist.add(end);
        LinkedList<String> q = new LinkedList<String>();
        q.offer(begin);
        ladder.put(begin, 0);
        for(String s : wordlist){//create adjacency list for each word
            neighbors.put(s, new ArrayList<String>());
        }
        while(!q.isEmpty()){
            String cur=q.poll();
            ArrayList<String> nextlayer = findnext(cur, wordlist);
            for(String next : nextlayer){
                neighbors.get(cur).add(next);//add to adjacency list
                if(!ladder.containsKey(next)){//update shortest path count 
                    ladder.put(next, ladder.get(cur) + 1);
                    q.offer(next);
                }
                
            }
        }
    }
    private static ArrayList<String> findnext(String cur, Set<String> wordlist){
        ArrayList<String> nextlayer = new ArrayList<String>();
        for(int i=0;i<cur.length();i++){
            for(char c='a'; c<='z'; c++){
                if(!(cur.charAt(i)==c)){
                    String next=cur.substring(0,i) + c + cur.substring(i+1);
                    if(wordlist.contains(next)) nextlayer.add(next);
                }
            }
        }
        return nextlayer;
    }

	public static List<List<String>> findLadders2(String start, String end, Set<String> dict) {
		// hash set for both ends
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();

		// initial words in both ends
		set1.add(start);
		set2.add(end);

		// we use a map to help construct the final result
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		// build the map
		helper(dict, set1, set2, map, false);
 
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> sol = new ArrayList<String>(Arrays.asList(start));

		// recursively build the final result
		generateList(start, end, map, sol, res);

		return res;
	}

	static boolean helper(Set<String> dict, Set<String> set1, Set<String> set2, HashMap<String, List<String>> map, boolean flip) {

		if (set1.isEmpty()) {
			return false;
		}

		if (set1.size() > set2.size()) {
			return helper(dict, set2, set1, map, !flip);
		}

		// remove words on current both ends from the dict
		dict.removeAll(set1);
		dict.removeAll(set2);

		// as we only need the shortest paths
		// we use a boolean value help early termination
		boolean done = false;

		// set for the next level
		Set<String> set = new HashSet<String>();

		// for each string in end 1
		for (String str : set1) {
			for (int i = 0; i < str.length(); i++) {
				// change one character for every position
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char[] chars = str.toCharArray();
					chars[i] = ch;
					String word = new String(chars);
					// make sure we construct the tree in the correct direction
					String key = flip ? word : str;
					String val = flip ? str : word;
					List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();
					if (set2.contains(word)) {
						done = true;
						list.add(val);
						map.put(key, list);
					} 
					if (!done && dict.contains(word)) {
						set.add(word);
						list.add(val);
						map.put(key, list);
					}
				}
			}
		}

		// early terminate if done is true
		return done || helper(dict, set2, set, map, !flip);
	}

	static void generateList(String start, String end, HashMap<String, List<String>> map, List<String> sol, List<List<String>> res) {
		System.out.println(start + ":" + end + ":" + sol + ":" + map.containsKey(start));
		if (start.equals(end)) {
			res.add(new ArrayList<String>(sol));
			return;
		}
		// need this check in case the diff between start and end happens to be one
		// e.g "a", "c", {"a", "b", "c"}
		if (!map.containsKey(start)) {
			return;
		}
		for (String word : map.get(start)) {
			sol.add(word);
			generateList(word, end, map, sol, res);
			sol.remove(sol.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> wordList = new HashSet<String>();
		//wordList.add("a");
		wordList.add("b");
		System.out.println(findLadders2("a", "c",wordList));

	}

}
