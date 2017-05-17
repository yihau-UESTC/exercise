package com.yihau.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOff implements Runnable {
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	
	public LiftOff(){
		
	}
	public LiftOff(int countDown){
		this.countDown = countDown;
	}
	public String status(){
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!" ) + "),";
	}
	@Override
	public void run() {
		while(countDown-- > 0){
			System.out.println(status());
			Thread.yield();
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

	public static void main(String[] args) {
		ExecutorService exes = Executors.newCachedThreadPool();
		for(int i = 0; i<4; i++){
			exes.execute(new LiftOff());
		}
		exes.shutdown();//这个表明不在接受新的线程任务
			
	}

}
