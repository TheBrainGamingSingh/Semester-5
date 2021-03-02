import java.util.*;
import java.io.*;

class Div implements Runnable{
	Thread t;
	int lb;
	int ub;
	int max;
	int divcount;
	int div_max;
	Div(String thread_name,int lower,int upper){
		t = new Thread(this,thread_name);
		lb = lower;
		ub = upper;
		t.start();
	}
	static int max(int a ,int b){
		return a > b ? a : b;
	}
	public void run(){

		for ( int j = lb ; j <= ub ; j++) {
			divcount = 1;
			for( int i = 1 ; i <= Math.sqrt(j) ; i++) {
				if( j % i == 0 ){
					if(j/i == i)
						divcount++;
					else
						divcount = divcount + 2;
				}
				if( divcount > div_max ) {
					div_max = divcount;
					max = j;
				}
			}
		}
	}

	public static void main(String[] args){
		Div ob1 = new Div("One",1,20000);
		Div ob2 = new Div("Two",20001,40000);
		Div ob3 = new Div("Three",40001,60000);
		Div ob4 = new Div("Four",60001,80000);
		Div ob5 = new Div("Five",80001,100000);
		try{
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
			ob4.t.join();
			ob5.t.join();
		}
		catch(Exception e){
			;
		}
		System.out.println(ob1.max + " "+ ob1.div_max);
		System.out.println(ob2.max + " "+ ob2.div_max);
		System.out.println(ob3.max + " "+ ob3.div_max);
		System.out.println(ob4.max + " "+ ob4.div_max);
		System.out.println(ob5.max + " "+ ob5.div_max);
	}
}
