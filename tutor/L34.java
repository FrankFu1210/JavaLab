package tw.frank.tutor;
//Exception當例外發生時，使用try catch
public class L34 {

	public static void main(String[] args) {
		int a = 10, b = 0;
		int[] c = {1,2,3,4};
		
		System.out.println("Brad");//Brad
		try {
			System.out.println(a / b);
			System.out.println("---");
			System.out.println(c[4]);
		}catch(RuntimeException e) {
			System.out.println("ERROR");//ERROR
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("XXXXX");
//		}catch(ArithmeticException e) {
//			System.out.println("Ooop!");
		}
		System.out.println("Finish");//Finish
	}
}
//例外不一定是壞的~
//RuntimeException只在執行時發生的例外，先前編譯會過 (AE , IE(Array E)) & 其他Checked Exception要事先檢查