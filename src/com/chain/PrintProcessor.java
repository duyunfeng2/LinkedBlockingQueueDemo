package com.chain;

import java.util.concurrent.LinkedBlockingQueue;

public class PrintProcessor extends Thread implements RequestProcessor{
	
	private LinkedBlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();
	
	private RequestProcessor nextProcessor ;
	
	public PrintProcessor(RequestProcessor nextProcessor) {
		super();
		this.nextProcessor = nextProcessor;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" 555");
		Request rq = null;
		try {
			System.out.println(Thread.currentThread().getName()+" 555 "+queue.size());
			rq = queue.take();
			System.out.println(Thread.currentThread().getName()+" 555-555 "+queue.size());
			System.out.println("PrintProcessor "+rq.getName()+" "+Thread.currentThread().getName()+" 666");
			nextProcessor.processorRequest(rq);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void processorRequest(Request request) {
		System.out.println(Thread.currentThread().getName()+" 999");
		queue.add(request);
	}

}
