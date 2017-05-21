package com.yihau.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
	private ReentrantLock lock = new ReentrantLock();
	public void untimed(){
		boolean captured = lock.tryLock();
		try{
			System.out.println("tryLock(): "+captured);
		}finally{
			if(captured){
				lock.unlock();
			}
		}
	}
	public void timed(){
		boolean captured = false;
		try{
			captured = lock.tryLock(2, TimeUnit.SECONDS);
		}catch(InterruptedException e){
			throw new RuntimeException();
		}
		try{
			System.out.println("tryLock(2, TimeUnit.SECONDS): "+captured);
		}finally{
			if(captured)lock.unlock();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final AttemptLocking a = new AttemptLocking();
		a.untimed();
		a.timed();
		new Thread(){
			{setPriority(MAX_PRIORITY);}
			public void run(){
				a.lock.lock();
				System.out.println("get");
			}
		}.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.untimed();
		a.timed();
	}

}
