import java.util.*;

public class q2{
	public static void main(String args[]){
		Scanner cmd = new Scanner(System.in);
		System.out.print("Enter the paragraph\n");
		String para = cmd.nextLine();
		Vector<String> V = new Vector<String>();
		System.out.print("Enter the words to be replaced\n");
		String line = cmd.nextLine();
		Scanner linesc = new Scanner (line);
		while (linesc.hasNext()) {
			String nextWord = linesc.next();
				V.add(nextWord);
		}

		String curr = "";
		String output = "";
		char ele ='\0';
		int flag  = 0;
		for(int i = 0;i < para.length();i++){
			ele = para.charAt(i);
			if( ele != ' ' && (ele != '.' && ele !='?')){
				curr = curr + ele;

			}
			else
			{
				String temp;
				temp = "";
				flag = 0;
				for(int j=0;j<V.size();j++){

					if(curr.equals(V.get(j))){
						flag = 1;
						char a;
						for(int k = 0;k < curr.length();k++){
							a = curr.charAt(k);
							if(k == 0)
								temp = temp + a;
							else
								temp = temp + '*';
						}
						if(ele != '.' && ele != '?' && ele != '!')
							output = output + temp + " ";
						else
							output = output + temp;
						temp = "";
					}
				}

				if(flag == 0 && ele != '.' && ele != '?' && ele != '!')
					output = output + curr + " ";
				else if((i != para.length() - 1 && flag == 1) && (ele == '.' || ele == '?' || ele == '!'))
					output = output + ele;
				else if((i != para.length() - 1 && flag == 0) && (ele == '.' || ele == '?' || ele == '!'))
					output = output + curr + ele;
				if(i != para.length() - 1)
					curr = "";
			}
		}

		if(flag == 0)
		{
			if(ele == '.' || ele == '?' || ele == '!')
				output = output + curr +ele;
			else
				output = output + curr;
		}
		System.out.print(output);
		System.out.println('\n');
		return;
	}
}
