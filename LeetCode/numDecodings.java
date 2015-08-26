package LeetCode;

public class numDecodings {
    public int numDecodings(String s) {
        if(s.length() == 0 || s==null || s.charAt(0) == '0')
        return 0;
        int[] ways = new int[s.length()+1];
        ways[s.length()] = 1;
        for(int i=s.length()-1; i>=0;i--){
            if(s.charAt(i) == '0') ways[i]=0;
            else ways[i] = ways[i+1];
            if(i+1<s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) <= '6'))
                ways[i] = ways[i] + ways[i+2];
        }
        System.out.println(ways[0]);
        return ways[0];
    }
    
    
    public int numDecodings3(String s) {
    	int[] ways = new int[s.length()+1];
    	if(s==null || s.length()==0 || s.charAt(0)=='0') return 0;
    	ways[0] = 1;
    	ways[1] = 1;
    	for(int i=2;i<=s.length();i++){
    		if(s.charAt(i-1)=='0'){
    			if(s.charAt(i-2)=='1' ||s.charAt(i-2)=='2'){ways[i]=ways[i-2]; }
    			else return 0;
    		}
    		else{
    			if(s.charAt(i-1)<='6' && s.charAt(i-2)=='2' || s.charAt(i-2)=='1'){
    				ways[i]=ways[i-1]+ways[i-2];
    			}   
    			else ways[i]=ways[i-1];
    		}
    	}
    	return ways[s.length()];
    }
    
    public int numDecodings2(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0') return 0;
        
        int num1=1;
        int num2=1;
        int num3=1;
        for(int i=1;i<s.length();i++)
        {
       
            if(s.charAt(i)=='0')
            {
                if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2')
                    num3 = num1;
                else
                    return 0;
            }
            else
            {
                if(s.charAt(i-1)=='0' || s.charAt(i-1)>='3')
                    num3 = num2;
                else
                {
                    if(s.charAt(i-1)=='2' && s.charAt(i)>='7' && s.charAt(i)<='9')
                        num3 = num2;
                    else
                        num3 = num1+num2;
                }
            }
            num1 = num2;
            num2 = num3;
         	System.out.println(num1 + " :"+ num2 +" :"+ num3);
        }
        return num2;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numDecodings n = new numDecodings();
		System.out.println(n.numDecodings2("123"));

	}

}
