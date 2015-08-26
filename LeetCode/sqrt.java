
public class sqrt {
	
	public int sqrt(int x) {     
        int l=0,r=x;
        while(l<=r){
        	int mid=(l+r)/2;
        	if(x/mid==mid) return mid;
        	else if(mid>x/mid){r=mid-1;}
        	else {l=mid+1;}
        }
        return r;      
    	}
 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sqrt s=new sqrt();
		System.out.println(s.sqrt(2147483647) );

	}

}
