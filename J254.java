package java8��;

public class J254 {
	public static Thread[] getThreads() {
	ThreadGroup group = Thread.currentThread().getThreadGroup();
	Thread[] threads = new Thread[group.activeCount()];
	group.enumerate(threads);
	System.out.println("�߳�ID\t" + "�߳�����\t" + "�߳����ȼ�");
	for (Thread thread : threads) {
	System.out.println(thread.getId() + "\t" + thread.getName() + "\t"
	+ thread.getPriority());
	}
	return threads;
	}
	public static void main(String[] args) {
		getThreads();

		}
}
