package tw.frank.tutor;

public class L04 {

	public static void main(String[] args) {
		// 產生0~100間的亂數
		double temp = Math.random();
		System.out.println(temp);
		int score = (int)(temp * 101); //強制轉型，取整數，但是會有些誤差，101代表個數
		System.out.println(score);
		
		//大樂透產生1~49間的亂數
		double temp2 = Math.random();
		System.out.println(temp2);
		int score2 = (int)(temp2 * 49) + 1; // 1~49，因為0位移
		System.out.println(score2);

		// if (boolean只有布林值，型別要求強烈) {} (JS 0跟非0)
		double temp3 = Math.random();
		System.out.println(temp3);
		int score3 = (int)(temp3 * 101); 
		if (score3 >= 90) {
			System.out.printf("%d : %s", score3, "A");
		} else {
			if (score3 >= 80) {
				System.out.printf("%d : %s", score3, "B");
			} else {
				if (score3 >= 70) {
					System.out.printf("%d : %s", score3, "C");
				} else {
					if (score3 >= 60) {
						System.out.printf("%d : %s", score3, "D");
					} else {
						System.out.printf("Score :%d\n", score3);
						System.out.println("DOWN");
						System.out.println("E");

//144618
	double temp4 = Math.random();
	System.out.println(temp4);
	String grade = "";
	boolean isPass = false;
	int score4 = (int)(temp4 * 101); 
	if (score4 >= 90) {
		grade = "A"; isPass = true;
	} else if (score4 >= 80) {
		grade = "B"; isPass = true;
	} else if (score4 >= 70) {
		grade = "C"; isPass = true;
	} else if (score4 >= 60) {
		grade = "D"; isPass = true;
	} else {
		grade = "E"; isPass = false;
	}
	
System.out.printf("%d : %s : %s", score4, grade, isPass? "PASS":"DOWN!");

				}					
			}
		}
	}
}}




