/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
import java.util.*;

class canFinish {
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> aj = new HashMap<>();
        int[] visited = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            List<Integer> l = aj.getOrDefault(prerequisites[i][0], new ArrayList<>());
            l.add(prerequisites[i][1]);
            aj.put(prerequisites[i][0], l);
        }
        for(int i=0; i<numCourses; i++){
             if(!dfs(aj, visited, i)){
                 return false;
             }
        }
        return true;
    }
    
    private boolean dfs(HashMap<Integer, List<Integer>> aj, int[]visited, int i){
        if(visited[i]==1) return false;
        if(visited[i]==2) return true;
        visited[i]=1;
        if(aj.containsKey(i)){
            for(int pre: aj.get(i)){
                if(!dfs(aj, visited, pre)) return false;
            }   
        }
        visited[i]=2;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        int count=0;
        for(int[] edge: prerequisites){
            indegree[edge[1]]++;
        }
        LinkedList<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            count++;
            for(int[] edge: prerequisites){
                if(edge[0]==cur) {
                    indegree[edge[1]]--;
                    if(indegree[edge[1]]==0) q.offer(edge[1]);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        canFinish s = new canFinish();
        // int[][] input = {{2,0},{1,0},{3,1},{3,2},{1,3}};
        int[][] input = {{1,0}};

        System.out.println(s.canFinish(2, input));
    }
}
// @lc code=end

