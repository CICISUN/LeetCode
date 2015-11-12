package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class WeddingPlanner {
	/*
	 * Complete the function below.
	 */

	static float Interpolate(int n, int[] amount, String[] ucost) {
		int history_length = amount.length;
		//case3: n<amount || n>amount
		if(n>amount[history_length-1]){
			int[] amounts = new int[2]; float[] prices = new float[2]; int count=0;
			for(int i=history_length-1; i>=0; i--){
				if(count>1) break;
				if(Float.valueOf(ucost[i]) > 0){//case4: illegal input in cost
					amounts[count] = amount[i];
					prices[count] = Float.valueOf(ucost[i]);
					count++;
				}
			}
			if(amounts[1] > 0){
				reverse(amounts, prices);
			}
			return calc(n, amounts, prices);
		}
		if(n<amount[0]){
			int[] amounts = new int[2]; float[] prices = new float[2]; int count=0;
			for(int i=0; i<amount.length; i++){
				if(count>1) break;
				if(Float.valueOf(ucost[i]) > 0){//case4: illegal input in cost
					amounts[count] = amount[i];
					prices[count] = Float.valueOf(ucost[i]);
					count++;
				}
			}
			return calc(n, amounts, prices);
		}
		int l=0; int r=amount.length-1;
		while(l<=r){
			int mid = (l+r)/2;
			if(Float.valueOf(ucost[mid])!=0){
				if(amount[mid]==n) return Float.valueOf(ucost[mid]);//case1: n==amount[i]
			}
			if(amount[mid]>n){
				r=mid-1;
			}
			else l=mid+1;
		}
		//case2: amount[i]<n<amount[j]
		int[] amounts = new int[2]; float[] prices = new float[2]; int count=0;
		while(l>=0 && Float.valueOf(ucost[l]) <= 0){
			l--;
		}
		if(l>=0) {
			amounts[count]=amount[l];
			prices[count]=Float.valueOf(ucost[l]);
			count++;
		}
		while(r<amount.length && Float.valueOf(ucost[r]) <= 0){
			r++;
		}
		if(l<amount.length) {
			amounts[count]=amount[r];
			prices[count]=Float.valueOf(ucost[r]);
			count++;
		}	
		return calc(n, amounts, prices);
	}

	public static float calc(int n, int[] amounts, float[] prices){
		if(amounts[1] == 0) return prices[0];
		float val = (prices[1] - prices[0]) / (amounts[1] - amounts[0] ) * (n-amounts[1]) + prices[1];
		return Float.parseFloat(String.format("%.2f", val));
	}

	public static void reverse(int[] amounts, float[] prices){
		int tmpa=amounts[0];
		amounts[0]=amounts[1];
		amounts[1]=tmpa;
		float tmpb=prices[0];
		prices[0]=prices[1];
		prices[1]=tmpb;
	}

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		//		final String fileName = System.getenv("/");
		//		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		float res;
		int _n;
		_n = Integer.parseInt(in.nextLine());


		int _amount_size = Integer.parseInt(in.nextLine());
		int[] _amount = new int[_amount_size];
		int _amount_item;
		for(int _amount_i = 0; _amount_i < _amount_size; _amount_i++) {
			_amount_item = Integer.parseInt(in.nextLine());
			_amount[_amount_i] = _amount_item;
		}


		int _ucost_size = Integer.parseInt(in.nextLine());
		String[] _ucost = new String[_ucost_size];
		String _ucost_item;
		for(int _ucost_i = 0; _ucost_i < _ucost_size; _ucost_i++) {
			try {
				_ucost_item = in.nextLine();
			} catch (Exception e) {
				_ucost_item = null;
			}
			_ucost[_ucost_i] = _ucost_item;
		}

		res = Interpolate(_n, _amount, _ucost);
		System.out.println(res);
		//		bw.write(String.valueOf(res));
		//		bw.newLine();
		//
		//		bw.close();
	}    
	//	public static void main(String[] args) {
	//		WeddingPlanner wp = new WeddingPlanner();
	////		int[] amount={10,25,50,100,500};
	//		int[] amount={10,25,50,100,500};
	////		String[] ucost={"27.32", "23.13", "21.25", "18.00", "15.50"};
	////		String[] ucost={"2.46", "2.58", "2", "2.25", "3"};
	//		String[] ucost={"0", "0", "0", "0", "54.25"};
	//		System.out.println(wp.Interpolate(2, amount, ucost));
	//
	//	}

}
