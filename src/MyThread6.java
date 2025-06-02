import java.util.Scanner;
class Add2 implements Runnable{
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
class Print2 extends Thread{
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
class Bank2 extends Thread{
	public void run() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Bank operations have started");
		System.out.println("Enter the account number:");
		int acc=sc.nextInt();
		System.out.println("Enter pin number:");
		int pin=sc.nextInt();
		System.out.println("Banking operations completed");
		sc.close();
	}
}
public class MyThread6 {
	public static void main(String[]args) {
		Add2 test1=new Add2();
		Print2 test2=new Print2();
		Bank2 test3=new Bank2();
		Thread t1=new Thread(test1);
		Thread t2=new Thread(test2);
		Thread t3=new Thread(test3);
		t1.setName("Add");
		t2.setName("Print");
		t3.setName("Bank");
		t1.start();
		try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
		t2.start();
		try {
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
		t3.start();
		try {
            t3.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
	}
}
