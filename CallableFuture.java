package com.bean;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture {

	public static void main(String[] args) {
	ExecutorService service=Executors.newFixedThreadPool(10);
	Future<Integer> future=service.submit(new Task());
	try {
	Integer result= 	future.get();
	System.out.println("Result from the task is:"+ result);
	} catch (InterruptedException e) {
		e.printStackTrace();
	} catch (ExecutionException e) {
		e.printStackTrace();
	}
	}
}

class Task implements Callable<Integer>{
	@Override
	public Integer call() {
		return new Random().nextInt();	}
}
