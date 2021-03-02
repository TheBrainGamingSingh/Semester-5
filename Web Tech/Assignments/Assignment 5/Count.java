import java.util.*;
import java.io.*; 

class Count implements Runnable{
	Thread t;
	Count(String thread_name){
		t = new Thread(this,thread_name);
		t.start();
	}
	public void run(){

		try {
			for(int i = 0; i < 101; i++){
				if(i%10 == 0)
					System.out.print("Woooohoooo ");
				System.out.println(i);
				Thread.sleep(1000);
			}	
		}
		catch(InterruptedException e) {
			System.out.println("Interrupted");
		}
	}

	public static void main(String[] args){
		Count temp = new Count("Count 100");
	
		try {
				temp.t.join();
		}
		catch(InterruptedException e) {
				System.out.println("Interrupted");
		}
	}
}