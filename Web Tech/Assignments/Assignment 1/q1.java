import java.util.*;

public class q1{
	public static void main(String args[]){

		System.out.print("Enter actual string : ");
		String S1;
		Locale ENGLISH = Locale.forLanguageTag("en");
		Scanner cmd = new Scanner(System.in);

		S1 = cmd.nextLine();
		S1 = S1.toLowerCase(ENGLISH);

		System.out.print("Enter string to be searched: ");
		String Pat;

		Pat = cmd.nextLine();
		Pat = Pat.toLowerCase(ENGLISH);
		int[] sarr,parr;
		sarr = new int[26];
		parr = new int[26];
		for(int i = 0;i < 26;i++)
		{
			sarr[i] = 0;
			parr[i] = 0;
		}


		for(int i = 0;i < Pat.length();i++){
			sarr[(int)(Pat.charAt(i) -'a')]++;
			parr[(int)(Pat.charAt(i) -'a')]++;
		}
		int len = Pat.length();
		int count = 0;
		int ans = 0;
		char c ='\0';

		for(int i = 0; i <= S1.length() - Pat.length();i++)
		{
			c = S1.charAt(i);

			if((sarr[(int)(c -'a')] > 0))
			{
				parr[(int)(c -'a')]--;
				count++;
				char d ='\0';

				for(int j = 1;j < len;j++)
				{
					d = S1.charAt(i+j);

					if((parr[(int)(d -'a')] > 0))
					{
						count++;
						parr[(int)(d-'a')]--;
					}
					else
						break;
				}

				if(count == len)
				{
					ans++;
				}
				else
					count = 0;
			}

			for(int j = 0;j < 26;j++)
				parr[j] = sarr[j];
			count = 0;
		}
		System.out.println("String is present " + ans + " times");
		return;
	}
}
