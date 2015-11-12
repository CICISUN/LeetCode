package Interview;

public class AddtwoMinusTwo {
	//Snapchat

	public static String addtwo(String a, String b){
		String l=a.length()>b.length() ? a : b;
		String s=a.length()<=b.length() ? a : b;
		int p1=l.length()-1, p2=s.length()-1;
		int carry=0;
		String res="";
		while(p2>=0){
			int sum = l.charAt(p1) - '0' + s.charAt(p2) - '0' + carry;
			res = String.valueOf(sum%10) + res;
			carry=sum/10;
			p1--; p2--;
		}
		while(p1>=0){
			int sum = l.charAt(p1) - '0' + carry;
			res = String.valueOf(sum%10) + res;
			carry=sum/10;	
			p1--;
		}
		if(carry!=0){
			res = String.valueOf(carry) + res;
		}
		return res;
	}

	public static String minustwo(String a, String b){
		String l=a.length()>b.length() ? a : b;
		String s=a.length()<=b.length() ? a : b;
		boolean neg = a==l ? false : true;
		int p1=l.length()-1, p2=s.length()-1;
		int carry=0;
		String res="";	
		while(p1>=0){
			//int sub =  l.charAt(p1) - '0' - s.charAt(p2) - '0' + carry;
			int n1 = l.charAt(p1) - '0', n2 = carry;
			if(p2 >= 0) n2 = s.charAt(p2) - '0' + n2;
			carry=0;
			if(n1 < n2){
				carry = 1;
				int sum = n1 - n2 + 10;
				res = String.valueOf(sum) + res;
			}
			else{
				int sum = n1 - n2;
				res = String.valueOf(sum) + res;
			}
			p1--;p2--;
		}
		int nLeadingZeros=0;
		for(int i=0;i<res.length();i++){
			if(res.charAt(i)=='0'){
				nLeadingZeros++;
			}
			else break;
		}
		res=res.substring(nLeadingZeros);
		
		if(neg) res="-"+res;
		return res;
	}



	public static void main(String[] args) {
		//8-100
		System.out.println(addtwo("12121212212123", "19"));
		System.out.println(minustwo("8", "100"));
	}

}
