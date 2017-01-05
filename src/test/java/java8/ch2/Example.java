package java8.ch2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Example {

	public static void main(String[] args) {
		lambdaExpression();
		typeInference();
	}
	
	private static void lambdaExpression(){
		new Thread(
				() -> System.out.println(Thread.currentThread()+" Hello World")
		).start();
		
		Runnable multiStatement = () -> {
			System.out.print(Thread.currentThread());
			System.out.print(" Hello");
			System.out.println(" World");
		};
		new Thread(multiStatement).start();
		
		BinaryOperator<Integer> add = (x, y) -> x+y;
		new Thread(
				() -> System.out.println(add+" result is "+add.apply(1, 2))
		).start();
	}
	
	private static void typeInference(){
		Map<String, Integer> map = new HashMap<>();
		map.put("one", 1);
		map.put("two", 2);
		typeInferenceMethod(map);
	}
	
	private static void typeInferenceMethod(Map<String, Integer> map){
		System.out.println(map);
	}
	
	private static void predicate(){
		Predicate<Integer> atLeast5 = x -> x > 5;
		BinaryOperator<Long> addLong = (x, y) -> x + y;
	}
	
}
