import java.util.*;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

 Notice
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example
Example 1:

Input: n = 5 edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
Output: true.
Example 2:

Input: n = 5 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
Output: false.
 */
class GraphValidTree{


    // BFS
    public static boolean validTreeBFS(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> aj = new HashMap<>();
        for(int[] edge: edges){
            HashSet<Integer> a = aj.getOrDefault(edge[0], new HashSet<>());
            HashSet<Integer> b = aj.getOrDefault(edge[1], new HashSet<>());
            a.add(edge[1]);
            b.add(edge[0]);
            aj.put(edge[0], a);
            aj.put(edge[1], b);
        }
        LinkedList<Integer> q = new LinkedList<>();
        HashSet<Integer> result = new HashSet<>();
        q.offer(0);
        result.add(0);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int child: aj.get(cur)){
                //cycle
                if(result.contains(child)) return false;
                q.offer(child);
                aj.get(child).remove(cur);
                result.add(child);
            }
        }
        //jungle
        return result.size() == n;
    }

    // DFS
    public static boolean validTreeDFS(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> aj = new HashMap<>();
        for(int[] edge: edges){
            HashSet<Integer> a = aj.getOrDefault(edge[0], new HashSet<>());
            HashSet<Integer> b = aj.getOrDefault(edge[1], new HashSet<>());
            a.add(edge[1]);
            b.add(edge[0]);
            aj.put(edge[0], a);
            aj.put(edge[1], b);
        }
        boolean[] visited = new boolean[n];
        // cycle 
        if(!dfs(aj, visited, 0, -1)) return false;
        // jungle
        for(boolean v: visited){
            if(!v) return false;
        }
        return true;
    }

    private static boolean dfs(HashMap<Integer, HashSet<Integer>> aj, boolean[] visited, int cur, int pre){
        if(visited[cur]) return false;
        visited[cur] = true;
        for(int child: aj.get(cur)){
            if(child == pre) continue;
            if(!dfs(aj, visited, child, cur)) return false;
        }
        return true;
    }

    // Union Find
    public static boolean validTreeUF(int n, int[][] edges) {
        int[] roots = new int[n];
        Arrays.fill(roots, -1);
        for(int[] edge: edges){
            int group_a = find(roots, edge[0]);
            int group_b = find(roots, edge[1]);
            //cycle
            if(group_a == group_b) return false;
            roots[group_a] = group_b;
        }
        //jungle
        return edges.length == n-1;
    }
    
    private static int find(int[] roots, int i){
        while(roots[i] != -1) {
            i=roots[i];
        }
        return i;
    }


    public static void main(String[] args) {
        int[][] edges_cycle = {
            {0,1},
            {0,2},
            {0,3},
            {1,4},
            {2,3}
        };
        int[][] edges_jungle = {
            {0,1},
            {0,2},
            {0,3},
        };

        int[][] edges_tree = {
            {0,1},
            {0,2},
            {0,3},
            {1,4},
        };
        for(int[][] edges: Arrays.asList(edges_cycle, edges_jungle, edges_tree)){
            System.out.println("bfs: " + GraphValidTree.validTreeBFS(5, edges));
            System.out.println("dfs: " + GraphValidTree.validTreeDFS(5, edges));
            System.out.println("uf: " + GraphValidTree.validTreeUF(5, edges));

        }
    }

}