package com.chain;

import java.util.concurrent.LinkedBlockingQueue;

public class SaveProcessor extends Thread implements RequestProcessor{

	private LinkedBlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" 333");
		Request rq = null;
		try {
			System.out.println(Thread.currentThread().getName()+" 333-333 "+queue.size());
			rq = queue.take();
			System.out.println(Thread.currentThread().getName()+" 333-333-333 "+queue.size());
			System.out.println("SaveProcessor "+rq.getName()+" "+Thread.currentThread().getName()+" 444");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void processorRequest(Request request) {
		System.out.println(Thread.currentThread().getName()+" 777");
		queue.add(request);
	}

	
}
