import java.util.Scanner;
class MultThread1 implements Runnable{
	Scanner sc=new Scanner (System.in);
	public void add() {
		System.out.println("Addition operation started");
		System.out.println("Enter value of a:");
		int a=sc.nextInt();
		System.out.println("Enter value of b:");
		int b=sc.nextInt();
		int c=a+b;
		System.out.println("Result:"+c);
		System.out.println("Addition operation completed");
	}
	public void print() {
		try {
			System.out.println("Printing operation started");
			for(int i=0;i<5;i++) {
				System.out.println("Printing....");
				Thread.sleep(2000);
			}
		}catch(InterruptedException ie) {
			System.out.println("Operation have been interrupted");
		}
		System.out.println("Printing operation completed");
	}
	public void bank() {
		System.out.println("Bank operations have started");
		System.out.println("Enter the account number:");
		int acc=sc.nextInt();
		System.out.println("Enter pin number:");
		int pin=sc.nextInt();
		System.out.println("Banking operations completed");
	}
	public void run() {
		if(Thread.currentThread().getName().equals("Add")) add();
		else if(Thread.currentThread().getName().equals("Print")) print();
		else bank();
	}
}
public class MyThread2 {
	public static void main(String[]args) {
		MultThread test1=new MultThread();
		MultThread test2=new MultThread();
		MultThread test3=new MultThread();
		Thread t1=new Thread(test1);
		Thread t2=new Thread(test2);
		Thread t3=new Thread(test3);
		t1.setName("Add");
		t2.setName("Print");
		t3.setName("Bank");
		t1.start();t2.start();t3.start();
	}
}
