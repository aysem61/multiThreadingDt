package multiThreadingDt;
import java.util.concurrent.ArrayBlockingQueue;
public class BlockQueue {
	
	public static int count;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue(10);
		
		Product product=new Product(queue); //Thread creeated 
		
		Thread thread1=new Thread(product);// product classs dan gelen interface oldugu icin new keyword kullanilmadi 
		
		thread1.start();
		
		Consume consume=new Consume(queue);
		
		Thread thread2=new Thread(consume);
		
		thread2.start();
		
		
		
		
	}
}
class Product implements Runnable{
	
	private ArrayBlockingQueue<Integer> queue;
	
	public Product(ArrayBlockingQueue<Integer> queue) {
	
		this.queue = queue;
	}	
	
	
	
	@Override
	public void run() {
		
		while(true) {
	
		try {
			Thread.sleep(3000);
			queue.put(BlockQueue.count);
			BlockQueue.count++;
			System.out.println("added new message new count is "+BlockQueue.count);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		
	}
	
}
class Consume implements Runnable{
	
	private ArrayBlockingQueue<Integer> queue;
	
	public Consume(ArrayBlockingQueue<Integer> queue) {
	
		this.queue = queue;
	}	
	
	
	
	@Override
	public void run() {
		
		while(true) {
	
		try {
			Thread.sleep(3000);//waiting is using 
			queue.take();
			BlockQueue.count--;
			System.out.println("added new message new count is "+BlockQueue.count);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		
	}
	
}