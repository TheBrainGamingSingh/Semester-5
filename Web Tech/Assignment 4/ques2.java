import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ques2{

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the number of elements");
    	int arr[] = new int[100];
    	int num = sc.nextInt();
    	for(int i=0;i<100;i++) {
    		arr[i] = 0;
    	}
    	for(int i=0;i<num;i++) {
    		int temp = sc.nextInt();
    		arr[temp - 1] = -1;
    	}

    	boolean flag = false;
    	for(int i=0;i<100;i++) {
    		if(flag == false) {
    			System.out.print("Missing Numbers are --> ");
    			flag = true;
    		}

    		if(arr[i] != -1)
    			System.out.print(i+1 + " ");
    	}

    	if(flag == false) {
    		System.out.println("No Missing Numbers");
    	}
    }
}
