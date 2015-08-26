import java.util.Arrays;
import java.util.HashMap;


public class twosum {
	
	
	public int[] twoSum2(int[] numbers, int target) {  
        // Start typing your Java solution below  
        // DO NOT write main() function  
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        
        int n = numbers.length;  
        int[] result = new int[2];  
        for (int i = 0; i < numbers.length; i++)  
        {  
            if (map.containsKey(target - numbers[i]))  
            {  
                result[0] = map.get(target-numbers[i]) + 1;  
                result[1] = i + 1;  
                break;  
            }  
            else  
            {  
                map.put(numbers[i], i);  
            }  
        }  
        return result;  
          
    }  
	
	
	
	
	 
	 public int[] twoSum(int[] numbers, int target) {
	        int[] result = new int[2];
	        int[] old = new int[numbers.length];
	        System.arraycopy(numbers, 0, old, 0, numbers.length);  
	        Arrays.sort(old);  
	        int i=0;
	        int j=numbers.length-1;
	        while(i<j)
	        {
//	        	int tar=target-numbers[i];
	        	if(old[i]+old[j]>target)
	        		{j--;
	        	continue;}
	        	else if(old[i]+old[j]<target)
	        		{
//	        		System.out.println(numbers[i]+numbers[j]);
	        		i++;    
	        	continue;}
	    		else break;
	        }
	        
	        int n1=old[i];
	        int n2=old[j];
	        int a = -1,b=-1;
	        
	        for (int ii=0; ii<numbers.length;ii++){
	        	if(numbers[ii]==n1 || numbers[ii]==n2){
	        		if(a==-1){a=ii+1;}
	        		else b=ii+1;
	        	}
	        }
//	        System.out.println(a+" "+b);
	        result[0]=a;
	        result[1]=b;
	        Arrays.sort(result);
//	        System.out.println(result[0]+" "+result[1]);
			return result;
         
	        
	    }
	 


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] n = new int[4];
		n[0]=0;
		n[1]=4;
		n[2]=3;
		n[3]=0;
		
		twosum t=new twosum();
		
		int[] r=new int[2];
		
		r = t.twoSum2(n, 0);
		
		System.out.println(r[0]+" "+r[1]);
	
		
	}
	
}


