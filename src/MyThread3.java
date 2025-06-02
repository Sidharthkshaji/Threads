import java.util.Scanner;
class Add extends Thread{
	Scanner sc=new Scanner(System.in);
	public void run() {
		System.out.println("Addition operation started");
		System.out.println("Enter value of a:");
		int a=sc.nextInt();
		System.out.println("Enter value of b:");
		int b=sc.nextInt();
		int c=a+b;
		System.out.println("Result:"+c);
		System.out.println("Addition operation completed");
	}
}
class Print extends Thread{
	public void run() {
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
}
class Bank extends Thread{
	public void run() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Bank operations have started");
		System.out.println("Enter the account number:");
		int acc=sc.nextInt();
		System.out.println("Enter pin number:");
		int pin=sc.nextInt();
		System.out.println("Banking operations completed");
	}
}
public class MyThread3 {
	public static void main(String[]args) {
		Add a=new Add();
		Print p=new Print();
		Bank b=new Bank();
		a.start();b.start();p.start();
	}
}
