package java8.ch2;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.function.Predicate;

import javax.swing.text.DateFormatter;

public class Exercise {

	/**
	 * 
	 * 				------------
	 *      T ----> | Function |  ----> R
	 * 				------------
	 * 
	 */
	
	public static void main(String[] args) {
		test();
	}
	
	private static void test(){
		Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
		ThreadLocal<SimpleDateFormat> tl4sdf 
			= ThreadLocal.withInitial(() -> new SimpleDateFormat("dd-MMM-yyyy"));
		System.out.println(tl4sdf.get().format(cal.getTime()));
		
		check(x -> x > 5);
	}
	
	private interface IntPred{
		boolean test(Integer value);
	}
	
//	private static boolean check(Predicate<Integer> predicate){
//		return false;
//	}
	
	private static boolean check(IntPred predicate){
		return false;
	}
	
}
