import java.io.*;

interface Filter{
	boolean accept(String x);
}

class Filter1 implements Filter{
	public boolean accept(String x){
		if(x.length() <= 3)
			return true;

		return false;
	}
}
class Filter2 implements Filter{
	public boolean accept(String x){
		if(x.endsWith("s"))
			return true;

		return false;
	}
}
class Filter3 implements Filter{
	public boolean accept(String x){
		int j;
		for(j = 0; j < x.length() / 2; j++) {

			if(x.charAt(j) != x.charAt(x.length() - j - 1))
				return false;
		}
		return true;		
	}
}

class Filter_demo {

	public static String[] filter(String[] a,Filter f){
		int i,j,l = 0;
		boolean[] ar = new boolean[a.length];
		for(i = 0;i < a.length; i++ ){
			if(f.accept(a[i])) {
				ar[i] = true;
				l++;
			}
			else
				ar[i] = false;
		}
		String[] result = new String[l];
		for(i = 0, j = 0;i < a.length ; i++ ){
			if(ar[i]) {
				result[j++] = a[i];
			}
		}
			return result;
	}
	public static void main(String[] args){
		String[] input = {"aaa","a","axa","llllkkkk","s","awfewregers","sxs","lkkl"};
		Filter f1 = new Filter1();
		String[] res = filter(input,f1);
		
		System.out.println("Filter 1");
		for(int i = 0 ; i < res.length ; i++)
			System.out.print(res[i] + " ");
		System.out.println();

		Filter f2 = new Filter2();
		res = filter(input,f2);
		
		System.out.println("Filter 2");
		for(int i = 0 ; i < res.length ; i++)
			System.out.print(res[i] + " ");
		System.out.println();

		Filter f3 = new Filter3();
		res = filter(input,f3);
		
		System.out.println("Filter 3");
		for(int i = 0 ; i < res.length ; i++)
			System.out.print(res[i] + " ");
		System.out.println();
	}
}