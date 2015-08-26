
public class strStr {

	public int strStr(String haystack, String needle) 
	{  

		int n = haystack.length();  
		int m = needle.length(); 

		if (n==0 && m!=0) return -1;
		else if(n==0||m==0) return 0;
		 
		else{
			for (int i = 0; i < n - m+1; i++)  
			{  int j=i;

			for (; j < m+i; j++)  
			{  
				if (needle.charAt(j-i) != haystack.charAt(j)) break;  
			}  
			if (j == m+i) return  i;

			}  
			return -1;  }
	}  



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		strStr s=new strStr();
		System.out.println(s.strStr("a", "a"));
	}

}
