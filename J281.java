package java8¼¶;

public class J281 {
	 
	 public static void main(String[] args) {
	  new Thread(new TestThread(1)).start();
	  new Thread(new TestThread(2)).start();
	 }
	}
	class TestThread implements Runnable{
	 
	 private int num;
	 
	 public TestThread(int num){
	  this.num = num;
	  System.out.println("This is thread"+num);
	 }
	 public void run() {
	  for(int i=1;i<=100;++i){
	   System.out.println(i);
	  }
	 }
	 
	}