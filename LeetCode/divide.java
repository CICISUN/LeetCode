package LeetCode;

public class divide {

    public static int divide(int dividend, int divisor) {  
    	boolean pos;
    	if(divisor == 0) return Integer.MAX_VALUE;
    	if(dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) pos = true;
    	else pos = false;
    	
        long a = Math.abs((long) dividend);  
        long b = Math.abs((long) divisor);  
        if (b > a) {  
            return 0;  
        }  
  
        long sum = 0;  
        long pow = 0;  
        long result = 0;  
        while (a >= b) {  
            pow = 1;  
            sum = b;  
            while (sum + sum <= a) {  
                sum += sum;  
                pow += pow;  
            }  
            a -= sum;  
            result += pow;  
        }  
        System.out.println(result);
 
        return pos ? (int)result : -(int)result;  
    }
    
    public static int divide3(int dividend, int divisor){
    	  if (dividend == 0 || divisor == 0) { 
              return 0; 
          } 
          boolean isNeg = (dividend > 0 && divisor < 0) 
                  || (dividend < 0 && divisor > 0); 
          long a = Math.abs((long) dividend); 
          long b = Math.abs((long) divisor); 
          long bb = Math.abs((long) divisor); 
          if (b > a) { 
              return 0; 
          } 
          long sum = 0; 
          long pow = 0; 
          long count = 1;
          long result=0;
          while(a>bb){
        	  bb=bb<<1;
        	  count=count<<1;
          }
         
          while (a>=b){
              while (a>=bb){
                  a -= bb;
                  result = result+count;
              }
              bb=bb>>1;
        	  count=count>>1;    
          }
          System.out.println(result);
          result = ((((dividend ^ divisor) >> 31) & 1) == 1) ? -result: result;
          System.out.println(result);
          if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
         	 
             return Integer.MAX_VALUE;
          }
          
          return (int)result;       
    }
    
    public static int divide2(int dividend, int divisor) { 
        if (dividend == 0 || divisor == 0) { 
            return 0; 
        } 
        boolean isNeg = (dividend > 0 && divisor < 0) 
                || (dividend < 0 && divisor > 0); 
        long a = Math.abs((long) dividend); 
        long b = Math.abs((long) divisor); 
        if (b > a) { 
            return 0; 
        } 
   
        long sum = 0; 
        long pow = 0; 
        long result = 0; 
        while (a >= b) { 
            pow = 1; 
            sum = b; 
            while (sum + sum <= a) { 
                sum += sum; 
                pow += pow; 
            } 
            a -= sum; 
            result += pow; 
        }
        System.out.println(result);
        result = ((((dividend ^ divisor) >> 31) & 1) == 1) ? -result: result;
        System.out.println(result);
       
        
         if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
        	 
            return Integer.MAX_VALUE;
         }
          
         return (int)result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide3(-1,1));
		
	}

}
