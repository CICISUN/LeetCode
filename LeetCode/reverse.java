
public class reverse {
	
	public int reverse(int x) {
        int res=0,num=Math.abs(x);
        boolean sign=x>0? true:false;
        while(num!=0){
        	if(res>(Integer.MAX_VALUE-num%10)/10) return 0;
            res=num%10+res*10;
            num=num/10;
        }
    
        return sign? res:-res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverse r=new reverse();
		System.out.println(r.reverse(-123));
	}

}
