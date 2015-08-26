
public class pow {
	
    public double pow(double x, int n) {
        
        if(n==0) return 1;
        
        if(n<0)
        {
            n=-n;
            x=1/x;
        }
        if( n%2==0 )
        	return pow(x*x,n/2); 
        else
        	return x*pow(x*x,n/2);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pow p=new pow();
		System.out.println(p.pow(3, 3));
	}

}
