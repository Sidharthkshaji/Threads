import java.util.Scanner;
class MultThread2 extends Thread{
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
public class MyThread5 {
	public static void main(String[]args) {
		MultThread mt1=new MultThread();
		MultThread mt2=new MultThread();
		MultThread mt3=new MultThread();
		mt1.setName("Add");
		mt2.setName("Print");
		mt3.setName("Bank");
		mt1.start();
        try {
            mt1.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
		mt2.start();
        try {
            mt2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
		mt3.start();
        try {
            mt3.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
	}
}
