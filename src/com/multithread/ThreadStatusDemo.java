package com.multithread;

import java.util.concurrent.TimeUnit;

public class ThreadStatusDemo {
	public static void main(String[] args) {
		new Thread(()->{
			while(true){
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "timewaiting").start();
		
		new Thread(){
			public void run() {
				while(true){
					try {
						TimeUnit.SECONDS.sleep(2);
						System.out.println(Thread.currentThread().getName());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();
		
	}

}
