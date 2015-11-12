package Interview;
//IBM Watson OA
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Family {

	int n;
	List<List<String>> relationships;

	public String parse(String s){
		String[] input = s.split(",");
		n=Integer.valueOf(input[input.length-1]);
		relationships = new ArrayList<List<String>>();
		for(int i=0;i<input.length-1;i++){
			List<String> line = new ArrayList<String>();
			String[] linename=input[i].split("->");
			line.add(linename[0]);
			line.add(linename[1]);
			relationships.add(line);
		}
		buildtree();
		String root = findroot();
		return findlayer(root);
	} 

	Map<String, ArrayList<String>> aj = new HashMap<String, ArrayList<String>>();

	public void buildtree(){
		for(List<String> pair: relationships){
			if(aj.containsKey(pair.get(0))){
				ArrayList<String> tmp =aj.get(pair.get(0));
				tmp.add(pair.get(1));
				aj.put(pair.get(0), tmp);
			}
			else{
				ArrayList<String> tmp = new ArrayList<String>();
				tmp.add(pair.get(1));
				aj.put(pair.get(0), tmp);
			}
		}
	}

	public String findroot(){
		HashSet<String> hs = new HashSet<String>();
		for (ArrayList<String> value : aj.values()) {
			for(String child:value){
				hs.add(child);
			}
		}
		for (String key : aj.keySet()) {
			if(hs.add(key)){
				return key;
			}
		}
		return "";
	}

	public String findlayer(String root){
		int i=0;
		if(n==1) return root;
		Queue<String> curlevel = new ArrayDeque<String>();
		Queue<String> nextlevel = new ArrayDeque<String>();
		curlevel.offer(root);
		while(!curlevel.isEmpty()){
			String cur = curlevel.poll();
			ArrayList<String> nextlayer = aj.get(cur);
			for(int d=0; d<nextlayer.size(); d++){
				nextlevel.offer(nextlayer.get(d));
			}
			if(curlevel.isEmpty()){
				i++;
				if(i==n-1){
					return output(nextlevel);
				}
				else{
					curlevel=nextlevel;	
					nextlevel=new ArrayDeque<String>();
				}
			}
		}
		return "";
	}
	
	public String output(Queue<String> q){
		ArrayList list = new ArrayList(q);
		Collections.sort(list);
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<list.size();i++) {
		    sb.append(list.get(i)).append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		Family f = new Family();
		while ((s = in.readLine()) != null) {
			System.out.println(f.parse(s));
		}
	}
}
