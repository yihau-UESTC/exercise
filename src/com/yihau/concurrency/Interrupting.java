package com.yihau.concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/**
 * 从输出中可以看出来，sleep的阻塞可以被中断，而IO和Synchronized的阻塞不可中断，
 * @author UMC-yihau
 *
 */
class SleepBlocked implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("InterruptedException");
		}
		System.out.println("Exiting SleepBlocked.run()");
	}
	
}

class IOBlocked implements Runnable{
	private InputStream in;
	public IOBlocked(InputStream is){
		in = is;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Waiting for read():");
		try {
			in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			if(Thread.currentThread().isInterrupted()){
				System.out.println("Interrupted from blocked I/O");
			}else{
				throw new RuntimeException(e);
			}
		}
		System.out.println("Exiting IOBlocked.run()");
	}
	
}

class SynchronizedBlocked implements Runnable{
	public synchronized void f(){
		while(true){
			Thread.yield();
		}
	}
	 public SynchronizedBlocked() {
		// TODO Auto-generated constructor stub
		 new Thread(){
			 public void run(){
				 f();
			 }
		 }.start();
	 }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Trying to call f()");
		f();
		System.out.println("Exiting SynchronizedBlocked.run()");
	}
	
}
public class Interrupting {
	private static ExecutorService exec = Executors.newCachedThreadPool();
	static void test(Runnable r) throws InterruptedException{
		Future<?> f = exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Interrupting" + r.getClass().getName());
		f.cancel(true);
		System.out.println("Interrupt sent to" + r.getClass().getName());
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		test(new SleepBlocked());
		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Aborting with system.exit(0)");
		System.exit(0);
	}

}
