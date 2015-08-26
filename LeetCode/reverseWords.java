
public class reverseWords {

	public String reverseWords(String s) {
		if(s==null||s.length()==0) return "";
		String[] words=s.split(" ");
		int n=words.length;
		StringBuilder sb=new StringBuilder();
		for(int i=n-1; i>=0;i--){
			if(!words[i].equals("")){
				sb.append(words[i]).append(" ");}
		} return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}


//	
//	  public String reverseWords(String s) {
//	        if (s == null || s.length() == 0) {
//	            return "";
//	        }
//
//	        String[] array = s.split(" ");
//	        StringBuilder sb = new StringBuilder();
//
//	        for (int i = array.length - 1; i >= 0; --i) {
//	            if (!array[i].equals("")) {
//	                sb.append(array[i]).append(" ");
//	            }
//	        }
//
//	        //remove the last " "
//	        return sb.toString();
//	    }
//	  
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseWords s=new reverseWords();
		System.out.println(s.reverseWords("I love    hahaha"));
	}

}
