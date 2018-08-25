package com.chain;

public class Demo {
	
	private PrintProcessor printProcessor = null;
	
	public Demo(){
		System.out.println(Thread.currentThread().getName()+" 222");
		SaveProcessor saveProcessor = new SaveProcessor();
		saveProcessor.start();
		printProcessor = new PrintProcessor(saveProcessor);
		printProcessor.start();
		System.out.println(Thread.currentThread().getName()+" 222-222");
	}
	
	public void doTest(){
		System.out.println(Thread.currentThread().getName()+" 888");
		Request request = new Request();
		request.setName("zhangsan");
		printProcessor.processorRequest(request);
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" 111");
		Demo demo = new Demo();
		demo.doTest();
	}
}
