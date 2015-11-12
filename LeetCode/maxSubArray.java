package LeetCode;

public class maxSubArray {
	
	public static int maxSubArray(int[] A){
		int maxsofar=0, maxendinghere=0;
		for(int i=0; i<A.length; i++){
			maxendinghere += A[i];
			maxendinghere = Math.max(A[i], maxendinghere);
			maxsofar = Math.max(maxendinghere, maxsofar);
		}
		return maxsofar;
	}
	
	public static int[] maxSubArrayIndex(int[] A){
		int maxsofar=0, maxendinghere=0, start=0, end=0;
		int[] res = new int[3];
		for(int i=0; i<A.length; i++){
			maxendinghere += A[i];
			if(maxendinghere < A[i]){
				start = i;
				maxendinghere = A[i];
			}
			if(maxendinghere > maxsofar){
				end = i;
				maxsofar = maxendinghere;
			}
		}
		res[0] = maxsofar;
		res[1] = start;
		res[2] = end;
		return res;	
	}

	public static int[] maxSubArrayCir(int[] A){
		int maxsofar=0, maxendinghere=0, start=0, end=0;
		int[] res1 = maxSubArrayIndex(A);
		for(int i=0; i<A.length; i++){
			maxendinghere += A[i];
			A[i] = -A[i];
		}
		int[] res2 = maxSubArrayIndex(A);
		maxendinghere = maxendinghere + res2[0];
		System.out.println(res1[0] + " : " + res2[0]);
		if(res1[0] < maxendinghere){
			int[] res = new int[3];
			res[0] = maxendinghere;
			res[1] = res2[2] + 1;
			res[2] = res2[1] - 1;
			return res;
		}
		else return res1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 0, -2, 1, 5};
		System.out.println(maxSubArray(A));
//		System.out.println(maxSubArrayIndex(A)[1] + ", " + maxSubArrayIndex(A)[2] + ", "+maxSubArrayIndex(A)[0] );
		int[] res2 = maxSubArrayCir(A);
		System.out.println(res2[1] + ", " + res2[2] + ", "+ res2[0] );
	}

}
