package java8级;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class J276 {
    private static Account account = new Account();   //实例化一个账户
     
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        //使用ExecutorService创建线程池
        ExecutorService executor  = Executors.newCachedThreadPool();
         
        for(int i=0;i<100;i++)
        {
            executor.execute(new AddPennyTask());
        }
        //关闭线程池 即使线程池中还有未完成的线程 返回未完成的清单
        executor.shutdown();
         
        //关闭之后还是要保证未完成的线程继续完成  如果线程池中所有任务都完成了，isTerminated返回true
        while(!executor.isTerminated())
        {}
        long end = System.currentTimeMillis();
 
        //balance有余额的意思
        System.out.println("现在账户里面的余额是：" + account.getBalance());
        System.out.println("花费的时间以微秒为单位："+(end-start)+"微秒");
    }
     
    //这个线程只调用了一个方法
    public static class AddPennyTask implements Runnable
    {
        @Override
        public void run() {
            account.deposit(1);
        }
    }
     
    //一个内部类  用于 账户的相关处理
    public static class Account
    {
        private int balance =0;
        public int getBalance()
        {
            return balance;
        }
        public  void deposit(int amount)
        {
            int newBalance = balance + amount;
            //为了让错误体现的更明显
            try {
                Thread.sleep(4);   //5毫秒
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            balance= newBalance;
            //其实就是balance +=amount;//不过换成这一段代码结果就在100和99左右
        }
    }
}
