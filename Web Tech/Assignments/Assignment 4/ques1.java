import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ques1{

	static boolean All_Unique(String str) {
		char tempArray[] = str.toCharArray();
        Arrays.sort(tempArray);
        String new_string = new String(tempArray);
        for(int i=0;i<new_string.length()-1;i++) {
        	if(new_string.charAt(i) == new_string.charAt(i+1)) {
        		return false;
        	}
        }
		return true;
	}

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the String");
    	String str = sc.next();
    	if(All_Unique(str)) {
    		System.out.println("Yes, All the Characters are Unique");
    	}else {
    		System.out.println("No, not all the Characters are Unique");
    	}
    }
}
