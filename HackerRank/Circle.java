package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Circle {

	static int[] Circles(int distance, int[] radius, int[] cost) {

		TreeMap<Integer, int[]> map=new TreeMap<Integer, int[]>(Collections.reverseOrder());
		int n=radius.length;
		for(int i=0;i<n;i++) if(radius[i]>distance) radius[i]=distance;
		for(int i=0;i<n;i++){
			int r=radius[i];
			if(!map.containsKey(r)||map.get(r)[1]>cost[i]){
				map.put(r, new int[]{i+1, cost[i]});
			}
		}

		int mincost=Integer.MAX_VALUE, mingear=0;
		for(Map.Entry<Integer, int[]> entry : map.entrySet()){
			if(entry.getValue()[1]<mincost){
				mincost=entry.getValue()[1];
				mingear=entry.getValue()[0];
			}
			else if(entry.getValue()[1]>=mincost){
				entry.setValue(new int[]{mingear, mincost});
			}
		}

		int[] res=new int[n];
		for(int i=0;i<n;i++){
			Map.Entry<Integer, int[]> entry=map.floorEntry(distance-radius[i]);
			if(entry!=null&&entry.getKey()>=distance-radius[i]){
				res[i]=entry.getValue()[0];
			}
			else res[i]=0;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] r={1, 3, 6, 2, 5, 2, 5};
		int[] c={5, 6, 8, 3, 4, 3, 7};
		int[] res=Circles(8, r, c);
		for(int i : res){
			System.out.print(i+" ");
		}
	}

	//	 public static void main(String[] args) throws IOException{
	//	        Scanner in = new Scanner(System.in);
	//	        final String fileName = System.getenv("OUTPUT_PATH");
	//	        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
	//	        int res;
	//	        int _n;
	//	        _n = Integer.parseInt(in.nextLine());
	//	        
	//	        
	//	        int _pairs_size = 0;
	//	        _pairs_size = Integer.parseInt(in.nextLine());
	//	        String[] _pairs = new String[_pairs_size];
	//	        String _pairs_item;
	//	        for(int _pairs_i = 0; _pairs_i < _pairs_size; _pairs_i++) {
	//	            try {
	//	                _pairs_item = in.nextLine();
	//	            } catch (Exception e) {
	//	                _pairs_item = null;
	//	            }
	//	            _pairs[_pairs_i] = _pairs_item;
	//	        }
	//	        
	//	        res = MinimalCost(_n, _pairs);
	//	        bw.write(String.valueOf(res));
	//	        bw.newLine();
	//	        
	//	        bw.close();
	//	    }

}
