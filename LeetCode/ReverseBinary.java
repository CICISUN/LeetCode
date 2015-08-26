
public class ReverseBinary {
	
	public String ReverseBinary(int d){
		int n=Integer.toBinaryString(d).length();
		StringBuffer sb=new StringBuffer();
		System.out.println(" d "+d);
		while(d!=0){
			   sb.append(d ^ 0x01);
			   System.out.println(" d "+d+" sb "+sb+ " "+0x01);
			   d >>= 1;
			   System.out.println(" d: "+d+ " b "+Integer.toBinaryString(d));
		}
		String s=sb.toString();
		System.out.println(" s: "+s);
		String res=Integer.valueOf(s, 2).toString();
		return res;
	}
	
	public String ReverseBinary2(int d){
		int n=Integer.toBinaryString(d).length();
		String res="";
		System.out.println(" d "+d);
		while(d!=0){
			   int tmp = 1-d & 0x01;
			   System.out.println(" d "+Integer.toBinaryString(d) +" tmp "+tmp);
			   res=tmp+res;
			   d >>= 1;
			   System.out.println(" d: "+d+ " b "+Integer.toBinaryString(d));
		}
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseBinary r=new ReverseBinary();
		r.ReverseBinary2(15);
		
//		String s=Integer.toBinaryString(15);
//		int d=15;
//		d<<=1;
//		System.out.println(s);
//		System.out.println(Integer.toBinaryString(d));
	 
	}

}
