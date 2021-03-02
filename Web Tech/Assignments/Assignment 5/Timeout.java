import java.util.*;
import java.io.*; 

class Timer_Custom extends TimerTask implements Runnable { 
	Thread t;
	Timer_Custom(String name){
		t = new Thread(this,name);
		t.start();
	}
	public void run(){
		System.out.println("Code timeout");
	}
}

class Timeout{

	public static void main(String[] args) throws Exception { 
	Timer_Custom task = new Timer_Custom("task1");
	Timer time = new Timer();

	time.schedule(task,1000,1000); 
	try {
			task.t.join();
		}

	catch(InterruptedException exc) {
			System.out.println("done");
		}
	}
}