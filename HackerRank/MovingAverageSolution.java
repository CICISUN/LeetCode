package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MovingAverageSolution {

	
	static int n;
	static double sum;
	private static Queue<Double> window = new LinkedList<Double>();
	
	static int size;
	private static Queue<Double> window2 = new LinkedList<Double>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
        	
        String input="2 \n 1.000 \n 2.000 \n 3.000 \n 4.000";
        String input2=" 3 \n 0.500 \n 5.000 \n 5.000 \n 7.000 \n 10.000 \n 7.000 \n 7.000 \n 12.000 \n 7.000 \n 7.000 ";
        Scanner in = new Scanner(input);
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
            System.out.println(sum/n);
            
        }
        in.close();
        
        Scanner in2 = new Scanner(input2);
        double size = Integer.parseInt(in2.nextLine().trim());
        double per=Double.parseDouble(in2.nextLine().trim());
        double mid = 0;
        while (in2.hasNextLine()) {
            double num=Double.parseDouble(in2.nextLine().trim());
            window2.add(num);
            if (window2.size() < n){
            	continue;
            }
            if (window2.size() == n){
            	mid = findmid();
            }
            if (window2.size() > n) {
            	if(Math.abs(num-mid) / mid > per){
            		System.out.println(num);
            	}
                window2.remove();
            } 
        }
        in2.close();

    } catch (Exception ex) {
        ex.printStackTrace();
    }

	}
	
	public static double findmid(){
		ArrayList<Double> list = new ArrayList<Double>();
		for(double i : window2){
			list.add(i);
		}
		Collections.sort(list);
		
		if(n%2==0){
			return (list.get(n/2) + list.get(n/2-1)) / 2.0 ;
		}
		else return list.get(n/2);
	}

}
