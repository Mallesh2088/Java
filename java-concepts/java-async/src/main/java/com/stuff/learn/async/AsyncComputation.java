package com.stuff.learn.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncComputation {

	public static void main(String[] args) {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");
		CompletableFuture<String> future4 = null;
		try {
			future4 = calculateAsync();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3,future4);
		String result = null;
		try {
			combinedFuture.get();
			System.out.println(future1.isDone());
			System.out.println(future2.isDone());
			System.out.println(future3.isDone());
			System.out.println(future4.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static CompletableFuture<String> calculateAsync() throws InterruptedException {
	    CompletableFuture<String> completableFuture 
	      = new CompletableFuture<>();
	 
	    Executors.newCachedThreadPool().submit(() -> {
	        Thread.sleep(1000);
	        completableFuture.complete("Hello");
	        return null;
	    });
	 
	    return completableFuture;
	}
}
