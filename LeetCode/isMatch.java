
public class isMatch {
	
	public boolean isMatch(String s, String p){
		//base case
		if(p.length()==0) return s.length()==0;
		//p=1 special case
		if(p.length()==1 || p.charAt(1)!='*'){
			if(s.length()<1 || p.charAt(0)!=s.charAt(0) && p.charAt(0)!='.')
				return false;
			else return isMatch(s.substring(1),p.substring(1));
		}
		//p!=1
		else{
			int i=-1;
			while(i<s.length() && (i< 0 || p.charAt(0)=='.' || p.charAt(0)==s.charAt(i))){
				if(isMatch(s.substring(i+1), p.substring(2)))
					return true;
				i++;}
		}
		return false;
	}

	
	
	public boolean isMatch2(String s, String p) {
        if (p.contains(".") || p.contains("*")) {
            if (p.length() == 1 || p.charAt(1) != '*')
                return comp(s, p, s.length(), 0) && isMatch(s.substring(1), p.substring(1));
            for (int i = 0; i == 0 || comp(s, p, s.length(), i - 1); i++) {
                if (isMatch(s.substring(i), p.substring(2)))
                    return true;
            }
        }
        return s.equals(p);
    }

    private boolean comp(String s, String p, int sLen, int i) {
        return sLen > i && (p.charAt(0) == s.charAt(i) || p.charAt(0) == '.');
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 
	}

}
