import java.util.Scanner;

public class EditDistance {

	static int DP[][];
	static int count = 1;

	static int min(int a, int b, int c)
	{
		int x = a > b ? b : a;
    return (x < c ? x : c);
	}


	static void editDist(String str1, String str2)
	{
		    int l1 = str1.length();
        int l2 = str2.length();
        int i, j;
        int table[][] = new int[l1 + 1][l2 + 1];


        for(i = 0; i <= l1; i++)
            table[i][0] = i;

        for(i = 0; i <= l2; i++)
            table[0][i] = i;

        for(i = 1; i <= l1; i++)
        {
            for(j = 1; j <= l2; j++)
        	   {
        		     if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    table[i][j] = table[i - 1][j - 1];
        		     else
        			      table[i][j] = min(table[i - 1][j - 1],table[i - 1][j],table[i][j - 1]) + 1;
        	   }
        }
        DP = table;
	}

	static void printpath(String str1, String str2, String str, int i, int j)
	{
		if(i == 0 && j == 0)
		{
			System.out.println("Path #" + count + " : ----------------------------\n" + str);
			count++;
			return;
		}

		if(i == 0)
		{
			printpath(str1, str2, str + "Insert " + str2.charAt(j-1) + "\n" ,i,j-1);
			return;
		}

		if(j == 0)
		{
			printpath(str1, str2, str + "Remove " + str1.charAt(i-1) + "\n" ,i-1,j);
			return;
		}

		if(str1.charAt(i-1) == str2.charAt(j-1))
			printpath(str1, str2, str, i-1, j-1);
		else
		{
			if(DP[i][j] == DP[i-1][j] + 1)
				printpath(str1, str2, str + "Remove " + str1.charAt(i-1) + " \n", i-1, j);
		  if(DP[i][j] == DP[i][j-1] + 1)
		    printpath(str1, str2, str + "Insert " + str2.charAt(j-1) + " \n", i, j-1);
		  if(DP[i][j] == DP[i-1][j-1] + 1)
		    printpath(str1, str2, str + "Replace " + str1.charAt(i-1) + " with " + str2.charAt(j-1) + " \n", i-1, j-1);
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter string 1 : ");
		String str1 = sc.nextLine();

		System.out.println("Enter string 2 : ");
		String str2 = sc.nextLine();

		editDist(str1, str2);

		String str = "";

		printpath(str1, str2, str, str1.length(), str2.length());

	}

}
