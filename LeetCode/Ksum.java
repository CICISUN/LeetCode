package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ksum {

	//O(N^(K-1))
	public static ArrayList<ArrayList<Integer>> ksum(int[] arr, int target, int k, int start){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(k==2){
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			int i=start, j=arr.length;
			while(i<j){
				if(i>start && arr[i]==arr[i-1]){
					i++;
					continue;
				}
				else if(arr[i]+arr[j]==target){
					tmp.add(arr[i]);
					tmp.add(arr[j]);
					res.add(tmp);
					i++; j--;
				}
				else if((arr[i]+arr[j]) > target){
					j--;
				}
				else{
					i++;
				}
			}
			return res;
		}
		for(int i=start; i<arr.length; i++){
			if(i>start && arr[i] == arr[i-1]) continue;
			ArrayList<ArrayList<Integer>> pre = ksum(arr, target-arr[i], k-1, i+1);
			for(int tup=0; tup<pre.size(); tup++){
				ArrayList<Integer> cur = pre.get(tup);
				cur.add(arr[i]);
				res.add(cur);
			}
		}
		return res;
	}

	//O(N^K)
	private Set<Integer> visited = new HashSet<Integer>();
	private List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> kSum(int[] nums, int target, int k) {
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		helper(nums, target, k, new ArrayList<Integer>(), 0);
		return res;
	}

	public void helper(int[] nums, int target, int k,  List<Integer> list, int index) {
		if (list.size() == k) {
			if (target == 0) {
				res.add(new ArrayList<Integer>(list));
			}
			return;
		}

		for (int i = index; i < nums.length; i++) {
			if (i > 0 && !visited.contains(i - 1) && nums[i - 1] == nums[i])
				continue;
			list.add(nums[i]);
			visited.add(i);
			helper(nums, target - nums[i], k, list, i+1);
			list.remove(list.size() - 1);
			visited.remove(i);
		}
	}

	public static void main(String[] args) {
		Ksum k = new Ksum();
		int[] A={ 1, 1, 2, 3, 4, 5, 6};
		System.out.println(ksum(A, 15, 5, 0));
		System.out.println(k.kSum(A, 15, 5));
	}

}
