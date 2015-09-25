package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class cloneGraph {
	
	 class UndirectedGraphNode {
		      int label;
		      List<UndirectedGraphNode> neighbors;
		      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
		  };

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // use a map to save cloned nodes
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.offer(node);
        while(!q.isEmpty()){
            int curlv_cnt=q.size();
            for(int i=0; i<curlv_cnt; i++){
                UndirectedGraphNode cur = q.poll();
                UndirectedGraphNode cur_copy = new UndirectedGraphNode(cur.label);
                cur_copy.neighbors = new ArrayList<UndirectedGraphNode>();
                map.put(cur, cur_copy);
                if(cur.neighbors!=null && cur.neighbors.size() !=0){
                    for(int j=0; j<cur.neighbors.size();j++){
                        q.offer(cur.neighbors.get(j));
                    }
                }
            }
        }
        //copy neighbors
        q.offer(node);
        while(!q.isEmpty()){
            int curlv_cnt=q.size();
            for(int i=0;i<curlv_cnt;i++){
            	UndirectedGraphNode cur = q.poll();
                if(cur.neighbors!=null && cur.neighbors.size() !=0){
                    for(int j=0; j<cur.neighbors.size();j++){
                        q.offer(cur.neighbors.get(j));
                        if(!map.containsKey(cur.neighbors.get(j))){
                            map.get(cur).neighbors.add(map.get(cur.neighbors.get(j)));
                        }
                    }
                }
            }
        }
        return map.get(node);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
