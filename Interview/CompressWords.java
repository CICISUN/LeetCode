package Interview;

import java.util.ArrayList;
import java.util.List;

public class CompressWords {
	
	public static List<String> CompressWords(String s){
		List<String> res=new ArrayList<String>();
		compress(res,s, "");
		return res;
	}
	
	private static void compress(List<String> res, String s, String done){
		if(s.equals("")){
			res.add(validate(done));
			return;
		}
		compress(res, s.substring(1), done+s.substring(0,1));
		compress(res, s.substring(1), done+"1");
	}
	private static String validate(String s){
		int count=0, i=0; String res="";
		while(i<s.length()){
			if(s.charAt(i)=='1'){
				count=1;
				while((i+1)<s.length() && s.charAt(i+1)=='1'){
					count++;
					i++;
				}
				res+=String.valueOf(count);
			}
			else res+=s.charAt(i);
			i++;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CompressWords("car"));
		 
	}

}
