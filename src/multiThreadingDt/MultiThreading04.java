package multiThreadingDt;

public class MultiThreading04 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CreateBrackets01 obj1=new CreateBrackets01();
		
		CreateBrackets01 obj2=new CreateBrackets01();
		
		
		long startingTime=System.currentTimeMillis();
		Thread thread1=new Thread(new Runnable() {
			@Override
			public void run() {
				
				for(int i=1;i<=5;i++) {
					
					obj1.brackets();
					
				}
				
			}
			
				
		});
		
		thread1.start();
		long endingTime=System.currentTimeMillis();
		System.out.println("duration for first thread" + (endingTime- startingTime));
		
		
		long startingTime2=System.currentTimeMillis();
		Thread thread2=new Thread(new Runnable() {
			@Override
			public void run() {
				
				for(int i=1;i<=5;i++) {
				obj1.brackets();
				
			}}
			
		
		});
		thread2.start();
		long endingTime2=System.currentTimeMillis();
		System.out.println("duration for second  thread" + (endingTime2- startingTime2));
	}
}
class CreateBrackets01{
	//if dont need to synchronized during to all method use synchronized(this) {}
	//synchronized this faster than synchronized
	//synchronized this just break thread for part of method so our application ll be fast
	
	
	 synchronized public void brackets() {
		synchronized(this) {
	for(int i=1;i<=10;i++) {
	   if(i<=5) {
		  
		   System.out.print("[");
	   }else {
		  
		   System.out.print("]");
	   }
		
	}
	
	System.out.println();
	 }
	
	for(int i=1;i<=10;i++) {
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		
		}
	 }
