package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopMinNSortedList {

	//Google On Campus: Biggest M elements from N sorted lists.Follow-up: Biggest M elements from N reversely-sorted lists.
	//Time and space complexity nlog(m) - n+log(m)
	//http://articles.leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html

	public static List<Integer> selectMLargest(List<Queue<Integer>> input, int m) {
		List<Integer> result = new ArrayList<Integer>();
		Queue<Integer> minheap = new PriorityQueue<Integer>(m); 
		for (int i = 0; i < input.size(); i++) {
			while(!input.get(i).isEmpty()){
				if(minheap.isEmpty()){
					minheap.offer(input.get(i).poll().intValue()); 
					continue;
				}
				if(minheap.peek() > input.get(i).peek().intValue()){
					continue;
				}
				if(minheap.peek() < input.get(i).peek().intValue()){
					minheap.offer(input.get(i).poll().intValue()); 
				}
				if(minheap.size()>m){
					minheap.poll();
				}
			}
		} 

		while (!minheap.isEmpty()) result.add(minheap.poll());
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l1 = new LinkedList<Integer>(Arrays.asList(1, 2, 3));
		LinkedList<Integer> l2 = new LinkedList<Integer>(Arrays.asList(2, 4, 9));
		List<Queue<Integer>> l = new ArrayList<Queue<Integer>>();
		l.add(l1); l.add(l2);
		System.out.println(selectMLargest(l, 3));
	}

}
