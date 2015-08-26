
public class maxArea {
	
	public int maxArea(int[] height) {
        if(height==null) return -1;
        int curmax=-1, maxsofar=-1, l=0,r=height.length-1;
        while(l<r){
        	curmax=(r-l)*Math.min(height[l],height[r]);
        	System.out.println(curmax);
        	if(curmax>maxsofar){
        		maxsofar=curmax;
        	}
        	if(height[l]<height[r]){
        		//move r-- would never increase area with same l
        		int tmp=height[l];
        		while(l<r && height[l]<=tmp)
        		l++;
        	}
        	else{
        		int tmp=height[r];
        		while(l<r && height[r]<=tmp)
        		r--;
        	}
        }
        
        return maxsofar;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxArea m=new maxArea();
		int[] h={1,2,4,3};
		System.out.println(m.maxArea(h));
	}

}
