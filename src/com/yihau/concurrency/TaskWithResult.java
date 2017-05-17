package com.yihau.concurrency;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * Callable 具有返回值的任务
 * @author UMC-yihau
 *
 */
public class TaskWithResult implements Callable<String>{
	private int id;
	public TaskWithResult(int id){
		this.id = id ;
	}
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for(int i = 0; i < 10; i++){
			results.add(exec.submit(new TaskWithResult(i)));
		}
		for(Future<String> fs : results){
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				exec.shutdown();
			}
		}

	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
	
		return "result of TaskWithResult " + id;
	}

}
