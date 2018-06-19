package java8��;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class J276 {
    private static Account account = new Account();   //ʵ����һ���˻�
     
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        //ʹ��ExecutorService�����̳߳�
        ExecutorService executor  = Executors.newCachedThreadPool();
         
        for(int i=0;i<100;i++)
        {
            executor.execute(new AddPennyTask());
        }
        //�ر��̳߳� ��ʹ�̳߳��л���δ��ɵ��߳� ����δ��ɵ��嵥
        executor.shutdown();
         
        //�ر�֮����Ҫ��֤δ��ɵ��̼߳������  ����̳߳���������������ˣ�isTerminated����true
        while(!executor.isTerminated())
        {}
        long end = System.currentTimeMillis();
 
        //balance��������˼
        System.out.println("�����˻����������ǣ�" + account.getBalance());
        System.out.println("���ѵ�ʱ����΢��Ϊ��λ��"+(end-start)+"΢��");
    }
     
    //����߳�ֻ������һ������
    public static class AddPennyTask implements Runnable
    {
        @Override
        public void run() {
            account.deposit(1);
        }
    }
     
    //һ���ڲ���  ���� �˻�����ش���
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
            //Ϊ���ô������ֵĸ�����
            try {
                Thread.sleep(4);   //5����
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            balance= newBalance;
            //��ʵ����balance +=amount;//����������һ�δ���������100��99����
        }
    }
}
