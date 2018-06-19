package java8¼¶;

 class SetnameDemo extends Thread {
	 public void run() {
		 for(int i=0;i<100;i++) {
			 System.out.println(getName()+i);
		 }
	 }
}
 public class J271{
	 public static void main(String[] args) {
		 SetnameDemo sd = new SetnameDemo();
		 SetnameDemo sd1 = new SetnameDemo();
		 sd.setName("haha:");
		 sd1.setName("hehe:");
		 sd.start();
		 sd1.start();
		 System.out.println(Thread.currentThread().getName());
	 }
 }
