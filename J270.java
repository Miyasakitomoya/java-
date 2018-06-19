package java8级;

class mThread extends Thread {

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			Thread t = Thread.currentThread();
			System.out.println("当前线程名字：" + t.getName() + " 当前线程的优先级别为："+ t.getPriority() + " ID:" + t.getId());
//			System.out.println("当前线程名字：" + this.getName() + " 当前线程的优先级别为：" + this.getPriority() + " ID:"+ this.getId());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class J270 {
	public static void main(String[] args) {
		mThread mt = new mThread();
		new Thread(mt, "Name1").start();
		new Thread(mt, "Name2").start();
		new Thread(mt).start();
		System.out.println(Thread.currentThread().getName()); // main主方法
	}
}
