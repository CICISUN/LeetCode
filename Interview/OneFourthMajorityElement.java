package Interview;

import java.util.ArrayList;

public class OneFourthMajorityElement {
	//Google Phone
	//find all elements larger than 1/4 of total inan array
	public static ArrayList<Integer> OneFourthMajorityElement(int[] input){
		ArrayList<Integer> res= new ArrayList<Integer>();
		if(input==null||input.length==0) return res;
		int n=input.length; int start=0;
		while( start+n/4<n){
			int offset = start+n/4;
			if(input[offset]==input[start]) {
				res.add(input[start]);
//				while(offset<n && input[offset]==input[offset+1]){
//					offset++;
//				}
//				start=offset;
				start = binarysearch(0,offset, input);
			}
			else{
				while(offset>0 && input[offset]==input[offset-1]){
					offset--;
				}
				start=offset;
			}
		}
		return res;
	}
//
	public int binarysearch(int x, int y, int[] input){
		int m;
		int n=input[y];
		while(true){
			m=(x+y)/2;
			if(input[m]==n){
				y=
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1,2,2,2,2,3,5};
		System.out.println(OneFourthMajorityElement(a));
	}

}
