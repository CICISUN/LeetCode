package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class merge {

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		//sort according to start using inline comparator
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval a, Interval b) {
				return a.start-b.start;
			}
		});
		//compare and add to result
		ArrayList<Interval> res=new ArrayList<Interval>();

		for(int i=0;i<intervals.size();i++){
			Interval cur=intervals.get(i);
			//imagine cur to eat all overlapped intervals
			while(i<intervals.size()-1 && cur.end>=intervals.get(i+1).start){
				cur.end=Math.max(cur.end, intervals.get(i+1).end);
				i++;
			}
			res.add(cur);
		}
		return res;
	}

	public List<Interval> merge2(ArrayList<Interval> intervals) {
		//sort according to start using inline comparator
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval a, Interval b) {
				return a.start-b.start;
			}
		});
		//compare end and add to result
		List<Interval> res=new LinkedList<Interval>();

		for(int i=0;i<intervals.size();i++){
			Interval cur=intervals.get(i);
			//imagine cur to eat all overlapped intervals
			while(i<intervals.size()-1 && cur.end>=intervals.get(i+1).start){
				cur.end=Math.max(cur.end, intervals.get(i+1).end);
				i++;
			}
			res.add(cur);

		}
		return res;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
