package Interview;

public class SortUserName {
	
	//Snapchat
	//http://www.1point3acres.com/bbs/thread-112344-1-1.html
	
	public static int sort(String a, String b){
		boolean reversed = b.length() < a.length();
		String less = a.length() > b.length() ? b : a;
		String more = a.length() <= b.length() ? b : a;
		int p1=0, p2=0;
		while(p1<less.length() && less.charAt(p1) > '9' && more.charAt(p2) > '9'){
			if(less.charAt(p1) < more.charAt(p2)){
				return reversed ? 1 : -1; 
			}
			else if(less.charAt(p1) > more.charAt(p2)){
				return reversed ? -1 : 1;
			}
			p1++; p2++;
		}
		if(p1==less.length()){
			return reversed ? 1 : -1; 
		}
		else if(less.charAt(p1) <= '9' && more.charAt(p2) > '9'){
			return reversed ? 1 : -1;
		}
		else if(less.charAt(p1) > '9' && more.charAt(p2) <= '9'){
			return reversed ? -1 : 1;
		}
		while(less.charAt(p1) == '0' || more.charAt(p2) == '0'){
			if(less.charAt(p1)=='0') p1++;
			if(more.charAt(p2)=='0') p2++;
		}
		if(less.length() - p1 > more.length() - p2) return reversed ? -1 : 1;
		else if(less.length() - p1 < more.length() - p2) return reversed ? 1 : -1;
		while(p1 < less.length() && p2 < more.length()){
			if(less.charAt(p1) < more.charAt(p2)) return reversed ? 1 : -1;
			else if(less.charAt(p1) > more.charAt(p2)) return reversed ? -1 : 1;
			p1++;p2++;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] A = {"ab123", "ac123", "abc123456789", "bac006789", "00020", "ac"};
		String[] B = {"ac123", "ac321" ,"abcd12345789", "bac1234", "123", "ab"};
		for(int i=0; i<A.length; i++){
			System.out.println(sort(A[i], B[i]));
		}

	}

}
