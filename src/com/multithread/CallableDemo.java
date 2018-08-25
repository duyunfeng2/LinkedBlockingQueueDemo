package com.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo implements Callable<String>{
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		CallableDemo callableDemo = new CallableDemo();
		Future<String> future = executorService.submit(callableDemo);
		
		String str = future.get().toString();
		System.out.println(str);
		
		executorService.shutdown();
		
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "callable demo";
	}
	
}
