package HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class MovingAverage {
    
    static int n;
	static double sum;
	private static Queue<Double> window = new LinkedList<Double>();
     
    
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        try{
            Scanner in = new Scanner(System.in);
            n=Integer.parseInt(in.nextLine().trim());
            while (in.hasNextLine()) {
                double num = Double.parseDouble(in.nextLine().trim());
                sum += num;
                window.add(num);
                if (window.size() < n){
                    continue;
                }
                if (window.size() > n) {
                    sum -= window.remove();
                }
                System.out.println(String.format("%.4f", sum/n));

            }
    }
    catch (Exception ex){
		            ex.printStackTrace();
		        }
   
    }
}