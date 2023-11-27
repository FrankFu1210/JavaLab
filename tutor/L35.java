package tw.frank.tutor;
//Checked Exception, throw, try catch, return + finally, finish (類似MySQL commit/rollback)
public class L35 {

	public static void main(String[] args) {
		Bird bird = new Bird();
		try {
			bird.setLeg(5);
		}catch(Exception e) {
			System.out.println("ERROR");
		}
		System.out.println("----");
		test1(bird);
	}
	
	static void test1(Bird bird){
		try {
			test2(bird);
			System.out.println("test1():OK");
		}catch(Exception e) {
			System.out.println("test1():XX");
			return;//return + finally
		}finally {
			System.out.println("finally");
		}
		System.out.println("test1():finish");
	}
	static void test2(Bird bird) throws Exception {
		bird.setLeg(2);
	}

}

class Bird {
	int leg;
	void setLeg(int num) throws Exception {
		if (num >= 0 && num <= 2) {
			leg = num;
		}else {
			throw new Exception();
		}
	}
}
//set get過濾參數，調整屬性
//包裝外宣告，{}內實作，開發者把彈性交給呼叫的人處理，所以使用者要先用try catch面對這件事