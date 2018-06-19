package java8��;

    class BankAccount {  
    //���  
    private int balance = 500;  
    //��ѯ  
    public int getBalance(){  
        return balance;  
    }  
    //ȡ��  
    public void withdraw(int amount){  
        balance = balance - amount;  
    }  
    //���  
    public void deposit(int amount){  
        balance = balance + amount;  
    }  
    }
    class SyncMethod implements Runnable{  
        //����Thread���߳��̶߳�����Runnable(�ӿڶ���)��account����  
        private BankAccount account = new BankAccount();  
        @Override  
        public void run() {  
            for(int i = 0; i< 5; i++){           //�ܹ�ȡ��5��  
                makeWithdraw(100);          //ÿ��ȡ��100  
                if(account.getBalance() < 0){  
                    System.out.println("��"+Thread.currentThread().getName()+"   ͸֧��!");  
                }  
            }  
        }  

        private synchronized void makeWithdraw(int amount){  
            if(account.getBalance() >= amount){          //�������㹻��ȡ��  
                System.out.println("��"+Thread.currentThread().getName()+"   ׼��ȡ��!");  
                try {  
                    Thread.sleep(500);  
                } catch (InterruptedException e) {  
                    System.out.println(Thread.currentThread().getName()+"   ׼��ȡ��,�ȴ�0.5s�߳��ж�!"+e.getMessage());  
                }  
                account.withdraw(amount);  
                System.out.println("��"+Thread.currentThread().getName()+"   ���"+amount+"ȡ��!���Ϊ"+account.getBalance());}else{          //��������ʾ  
                System.out.println("��"+"������֧��"+Thread.currentThread().getName()+amount+"   ��ȡ��,���Ϊ"+account.getBalance());  
            }  
        }  
    }
    public class J282 {  
        public static void main(String[] args) {  
            //ʵ��Runnable������Thread���߳��̶߳�����Runnable(�ӿڶ���)  
//          NoSync target =new NoSync();  
            SyncMethod target = new SyncMethod();  
            //���������������������߳�ʵ��ȡ��(ͬʱ)  
            Thread lq = new Thread(target);  
            lq.setName("����ŷ");  
            Thread lqwf = new Thread(target);  
            lqwf.setName("����Ҷ");  
            //����Thread�����start()����,�����߳�,ִ��run()����(OS)  
            lq.start();  
            lqwf.start();  
        }  
    }  
