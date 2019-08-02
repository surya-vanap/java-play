package com.play.reactive;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class RxJava2Example {
	public static void main(String[] args) {
		// producer
		Observable<String> observable = Observable.just("how", "to", "do", "in", "java");

		// consumer
		Consumer<? super String> consumer = System.out::println;

		// Attaching producer to consumer
		observable.subscribe(consumer);
	}
}
