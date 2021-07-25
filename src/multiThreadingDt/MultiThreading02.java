package multiThreadingDt;

public class MultiThreading02 {
	
	static public int count;

	public static void main(String[] args) throws InterruptedException {
		
		
		Thread thread1=new Thread(new Runnable() {

			@Override
			public void run() {
				
				Counter.count();
				System.out.println("thread 1 running");
			}
			
			
			
		});
		thread1.start();
		
		Thread thread2=new Thread(new Runnable() {

			@Override
			public void run() {
				
				Counter.count();
				System.out.println("thread 2 running");
				
			}
			
			
			
		});
		thread2.start();
		thread2.join();
		
	System.out.println("currently count is:"+MultiThreading02.count);
		
		

	}

}

class Counter{
	
	synchronized public static void count() {
		
		for(int i=1; i<=1000; i++) {
			
			MultiThreading02.count++;
			
			
		}
		
		//System.out.println("currently count is:"+MultiThreading02.count);
 
			
	}
}