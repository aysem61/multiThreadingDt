package multiThreadingDt;

public class Interrupt {

public static double balance=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		WaitNotitfy obj1=new WaitNotitfy();
		Thread thread1=new Thread(new Runnable() {
			@Override
			public void run() {
				
				obj1.withdraw(10000);
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
			
			
		});
		thread1.start();
		
		
		Thread thread2=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				obj1.deposit(50000);
				thread1.interrupt();
			}
			
			
		});
		thread2.start();
			
	}
	public void withdraw(double amount) {
		
		synchronized(this) {
		if(balance<=0|| balance<amount){
			
			try {
				System.out.println("user waiting for the update the balance");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
			 balance=balance-amount;
             System.out.println("current balance is "+balance);
			
		}}	
	}
	
	public void deposit(double amount){
		balance=balance+amount;
		System.out.println("new balance is "+balance);
		
	}
		
}