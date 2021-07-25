package multiThreadingDt;

public class MultiThreding01 {

	public static void main(String[] args) {

		long time1 = System.currentTimeMillis();
		
		WithoutThreadCounter obj1 = new WithoutThreadCounter(1);
		obj1.counMe();
		System.out.println("=====================");
		WithoutThreadCounter obj2 = new WithoutThreadCounter(2);
		obj2.counMe();
		long time2 = System.currentTimeMillis();

		System.out.println("withoutthread take time:" + (time2 - time1));

		System.out.println("=======================");

		long time3 = System.currentTimeMillis();
		WithtThreadCounter obj3 = new WithtThreadCounter(3);

		obj3.start();

		WithtThreadCounter obj4 = new WithtThreadCounter(4);

		obj4.start();
		try {
			obj4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		long time4 = System.currentTimeMillis();

		System.out.println("duration for threads :" + (time4 - time3));

	}
}

class WithoutThreadCounter {

	private int threadNum;

	public WithoutThreadCounter(int threadNum) {

		this.threadNum = threadNum;
	}

	public void counMe() {

		for (int i = 1; i <= 9; i++) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("i:" + i + " thread number is " + threadNum);

		}

	}

}

class WithtThreadCounter extends Thread {

	private int threadNum;

	public WithtThreadCounter(int threadNum) {

		this.threadNum = threadNum;
	}

	public void counMe() {

		for (int i = 1; i <= 9; i++) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("i:" + i + " thread number is " + threadNum);

		}

	}

	@Override
	public void run() {
		counMe();
	}
}