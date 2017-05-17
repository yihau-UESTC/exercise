package com.yihau.concurrency;

import java.sql.DatabaseMetaData;
import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("All daemons start");
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while(true){
			
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread() + " "+ this);
		
		}
		
	}

}
