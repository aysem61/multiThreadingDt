package multiThreadingDt;

public class MultiThreading03 {

	public static void main(String[] args) {

		CreateBrackets obj1 = new CreateBrackets();
		CreateBrackets obj2 = new CreateBrackets();

		// obj1.brackets();

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 1; i <= 10; i++) {

					obj1.brackets();
					// System.out.println("thread 1 running" + Thread.currentThread().getName());
				}

			}

		});
		thread1.setName("thread1");
		thread1.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				for (int i = 1; i <= 10; i++) {

					obj2.brackets();

					// System.out.println("thread 2 running" + Thread.currentThread().getName());

				}
			}
		});
		thread2.setName("thread2");
		thread2.start();

	}

}

class CreateBrackets {

	// when you want to put order your thread you can use synchronized
	// but if you use different object in the threads synchronized can not work
	// when you use synchronized you break the thread so your application will be slower
	// we can use join() method for put thread the orders
	synchronized public void brackets() {

		for (int i = 1; i <= 10; i++) {

			if (i <= 5) {

				System.out.print("[");
			} else {

				System.out.print("]");

			}
		}

		System.out.println();
	}

}