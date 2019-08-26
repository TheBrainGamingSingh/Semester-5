import java.util.*;

public class q4{
	
public static String sorting(String str) 
{ 
    char temp[]=str.toCharArray(); 
    Arrays.sort(temp); 
    return new String(temp); 
}
public static void main(String args[]){

System.out.print("Enter String 1: ");
String mystring;
Locale ENGLISH = Locale.forLanguageTag("en");
Scanner sc=new Scanner(System.in);
mystring=sc.nextLine();
mystring=mystring.toLowerCase(ENGLISH);
System.out.print("Enter String 2: ");
String mystring1;
Scanner sc1=new Scanner(System.in);
mystring1=sc1.nextLine();
mystring1=mystring1.toLowerCase(ENGLISH);
int n1=mystring.length();
int n2=mystring1.length();
if(n1!=n2){
	System.out.print("Strings are not anagram");
}
else{
	mystring=sorting(mystring);
	mystring1=sorting(mystring1);
	int check=0;
	for(int i=0;i<n1;i++){
		if(mystring.charAt(i)!=mystring1.charAt(i)){
			check=1;
		}
	}
	if(check==0){
		System.out.print("Strings are anagram");
	}
	else{
		System.out.print("Strings are not anagram");
	}
}
return;
}
}
