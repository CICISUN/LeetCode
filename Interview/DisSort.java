package Interview;

import java.util.ArrayList;
import java.util.Arrays;

public class DisSort {

	//Google Phone 

	//	173946 5,3,4,...
	//	abs(i-j)
	//
	//	HashMap<dist, List<Integer> nums[i]>
	//	(4,[1,9])
	//	(2,[7,3])
	//	(1,[4,6])
	//
	//	O(nlogn)
	public ArrayList<Integer> sortbydis(ArrayList<Integer> nums, int target){
		//Arrays.sort(nums);
		ArrayList<Integer> res = new ArrayList<Integer>();
		int l=0, r=nums.size()-1, mid=0;
		while(l<=r){
			mid=(l+r)/2;
			if(target>nums.get(mid)){
				l=mid;
			}
			else if(target<nums.get(mid)){
				r=mid;
			}
			else break; //5 is found
		}
		//now l closest to target
		if(nums.get(mid)==target){
			res.add(nums.get(mid));
			l=mid-1;
			r=mid+1;
		}
		else if(l==r){
			if(Math.abs(nums.get(l)-target) < Math.abs(nums.get(l+1)-target)){
				res.add(nums.get(l));
				l--;
				r=l+1;
			}
			else{
				res.add(nums.get(l+1));
				r=l+1;
			}
		}
		//move two pointers
		while(l>=0 && r<nums.size()){
			if(Math.abs(nums.get(l)-target) < Math.abs(nums.get(r)-target)){
				res.add(nums.get(l));
				l--;
			}
			else{
				res.add(nums.get(r));
				r++;
			}
		}
		//l || r 
		while(l>=0){
			res.add(nums.get(l));
			l--;
		}
		while(r<nums.size()){
			res.add(nums.get(r));
			r++;
		}

		return res;
	}

	//O(knlogn)
	public ArrayList<ArrayList<Integer>> sortbydis(ArrayList<Integer> nums, ArrayList<Integer> target){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		//Arrays.sort(nums);
		for(Integer t : target){
			//ArrayList<Integer> res = new ArrayList<Integer>();
			result.add(sortbydis(nums, t));
		}

		return result;

	}
	//
	//	134679 [5,3,4]
	//
	//
	//	[3,5,7,8,11] 5 -> [5,7,3,8,11]
	//
	//
	//
	//	173946 5
	//
	//	max-9 -> maxdis 4
	//	bs-7 -> mindis 2
	//
	//	[[4,6],0 ,[7,3],0 ,[1,9],0]







	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
