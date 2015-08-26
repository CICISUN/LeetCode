package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {
//    private java.util.LinkedHashMap<Integer,Integer> self = new java.util.LinkedHashMap<Integer,Integer>();
//    private int capacity;
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//    public int get(int key) {
//        Integer val = self.get(key);
//        if(val==null) return -1;
//        self.remove(key);
//        self.put(key,val);
//        return val;
//    }
//    public void set(int key, int value) {
//        Integer val = self.get(key);
//        if(val==null && self.size() == capacity){
//            self.remove(self.keySet().iterator().next());
//        }
//        else if(val!=null) self.remove(key);
//        self.put(key,value);
//    }
    private HashMap<Integer,Integer> map;
    private ArrayList<Integer> list;
    private final int cap;
    public LRUCache(int cap){
    	map = new HashMap<Integer, Integer>();
    	list = new ArrayList<Integer>();
    	this.cap = cap;	
    }
    
    public int get(int key){
    	if(!map.containsKey(key)) return -1;
    	int var = map.get(key);
    	list.remove(list.indexOf(key));
    	list.add(key);
    	return var;
    }
    public void set(int key, int value){
    	int val = get(key);
    	map.put(key, value);
    	if(val == -1){
    		list.add(key);
    		if(map.size()> cap){
    			map.remove(list.get(0));
    			list.remove(0);
    		}
    	}
//    	int var = get(key);
//    	if(var == -1 && list.size() == cap){
//    		map.remove(list.get(0));
//    		list.remove(0);
//    	}
//    	else if (var!=-1){
//    		map.remove(key);
//    		list.remove(list.indexOf(key));
//    	}
//    	list.add(key);
//    	map.put(key,value);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache l = new LRUCache(1);
		l.set(1,2);
		l.get(2);
	}

}
