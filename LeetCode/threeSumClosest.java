import java.util.Arrays;


public class threeSumClosest {
	public int threeSumClosest(int[] num, int target) {
        int cls=256256,res=256256;
        int l=0,r=0;
         int[] newnum = new int[num.length];
        System.arraycopy(num, 0, newnum, 0, num.length);  
        Arrays.sort(newnum); 
        for(int i=0;i<num.length;i++){
            l=i+1; r=num.length-1;
            while(l<r){
            	int sum=newnum[i]+newnum[l]+newnum[r];
            	int diff=Math.abs(target-sum);
//            	System.out.println("round"+i+"l="+l+"r="+r+"="+Math.abs(target-(newnum[i]+newnum[l]+newnum[r])));
            	if(diff==0) return sum;
            	
                else if (diff<cls){
                    cls=diff;
                     
                    res=sum;
                    }
            	
                else if(sum-target<=0) l++;
            	
                else {r--;}
            }
        }
        
        return res;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		threeSumClosest t=new threeSumClosest();
		int[] num={1,1,1,1};
		System.out.println(t.threeSumClosest(num, -1));
	}

}
