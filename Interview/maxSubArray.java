package Interview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class maxSubArray {

	public static int[][] parse(String path) throws FileNotFoundException{
		File file = new File(path);
		Scanner s = new Scanner(file);
		String firstline = s.nextLine();
		int rows = Integer.parseInt(firstline.split(" ")[0]);
		int cols = Integer.parseInt(firstline.split(" ")[1]);
		int[][] matrix = new int[rows][cols];
		int linenum = 0;
		while(s.hasNextLine()){
			String line = s.nextLine();
			int[] arr = new int[cols];
			String[] tmp = line.split(" ");
			for(int i=0; i<cols; i++){
				arr[i] = Integer.valueOf(tmp[i]);
			}
			matrix[linenum] = arr;
			linenum++;
		}       
		return matrix;
	}

	public void findMaxSum(int[][] matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		int start=0, end=0; 
		int topleft_row=0, topleft_col=0, bottomright_row=0, bottomright_col=0, maxarea=0;
		for(start=0; start<cols; start++){
			for(end=start; end<cols; end++){
				//sum to 1d array
				int tmp[] = new int[rows];
				for(int i=0; i<rows; i++){
					for(int j=start;j<=end;j++){
						tmp[i]+=matrix[i][j];
					}
				}
				//kadane update
				
				ArrayList<Integer> wholepiece = maxSubArrayCir(tmp);
//				ArrayList<Integer> wholepiece = findMax1dSum(tmp);
				if(wholepiece.get(0) > maxarea){
					maxarea = wholepiece.get(0);
					topleft_col = start;
					bottomright_col = end;
					topleft_row = wholepiece.get(1);
					bottomright_row = wholepiece.get(2);
				}
			}	

			//circular	
			if((start-2)>=0){
				for(end=0; end<=(start-2); end++){
					//sum to 1d array
					int twopiece[] = new int[rows];
					for(int i=0;i<rows;i++){
						for(int j=start; j<cols; j++){
							twopiece[i]+=matrix[i][j];
						}
					}
					for(int i=0; i<rows; i++){
						for(int j=0;j<=end;j++){
							twopiece[i]+=matrix[i][j];
						}
					}
					//kadane update
					ArrayList<Integer> twopieceres = maxSubArrayCir(twopiece);
//					ArrayList<Integer> twopieceres = findMax1dSum(twopiece);
					if(twopieceres.get(0) > maxarea){
						maxarea = twopieceres.get(0);
						topleft_col = start;
						bottomright_col = end;
						topleft_row = twopieceres.get(1);
						bottomright_row = twopieceres.get(2);
					}
				}
			}
		}
		System.out.println("Maxarea:" + maxarea);
		System.out.println("Top:" + topleft_row + "," + topleft_col);
		System.out.println("Bottom:" + bottomright_row + "," + bottomright_col);
	}

	public ArrayList<Integer> findMax1dSum(int[] col){
		int max = 0;
		int maxStart = -1;
		int maxEnd = -1;
		int currentStart = 0;
		int maxSoFar = 0;
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i=0; i < col.length; i++){
			maxSoFar += col[i];
			if(maxSoFar < 0){
				maxSoFar = 0;
				currentStart = i+1;
			}
			if(max < maxSoFar){
				maxStart = currentStart;
				maxEnd = i;
				max = maxSoFar;
			}
		}
		res.add(max);
		res.add(maxStart);
		res.add(maxEnd);
		return res;
	}
	
	public ArrayList<Integer> maxSubArrayCir(int[] A){
		int maxsofar=0, maxendinghere=0, start=0, end=0;
		ArrayList<Integer> res1 = findMax1dSum(A);
		for(int i=0; i<A.length; i++){
			maxendinghere += A[i];
			A[i] = -A[i];
		}
		ArrayList<Integer> res2 = findMax1dSum(A);
		maxendinghere = maxendinghere + res2.get(0);
		if(res1.get(0) < maxendinghere){
			ArrayList<Integer> res = new ArrayList<Integer>();
			res.add(maxendinghere);
			res.add(res2.get(2) + 1);
			res.add(res2.get(1) - 1);
			return res;
		}
		else return res1;
	}
	public static void main(String[] args) throws FileNotFoundException {

		maxSubArray msa= new maxSubArray();
		msa.findMaxSum(msa.parse("input.txt"));
	}

}
