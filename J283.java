package java8级;

public class J283 {  
	  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Object obj = new Object();  
        Shuzi s = new Shuzi(obj);  
        Zimu z = new Zimu(obj);  
        Thread th1 = new Thread(s);  
        Thread th2 = new Thread(z);  
        th1.start();//数字的线程先运行，数字先执行  
        th2.start();  
        /*th2.start(); 
         * th1.start();字母的线程先运行，则先执行字母 
         */  
    }  
}  
  
class Shuzi implements Runnable{  
    private Object obj;//声明一个类的引用  
    public Shuzi(Object obj){  
        this.obj = obj; //通过构造器将共享的资源-->对象传进来  
    }  
      
    @Override  
    public void run() {  
        synchronized(obj){//给共享资源上锁  
            for(int i = 1;i < 53;i++ ){  
                System.out.println(i);  
                if(i % 2 == 0){  
                    obj.notifyAll();//唤醒其他线程  
                  
                    try {  
                        obj.wait();//等待并释放锁  
                    } catch (InterruptedException e) {  
                        // TODO Auto-generated catch block  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }  
          
    }  
      
}  
  
class Zimu implements Runnable{  
    private Object obj;  
    public Zimu(Object obj){  
        this.obj = obj;   
    }  
      
    @Override  
    public void run() {  
        synchronized(obj){  
            for(int i = 0;i < 26;i++ ){  
                System.out.println((char)(i+'A'));  
                    obj.notifyAll();//唤醒其他线程  
                try {  
                    obj.wait();//释放锁等待  
                } catch (InterruptedException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
            }  
        }  
          
    }  
      
} 