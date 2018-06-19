package java8级;
 class BreadFactory {
    //生产面包个数计数器
    private int count = 0;
    //线程的锁
    private Object o = new Object();
    private boolean flag = false;

    public void product() {
        synchronized (o) {
            if (flag) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"生产了第" + (++count) + "个面包");
            flag = true;
            o.notify();
        }
    }

    public void consume() {
        synchronized (o) {
            if (!flag) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"消费第" + count + "个面包");
            flag = false;
            o.notify();
        }
    }
}
 class Producter extends Thread {

    private BreadFactory mBreadFactory;

    public Producter(BreadFactory mBreadFactory) {
        super();
        this.mBreadFactory = mBreadFactory;
    }
    
    @Override
    public void run() {
        //
        while (true) {
            mBreadFactory.product();
        }
    }    
}
 class Consumer extends Thread {

    private BreadFactory mBreadFactory;

    public Consumer(BreadFactory mBreadFactory) {
        super();
        this.mBreadFactory = mBreadFactory;
    }
    
    @Override
    public void run() {
        //
        while (true) {
            mBreadFactory.consume();
        }
    }
}
public class J263{
public static void main(String[] args) {
    //
    BreadFactory factory = new BreadFactory();
    Producter p1 = new Producter(factory);
    p1.start();
    Consumer c1 = new Consumer(factory);
    c1.start();
}
}