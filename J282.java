package java8级;

    class BankAccount {  
    //余额  
    private int balance = 500;  
    //查询  
    public int getBalance(){  
        return balance;  
    }  
    //取款  
    public void withdraw(int amount){  
        balance = balance - amount;  
    }  
    //存款  
    public void deposit(int amount){  
        balance = balance + amount;  
    }  
    }
    class SyncMethod implements Runnable{  
        //所有Thread多线程线程都共享Runnable(接口对象)和account对象  
        private BankAccount account = new BankAccount();  
        @Override  
        public void run() {  
            for(int i = 0; i< 5; i++){           //总共取款5次  
                makeWithdraw(100);          //每次取款100  
                if(account.getBalance() < 0){  
                    System.out.println("☆"+Thread.currentThread().getName()+"   透支了!");  
                }  
            }  
        }  

        private synchronized void makeWithdraw(int amount){  
            if(account.getBalance() >= amount){          //如果余额足够则取款  
                System.out.println("☆"+Thread.currentThread().getName()+"   准备取款!");  
                try {  
                    Thread.sleep(500);  
                } catch (InterruptedException e) {  
                    System.out.println(Thread.currentThread().getName()+"   准备取款,等待0.5s线程中断!"+e.getMessage());  
                }  
                account.withdraw(amount);  
                System.out.println("☆"+Thread.currentThread().getName()+"   完成"+amount+"取款!余额为"+account.getBalance());}else{          //余额不足则提示  
                System.out.println("☆"+"余额不足以支付"+Thread.currentThread().getName()+amount+"   的取款,余额为"+account.getBalance());  
            }  
        }  
    }
    public class J282 {  
        public static void main(String[] args) {  
            //实现Runnable：所有Thread多线程线程都共享Runnable(接口对象)  
//          NoSync target =new NoSync();  
            SyncMethod target = new SyncMethod();  
            //创建李琦和他老婆两个线程实现取款(同时)  
            Thread lq = new Thread(target);  
            lq.setName("罗密欧");  
            Thread lqwf = new Thread(target);  
            lqwf.setName("朱丽叶");  
            //调用Thread对象的start()方法,启动线程,执行run()方法(OS)  
            lq.start();  
            lqwf.start();  
        }  
    }  
