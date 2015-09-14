package LeetCode;

public class compareVersion {

    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len = Math.min(s1.length, s2.length);
        for(int i=0;i<len;i++){
            if(Integer.valueOf(s1[i]) < Integer.valueOf(s2[i])){
                return -1;
            }
            else if(Integer.valueOf(s1[i]) > Integer.valueOf(s2[i])){
                return 1;
            }
        }
        if(s1.length>s2.length){
        	int i=len;
        	while(i<s1.length){
        		if(Integer.valueOf(s1[i])==0)
        			i++;
        		else return 1;
        	}
        };
        if(s1.length<s2.length){
        	int i=len;
        	while(i<s2.length){
        		if(Integer.valueOf(s2[i])==0)
        			i++;
        		else return -1;
        	}
        };
        
        return 0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compareVersion("1.0", "1"));
	}

}
