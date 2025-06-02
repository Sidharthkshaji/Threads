class Sample extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Child Thread");
		}
	}
}
public class MyThread {
	public static void main(String[] args) {
		Sample s=new Sample();
		s.start();
		for(int i=0;i<5;i++) {
			System.out.println("Parent Thread");
		}
	}
}