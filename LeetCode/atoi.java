package LeetCode;

public class atoi {
	
	public int atoi(String str){
		if(str==null) return 0;
		str=str.trim();
		int n=str.length(),i=0;
		long res=0;
		if(n==0) return 0;
		int sign = 1;
		if(str.charAt(i)=='+') {sign=1;i++;}
		else if(str.charAt(i)=='-') {sign=-1;i++;}
		for(;i<n;i++){
			char tmp=str.charAt(i);
			if(tmp>'9'||tmp<'0'||tmp==' ') break;
			res=res*10+(tmp-'0');
			if(res>Integer.MAX_VALUE) break;	
		}
		if(res>Integer.MAX_VALUE) return sign==1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
		return (int)res*sign;
	}
	
	public int atoi2(String str) {
		if(str==null) return 0;
		str=str.trim();
		int n=str.length(),i=0;
		int res=0;
		if(n==0) return 0;
		int sign = 1;
		if(str.charAt(i)=='+') {sign=1;i++;}
		else if(str.charAt(i)=='-') {sign=-1;i++;}
		for(;i<n;i++){
			char tmp=str.charAt(i);
			if(tmp>'9'||tmp<'0'||tmp==' ') break;
			System.out.println(res);
			if(Integer.MAX_VALUE/10 < res || (Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE%10 <(str.charAt(i) - '0'))) 
				return sign==1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;	
			
			res=res*10+(tmp-'0');
		
			 
		}
	 
		return (int)res*sign;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		atoi a=new atoi();
		System.out.println("result:"+a.atoi2("-1010023630o4"));
		System.out.println(Integer.MAX_VALUE);
	}

}
