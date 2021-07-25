package multiThreadingDt;
import java.util.concurrent.CountDownLatch;
public class CountDownLatch01 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// if you want to run all code after threads you can use latch
		//if you use latch evrything run after threads
		//also you can arange how many threads run before athers code type in the
		
		//CountDownLatch latch=new CountDownLatch(6); six represent for how many threads must work
		//before others code
		
		
		CountDownLatch latch=new CountDownLatch(6);
		
		ThreadCreator01 thread1=new ThreadCreator01(latch);
		ThreadCreator01 thread2=new ThreadCreator01(latch);
		ThreadCreator01 thread3=new ThreadCreator01(latch);
		ThreadCreator01 thread4=new ThreadCreator01(latch);
		ThreadCreator01 thread5=new ThreadCreator01(latch);
		ThreadCreator01 thread6=new ThreadCreator01(latch);
		ThreadCreator01 thread7=new ThreadCreator01(latch);
		
		thread1.start();
		thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("threads finish now athers running");
		
	}
}
class ThreadCreator01 extends Thread{
	
	private CountDownLatch latch;
	public ThreadCreator01(CountDownLatch latch) {
	
		this.latch = latch;
	}
	@Override
	public void run() {
		
		
		System.out.println("thread is startinggg "+Thread.currentThread().getName());
		System.out.println("thread is stop "+Thread.currentThread().getName());
		System.out.println("============");
		
		latch.countDown();
		
	}
	
	
}