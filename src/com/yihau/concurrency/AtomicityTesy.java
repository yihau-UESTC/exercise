package com.yihau.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTesy implements Runnable {
	private  int i = 0;
	public synchronized int getValue(){
		return i;
	}
	public  synchronized void evenIncrement(){
		i++;
		i++;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicityTesy a = new AtomicityTesy();
		exec.execute(a);
		while(true){
			int val = a.getValue();
			if(val%2 != 0){
				System.out.println(val);
				System.exit(0);
			}
		}
		
	}
	@Override
	public  void run() {
		// TODO Auto-generated method stub
		while(true){
			evenIncrement();
		}
	}

}
