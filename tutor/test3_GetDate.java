package tw.frank.tutor;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class test3_GetDate {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		LocalDate today = LocalDate.now();
		System.out.println(today);
		System.out.println("x =");
		int x = scanner.nextInt();
//		LocalDate x = today.plusDays(x);
		System.out.println(today + "x");
	}
}
