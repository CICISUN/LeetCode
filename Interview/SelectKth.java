package Interview;

public class SelectKth {
	//Google
	
	public void QuickSelect(int[] arr, int i, int j, int k){
		while(i<j){
			int pivot=(i+j)/2;
			if(arr[i] > arr[pivot]){
				
			}
		}
	}
	
	public void partition(int[] arr, int i, int j){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectKth kth=new SelectKth();
		int[] arr = {1,2,3,4};
		kth.QuickSelect(arr, 0, arr.length-1, 3);
	}

}
