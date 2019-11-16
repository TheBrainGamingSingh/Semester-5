import java.util.*;
import java.io.*; 

class Para implements Runnable{
	Thread[] t;
	String[] st;
	int c = 0;
	int max;
	Para(String paragraph , int thread_num){
		t = new Thread[thread_num];
		max = thread_num;
	}
	public void run(){
		System.out.println(st[c]+" "+Thread.currentThread().getName());
		c++;
	}
	public void print(){
		int turn = 0;
		int prev = 0;
		while(c < st.length){
			t[turn] = new Thread(this,"thread"+turn);
			t[turn].start();		
			try{
				prev = turn;
				turn = (turn + 1) % max;
				t[prev].join();
			}
			catch(InterruptedException e){
				;
			}
		}
	}
	public static void main(String[] args){
		String paragraph = "You are given a paragraph, which contain n number of words, you are given m threads. What you need to do is, each thread should print one word and give the control to next thread, this way each thread will keep on printing one word , in case last thread come, it should invoke the first thread. Printing will repeat until all the words are printed in paragraph. Finally all threads should exit gracefully. Write a program to implement this. ";
		int n = 10;
		Para ob = new Para(paragraph, n);
		ob.st = paragraph.split(" ");
		ob.print();
	}
}