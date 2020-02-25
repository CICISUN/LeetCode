/**
 * https://www.lintcode.com/problem/alien-dictionary/description
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. 
 * Derive the order of letters in this language.
Example 1:
Given the following words in dictionary,
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".
 https://zhuhan0.blogspot.com/2017/06/leetcode-269-alien-dictionary.html
https://github.com/awangdev/LintCode/blob/master/Java/Alien%20Dictionary.java
 */
import java.util.*;

class AlienDictionary {
    // BFS Topo sort
    public static String alienOrderBFS(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>(); // option to use int[26]
        build(graph, inDegree, words);
        return topoSort(graph, inDegree);
    }

    private static String topoSort(Map<Character, List<Character>> graph, Map<Character, Integer> inDegree){
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) { // Build queue with item of inDegree==0: means no edge points towards it.
            if (inDegree.get(c) == 0) queue.offer(c);
        }

        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char edgeNode : graph.get(c)) { // reduce edge degrees count since node:graph.get(c) has been processed
                inDegree.put(edgeNode, inDegree.get(edgeNode) - 1);
                if (inDegree.get(edgeNode) == 0) queue.offer(edgeNode);
            }
        }
        if (sb.length() != graph.size()) return "";
        return sb.toString();
    }

    private static void build(Map<Character, List<Character>> graph, Map<Character, Integer> inDegree, String[] words){
        for(String word: words){
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }
        // if c1 != c2, build graph and inDegree map and break: later index does not have any more relationship.
        for (int i = 0; i < words.length - 1; i++) {
            int index = 0;
            while (index < words[i].length() && index < words[i + 1].length()) {
                char c1 = words[i].charAt(index);
                char c2 = words[i + 1].charAt(index);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                    break;
                }
                index++;
            }
        }
    }

    // DFS Topo sort
    static Map<Character, List<Character>> graph = new HashMap<>();
    static Map<Character, Integer> visited = new HashMap<>();
    static StringBuffer sb = new StringBuffer();
    public static String alienOrderDFS(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        // Build graph, and visited map.
        buildGraph(words);
        // Topological sort with dfs
        for (char c : graph.keySet()) {
            if (!dfs(c)) {
                return "";
            }
        }
        return sb.toString();
    }

    private static boolean dfs(Character c) {
        if (visited.get(c) == 1) return true;
        if (visited.get(c) == -1) return false; //cycle
            
        visited.put(c, -1); //visiting
        for (char edgeNode : graph.get(c)) {
            if (!dfs(edgeNode)) {
                return false;
            }
        }
        visited.put(c, 1); //visited
        sb.insert(0, c); // leaf element, add to buffer
        return true;
    }

    private static void buildGraph (String[] words) {
        // Create nodes
        for (String word: words) {
            for (char c : word.toCharArray()) {
                if (!graph.containsKey(c)) {
                    graph.put(c, new ArrayList<>());
                    visited.put(c, 0);
                }
            }
        }
        // Build edges
        for (int i = 0; i < words.length - 1; i++) {
            int index = 0;
            while (index < words[i].length() && index < words[i + 1].length()) {
                char c1 = words[i].charAt(index);
                char c2 = words[i + 1].charAt(index);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    break;
                }
                index++;
            }
        }
    }

    

    public static void main(String[] args) {
        String[] words_cycle = {"ac", "c", "a",};
        String[] words = {  "wrt",
        "wrf",
        "er",
        "ett",
        "rftt"};
        for(String[] str: Arrays.asList(words, words_cycle)){
            System.out.println("bfs: "+AlienDictionary.alienOrderBFS(str));
            System.out.println("dfs: "+AlienDictionary.alienOrderDFS(str));

        }
    }
}