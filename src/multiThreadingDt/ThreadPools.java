package multiThreadingDt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {

	public static void main(String[] args) {
		//with executorService you can run you thread group by group
		//so you computer can handle that process
		//otherwise maybe much thread can run at the same time so maybe
		
		ExecutorService executorService=Executors.newFixedThreadPool(3);
		
		ThreadCreater thread1=new ThreadCreater("thread1");
		ThreadCreater thread2=new ThreadCreater("thread2");
		ThreadCreater thread3=new ThreadCreater("thread3");
		ThreadCreater thread4=new ThreadCreater("thread4");
		ThreadCreater thread5=new ThreadCreater("thread5");
		ThreadCreater thread6=new ThreadCreater("thread6");
		ThreadCreater thread7=new ThreadCreater("thread7");
		ThreadCreater thread8=new ThreadCreater("thread8");
		ThreadCreater thread9=new ThreadCreater("thread9");
		ThreadCreater thread10=new ThreadCreater("thread10");
	
	thread1.start();
	thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		thread9.start();
		thread10.start();
	
		executorService.execute(thread1);
		executorService.execute(thread2);
		
		executorService.execute(thread3);
		
		executorService.execute(thread4);
		executorService.execute(thread5);
		executorService.execute(thread6);
		executorService.execute(thread7);
		executorService.execute(thread8);
		executorService.execute(thread9);
		executorService.execute(thread10);
	
	
	}

}

class ThreadCreater extends Thread{
	
	private String threadName;

	@Override
	public void run() {
		System.out.println("thread start" + threadName);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("thread stoped" +threadName);
	}
	
public ThreadCreater(String threadName) {
		
		this.threadName = threadName;
	}
	
	
}
