package java8��;

class mThread extends Thread {

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			Thread t = Thread.currentThread();
			System.out.println("��ǰ�߳����֣�" + t.getName() + " ��ǰ�̵߳����ȼ���Ϊ��"+ t.getPriority() + " ID:" + t.getId());
//			System.out.println("��ǰ�߳����֣�" + this.getName() + " ��ǰ�̵߳����ȼ���Ϊ��" + this.getPriority() + " ID:"+ this.getId());
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
		System.out.println(Thread.currentThread().getName()); // main������
	}
}
