package LeetCode;

public class countDigitOne {
    public int countDigitOne(int n) {
        int totalcount=0;
        for(int i=1;i<=n;i*=10){
            int left=n/i; int right=n%i;
            totalcount+= (left+8)/10 * i;
            if(left%10==1) totalcount+=right+1;
        }
        return totalcount;
    }

	public static void main(String[] args) {

	}

}
