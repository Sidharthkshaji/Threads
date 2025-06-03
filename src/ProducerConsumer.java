class Queue{
	boolean is_value_present=false;
	private int data;
	synchronized public void put(int i) {
		try {
			if(is_value_present==true) {
				wait();
			}else {
				data=i;
				System.out.println("Data Added,The value of Data is:"+data);
				notify();
				is_value_present=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	synchronized public void get(int i) {
		try {
			if(is_value_present==false) {
				wait();
			}else {
				System.out.println("Data Consumed,The value of Data is:"+data);
				notify();
				is_value_present=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
class Producer extends Thread{
	Queue a;
	
	Producer(Queue q){
		a=q;
	}
	@Override
	public void run() {
		int i=1;
		while(true) {
			a.put(i++);
			 try {
	                Thread.sleep(100);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
		}
	}
}
class Consumer extends Thread{
	Queue b;
	
	Consumer(Queue q){
		b=q;
	}
	@Override
	public void run() {
		int i=1;
		while(true) {
			b.get(i++);
			 try {
	                Thread.sleep(150);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
		}
	}
}
public class ProducerConsumer {
	public static void main(String[]args) {
		Queue q=new Queue();
		Producer p=new Producer(q);
		Consumer c=new Consumer(q);
		p.start();c.start();
		
	}
}
