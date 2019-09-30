import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ques3{

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the number of elements");
    	int num = sc.nextInt();
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	System.out.println("Enter the Elements");
    	for(int i=0;i<num;i++) {
    		int temp = sc.nextInt();
    		if(map.containsKey(temp)){
    			map.put(temp,map.get(temp) + 1);
    		}else {
    			map.put(temp, 1);
    		}
    	}

    	System.out.println("Enter the Value of K");
    	int K = sc.nextInt();
    	int bench_mark = num / K;

    	boolean flag = false;

    	Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
        while(itr.hasNext())
        {
             Map.Entry<Integer, Integer> entry = itr.next();
             if(entry.getValue() > bench_mark) {
            	 if(flag == false) {
            		 System.out.print("Elements that Appear more than N/K times are --> ");
            		 flag = true;
            	 }
            	 System.out.println(entry.getKey() + " ");
             }
        }

        if(flag == false) {
        	System.out.println("No Such Elements Found");
        }
    }
}
