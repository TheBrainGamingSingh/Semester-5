import java.util.*;

public class q4{

public static String foo(String str)
{
    char temp[] = str.toCharArray();
    Arrays.sort(temp);
    return new String(temp);
}
public static void main(String args[]){
 	Locale ENGLISH = Locale.forLanguageTag("en");
	System.out.println("Enter first String");
	String S1;

	Scanner cmd =new Scanner(System.in);
	S1 = cmd.nextLine();
	S1 = S1.toLowerCase(ENGLISH);

	System.out.println("Enter second String");
	String S2;

	//Scanner cmd =new Scanner(System.in);
	S2 = cmd.nextLine();
	S2 = S2.toLowerCase(ENGLISH);

	int n1 = S1.length();
	int n2 = S2.length();

	if(n1 != n2)
	{
		System.out.println("Strings are not anagrams of each other");
	}
	else
	{
		S1 = foo(S1);
		S2 = foo(S2);

		int flag = 0;
		for(int i = 0;i < n1 ; i++)
		{
			if(S1.charAt(i) != S2.charAt(i))
			{
				flag = 1;
			}
		}
			if(flag == 0)
			{
				System.out.println("Strings are anagrams of each other");
			}
			else
			{
				System.out.println("Strings are not anagrams of each other");
			}
		}
		return;
	}
}
