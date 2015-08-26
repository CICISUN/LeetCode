////http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
////Problem: Given two strings of size m, n.
////Find minimum number of edits required to convert.
//http://www.geeksforgeeks.org/fundamentals-of-algorithms/

public class MinEditDis{
	
	
	int editDistance (String x, String y)
	{
	 if (x == null||x.length() <=0)
	     return y.length(); // base case
	 if (y == null||y.length() <=0)
	     return x.length(); // base case
	  else
	    {
	      int addDistance = editDistance(x, y.substring(1)) + 1;
	      int removeDistance = editDistance(x.substring(1), y) + 1;
	      int changeDistance = editDistance(x.substring(1), y.substring(1)) + ((x.charAt(0) == y.charAt(0)) ? 0 : 1);
	      return Math.min(Math.min(addDistance, removeDistance), changeDistance);
	    }
	}

	public static void main(String[] args) {

	MinEditDis test = new MinEditDis();
		int p=test.editDistance("saturday", "sunday");
		System.out.println(p);}}
