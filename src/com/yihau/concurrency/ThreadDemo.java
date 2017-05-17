package com.yihau.concurrency;

import java.util.ArrayList;

public class ThreadDemo extends Thread{
	private int id;
	public ThreadDemo(int id){
		this.id = id;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread is running " + id);
		super.run();
	}
	
	public static void main(String[] args){
		for(int i = 0; i < 5; i++){
			new ThreadDemo(i).start();
		}
	}
}
