package multiThreadingDt;

public class MultiThreading05 {

	public static void main(String[] args) {
		
		CreateBrackets02 obj1=new CreateBrackets02();
		
		CreateBrackets02 obj2=new CreateBrackets02();
		
		Thread thread1=new Thread(new Runnable() {

			@Override
			public void run() {
				
				for(int i=1;i<=5;i++) {
					obj1.brackets();
				
			}
			
			}
		
		});
		
		thread1.start();
		
		
		Thread thread2=new Thread(new Runnable () {

			@Override
			public void run() {
				
				
				for(int i=1;i<=5;i++) {
					obj2.brackets();
				
			}
				
				
			}
			
			
		});
		
		thread2.start();
		
	}
	}




class CreateBrackets02{
	
	// if you use same object in the threads use synchronized
	//but if you use different object in the threads you should use synchronized static
	//synchronized static can work with different object
	
	synchronized static public void  brackets() {
	
	for(int i=1;i<=10;i++) {
	   if(i<=5) {
		  
		   System.out.print("[");
	   }else {
		  
		   System.out.print("]");
	   }
		
	}
		}
	}
	  