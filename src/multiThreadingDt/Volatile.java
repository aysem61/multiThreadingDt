package multiThreadingDt;

public class Volatile {
	
	
	volatile public static int flag=0;

	public static void main(String[] args) {
		
		Thread thread1=new Thread(
				
				new Runnable() {

					@Override
					public void run() {
						while(true) {
						if(flag==0) {
							
							System.out.println("thread1 running");
						}else {
							break;
							
						}
						}
						
					}
			
	});
		
		thread1.start();
		
		Thread thread2=new Thread(new Runnable() {

			@Override
			public void run() {
				flag=1;
				
				System.out.println("flag is updated now thread 2 running");
				
			}
			
			
		});
		
		thread2.start();
		

	}
}