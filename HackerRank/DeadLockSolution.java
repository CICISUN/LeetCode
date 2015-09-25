package HackerRank;


import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class DeadLockSolution {

	private static List<String> inputs = new ArrayList<String>();

	public DeadLockSolution(){
	}

	public static void main(String[] args) throws Exception {
		//		BufferedReader br = null;
				DeadLockSolution solution = new DeadLockSolution();
		//		try {
		//			InputStream inputStream = new FileInputStream("input.txt");
		//			Reader reader = new InputStreamReader(inputStream);
		//			br = new BufferedReader(reader);
		//			
		////			br = new BufferedReader(new InputStreamReader(System.in));
		//			
		//			String input = br.readLine();
		//			while(input != null){
		//				solution.inputs.add(input);
		//				input = br.readLine();
		//			}
		//			solution.process(solution.inputs);
		//			
		//		} finally {
		//			if (br != null)
		//				br.close();
		//		}
//		        try {
//		            Scanner in = new Scanner("input.txt");
//		            while (in.hasNextLine()) {
//		                String input = in.nextLine();
//		                inputs.add(input);
//		            }
//		            in.close();
//
//		        } catch (Exception ex) {
//		            ex.printStackTrace();
//		        }
		inputs.add("p1 l1,l5,l2,l3");
		inputs.add("p2 l2,l7,l1,l3");
		inputs.add("p3 l1,l4,l5,l6");
		inputs.add("p4 l1,l5,l4,l6");
		solution.process(inputs);
	}

	public void process(List<String> inputs) {
		LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();

		for (String string : inputs) {
			String[] arr = string.split(" ")[1].split(",");
			ArrayList<String> locks = new ArrayList<String>();
			locks.addAll(Arrays.asList(arr));
			map.put(string.split(" ")[0], locks);
		}

		LinkedHashSet<ArrayList<String>> ret = new LinkedHashSet<ArrayList<String>>();
		int entryIndex = 0;
		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			ArrayList<String> value = entry.getValue();
			for(int i=0; i<value.size();i++){
				int otherEntryIndex = 0;
				for(Entry<String, ArrayList<String>> otherEntry : map.entrySet()){
					if(otherEntryIndex>entryIndex && !entry.equals(otherEntry)){
						ArrayList<String> otherValue = otherEntry.getValue();
						if(otherValue.contains(value.get(i))){
							int FirstHitIndex = otherValue.indexOf(value.get(i));
							if(FirstHitIndex<otherValue.size()-1 && FirstHitIndex>=0){
								int l=i+1, r=FirstHitIndex-1;
								HashSet<String> set1 = new HashSet<String>();
								while(l<value.size() && r>=0){
									if(!set1.add(value.get(l))){
										ArrayList<String> conflicts = new ArrayList<String>();
										conflicts.add(entry.getKey());
										conflicts.add(otherEntry.getKey());
										ret.add(conflicts);
										break;
									}
									if(!set1.add(otherValue.get(FirstHitIndex))){
										ArrayList<String> conflicts = new ArrayList<String>();
										conflicts.add(entry.getKey());
										conflicts.add(otherEntry.getKey());
										ret.add(conflicts);
										break;
									}
									l++; r--;
								}
								while(l<value.size()){
									if(!set1.add(value.get(l))){
										ArrayList<String> conflicts = new ArrayList<String>();
										conflicts.add(entry.getKey());
										conflicts.add(otherEntry.getKey());
										ret.add(conflicts);
										break;
									}
									l++;
								}
								while(r>=0){
									if(!set1.add(otherValue.get(FirstHitIndex))){
										ArrayList<String> conflicts = new ArrayList<String>();
										conflicts.add(entry.getKey());
										conflicts.add(otherEntry.getKey());
										ret.add(conflicts);
										break;
									}
									r--;
								}
							}
						}
					}
					otherEntryIndex++;
				}
			}

			entryIndex++;
		}

		//System.out.println(ret);
		for (ArrayList<String> al : ret) {
			System.out.println(al.get(0)+","+al.get(1));
		}
	}

}
