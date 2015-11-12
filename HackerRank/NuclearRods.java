package HackerRank;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class NuclearRods {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		//	        final String fileName = System.getenv("OUTPUT_PATH");
		//	        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		int res;
		int _n;
		_n = Integer.parseInt(in.nextLine());


		int _pairs_size = 0;
		_pairs_size = Integer.parseInt(in.nextLine());
		String[] _pairs = new String[_pairs_size];
		String _pairs_item;
		for(int _pairs_i = 0; _pairs_i < _pairs_size; _pairs_i++) {
			try {
				_pairs_item = in.nextLine();
			} catch (Exception e) {
				_pairs_item = null;
			}
			_pairs[_pairs_i] = _pairs_item;
		}

		res = MinimalCost(_n, _pairs);
		//	        bw.write(String.valueOf(res));
		//	        bw.newLine();
		System.out.println(res); 
		//	        bw.close();
	}

	public static int MinimalCost(int n, String[] pairs) {
		HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
		HashSet<String> lonely = new HashSet<String>();
		for (int i=0; i<pairs.length; i++) {
			String current = pairs[i];
			String[] tmp = current.split(" ");
			String p = Integer.parseInt(tmp[0]) <= Integer.parseInt(tmp[1]) ? tmp[0] : tmp[1];
			String q = Integer.parseInt(tmp[0]) <= Integer.parseInt(tmp[1]) ? tmp[1] : tmp[0];
			lonely.add(p); lonely.add(q);
			HashSet<String> hs_p = new HashSet<String>();
			int p_i=-1; int q_i=-1;
			HashSet<String> hs_q = new HashSet<String>();
			for(int t=n; t>=1; t--){
				if(map.containsKey(String.valueOf(t))){
					if(map.get(String.valueOf(t)).contains(q)){
						hs_q=map.get(String.valueOf(t));
						q_i=t;
					}
					if(map.get(String.valueOf(t)).contains(p)){
						hs_p=map.get(String.valueOf(t));
						p_i=t;
					}
				}
			}
			if(q_i==-1 && p_i==-1){
				HashSet<String> hs = new HashSet<String>();
				hs.add(p); hs.add(q);
				map.put(p, hs);
				continue;
			}
			if(q_i==-1 && p_i != -1){
				hs_p.add(q);
				if(Integer.valueOf(p)<p_i){
					map.put(p, hs_p);
					map.remove(String.valueOf(p_i));
				}
				else{
					map.put(String.valueOf(p_i), hs_p);
				}
				continue;
			}
			if(q_i != -1 && p_i == -1){
				hs_q.add(p);
				if(Integer.valueOf(p)<q_i){
					map.put(p, hs_q);
					map.remove(String.valueOf(q_i));
				}
				else{
					map.put(String.valueOf(q_i), hs_q);
				}
				continue;
			}
			if(q_i !=-1 && p_i !=-1){
				if(q_i < p_i){
					HashSet<String> hs = map.get(String.valueOf(q_i));
					hs.addAll(map.get(String.valueOf(p_i)));
					map.put(String.valueOf(q_i),hs);
					map.remove(String.valueOf(p_i));
				}
				else{
					HashSet<String> hs = map.get(String.valueOf(p_i));
					hs.addAll(map.get(String.valueOf(q_i)));
					map.remove(String.valueOf(q_i));
					map.put(String.valueOf(p_i),hs);
				}
				continue;
			}
		}		
		int sum=0; 
		for(java.util.Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			HashSet<String> value = entry.getValue();
			sum+= (int) Math.ceil(Math.sqrt(value.size()));
		}
		sum = sum + n - lonely.size();
		return sum;
	}

}
