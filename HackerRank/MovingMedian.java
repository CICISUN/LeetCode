package HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class MovingMedian {
    static int n;
    static double per;
    static double mid;
	private static Queue<Double> window = new LinkedList<Double>();
    
    	
	public static double findmid(){
		ArrayList<Double> list = new ArrayList<Double>();
		for(double i : window){
			list.add(i);
		}
		Collections.sort(list);
		
		if(n%2==0){
			return (list.get(n/2) + list.get(n/2-1)) / 2.0 ;
		}
		else return list.get(n/2);
	}
    
    public static void main(String args[] ){
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
             try{
            	 String input=" 3 \n 0.500 \n 1.000 \n 2.000 \n 3.000 \n 34.000 \n 4.000 \n 5.000 \n 12.000 \n 7.000 \n 7.000 ";
            Scanner in = new Scanner(input);
            n = Integer.parseInt(in.nextLine().trim());
            per=Double.parseDouble(in.nextLine().trim());
            while (in.hasNextLine()) {
                double num=Double.parseDouble(in.nextLine().trim());
                if (window.size() < n){
                	window.add(num);
                    continue;
                }
                if (window.size() == n){
                    mid = findmid();
                    window.add(num);
                }
                if (window.size() > n) {
                    if(Math.abs(num-mid) / mid > per){
                        System.out.println(String.format("%.3f", num));
                    }
                    window.remove(); 
                }
           }
           in.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }   
    }
                                           
                                           
    
}