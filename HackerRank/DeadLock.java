package HackerRank;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class DeadLock {
    
   public static LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
   public static ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
   public static HashSet<String> done = new HashSet<String>();
	    //reads the input into a map
	    public static void parse(){
	        try{
	            Scanner s = new Scanner(System.in);
	            while(s.hasNextLine()){
	                String input = s.nextLine().trim();
	                String key = input.split(" ")[0];
	                String[] value = input.split(" ")[1].split(",");
	                ArrayList<String> tmp = new ArrayList<String>();
	                for(String lock : value){
	                    tmp.add(lock);
	                }
	                map.put(key, tmp);
	            }
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	    
	    //finds deadlocks
	    //finds deadlocks
	    public static void find(){
	        //iterate first process
	        for(Entry<String, ArrayList<String>> fprocess : map.entrySet()){
                done.add(fprocess.getKey());
	            ArrayList<String> firstvalue = fprocess.getValue();
	            //iterate second process
	            for(Entry<String, ArrayList<String>> sprocess : map.entrySet()){
	                if(done.contains(sprocess.getKey())) continue;
	                ArrayList<String> secondvalue = sprocess.getValue();
	                for(int i=0; i<firstvalue.size(); i++){
	                    if(!secondvalue.contains(firstvalue.get(i))) continue;
	                    //only if current lock is found in second, check the rest
	                    int foundindex=secondvalue.indexOf(firstvalue.get(i));
	                    //if found index is legal
	                    if(foundindex>0 && foundindex<secondvalue.size()){
//	                        if(secondvalue.get(foundindex-1).equals(firstvalue.get(i+1))){
//	                            addtoresult(fprocess.getKey(), sprocess.getKey()); 
//	                            break;
//	                        }
	                    	boolean flag=false;
	                        int l=i+1, r=foundindex-1; 
	                        HashSet<String> set = new HashSet<String>();
	                        while(l<firstvalue.size() && r>=0){
	                        	if((!set.add(firstvalue.get(l))) || (!set.add(secondvalue.get(r)))){
	                        		addtoresult(fprocess.getKey(), sprocess.getKey()); 
	                        		flag=true;
	                        		break;
	                        	}
	                        	l++;r--;
	                        }
							while(!flag && l<firstvalue.size()){
								if(!set.add(firstvalue.get(l))){
									addtoresult(fprocess.getKey(), sprocess.getKey());
									break;
								}
								l++;
							}
							while(!flag && r>=0){
								if(!set.add(secondvalue.get(r))){
									addtoresult(fprocess.getKey(), sprocess.getKey());
									break;
								}
								r--;
							}
	                    }
	                }
	            }
	        }
	    }
	    
	    
	    public static void addtoresult(String a, String b){
	        ArrayList<String> tmp = new ArrayList<String>();
            tmp.add(a); tmp.add(b);
	        result.add(tmp);
	    }
	    
        public static void sort(){
            Collections.sort(result, new Comparator<ArrayList<String>>(){    
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                if(o1.get(0).compareTo(o2.get(0)) == 0) return o1.get(1).compareTo(o2.get(1));
                return o1.get(0).compareTo(o2.get(0));
            }               
            });
        }
	    public static void printresult(){
	        for(ArrayList<String> pair : result){
	            System.out.println(pair.get(0) + "," + pair.get(1));
	        }
	    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        parse();
        find();
        sort();
        printresult();
    }
}