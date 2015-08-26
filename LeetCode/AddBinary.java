package LeetCode;

public class AddBinary {

	
public String addBinary(String a, String b) {
		
//		if(a==null|a.length()==0)
//			return b;
//		if(b==null|b.length()==0)
//			return a;

//        if(a.length() < b.length()){
//            String temp = a;
//            a = b;
//            b = temp;
//        }
//        
//        int m = a.length()-1;
//        int n = b.length()-1;
//        int res = 0;
//        String rst = "";
//        
//        while(n >= 0){
//
//            int sum = (int)(a.charAt(m) - '0') + (int)(b.charAt(n) - '0') + res;
//            rst = String.valueOf(sum % 2) + rst;
//            res = sum / 2;
//            m --;
//            n --;
//        }
//        
//        while(m >= 0){
//            int sum = (int)(a.charAt(m) - '0') + res;
//            rst = String.valueOf(sum % 2) + rst;
//            res = sum / 2;
//            m --;
//        }       
//        
//        if (res == 1)
//            rst = "1" + rst;
//        return rst;
//    }
//	
//	
	
	
	  if (a == null || a.length() == 0)
          return b;
      if (b == null || b.length() == 0)
          return a;

      int m = a.length(), n = b.length();
      StringBuilder res = new StringBuilder();
      int i = m - 1, j = n - 1;
      int x, y, c = 0;
      while (i >= 0 || j >= 0) {
          x = (i >= 0) ? a.charAt(i) - '0' : 0;
          y = (j >= 0) ? b.charAt(j) - '0' : 0;

  		System.out.println(x^y^c);
          res.append(x ^ y ^ c);
          System.out.println(x+y+c);
          c = (x + y + c >= 2) ? 1 : 0;
          System.out.println(res);
          i--;
          j--;
      }
      if (c == 1)
          res.append(1);

      return res.reverse().toString();
      
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AddBinary a=new AddBinary();
		
		System.out.println(a.addBinary("111", "11"));
 	
	}

}
