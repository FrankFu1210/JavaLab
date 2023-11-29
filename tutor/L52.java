package tw.frank.tutor;

import java.util.Timer;
import java.util.TimerTask;
//Timer TimerTask run()，MyTask內部類別拉到外部extends，StopTask用建構式傳遞進去，到上方timer為區域變數，一次性初始化
public class L52 {
	//1129 093139
	public static void main(String[] args) {
		Timer timer = new Timer();
		
		//MyTask 內部類別 (汽車工廠中的輪胎工廠，汽車工廠實體要先存在)
		MyTask task = new MyTask();//沒有L52的物件實體
		timer.schedule(task, 3*1000, 1000);
		
		StopTask stop = new StopTask(timer);//要加入argument timer
		timer.schedule(stop, 7000);
		
		System.out.println("main"); //印出main過3秒出現0，時間沒關掉在背景執行

	}
}
	
//	void m1 () {} //物件m1方法 int a屬性 MyTask內部工廠

	class MyTask extends TimerTask{//2.拉到外面來 extends同等級ok
//	static class MyTask extends TimerTask{ //Static與物件無關  1. Static存取Static與物件無關
		private int i;
		@Override
		public void run() {
			System.out.println(i++);//時間到要做的事i++，隔3秒鐘要做
			//	隔3秒印一次(0)而已，任務結束但時間還沒有停
			//	結束不了，按紅燈或取消結束
	}
}

	//來一個類別StopTask停止任務，但上方timer為區域變數如何認識?
	//用建構式傳遞進去，一次性初始化，上方要創建一個new StopTask，擁有但非創建，再度子操控
	class StopTask extends TimerTask{
		private Timer timer;
		StopTask(Timer timer){this.timer = timer;}
		@Override
		public void run() {
			timer.cancel();
			timer.purge();
			timer = null;
		}
	}

//1.	Timer沒結束
//2.	任務週期沒結束點

//HW: 用timer寫類比時鐘(用math sin cos算)

