package java8级;

public class J284 {  
	  
    /** 
     * @param args 
     */  
  
      
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
      
             PrintTask printTask=new PrintTask();  
        Thread thread1=new Thread(printTask,"a");  
        Thread thread2=new Thread(printTask,"b");  
        Thread thread3=new Thread(printTask,"c");  
        thread1.start();  
        thread2.start();  
        thread3.start();  
      
          
    }  
      
      
}  
  
class PrintTask implements Runnable{  
    //用来标识当前应该是a还是b或者c  
    private int count=0;  
      
//    private ReentrantLock lock=new ReentrantLock();  
    @Override  
    public void run() {  
        // TODO Auto-generated method stub  
        String nameString=Thread.currentThread().getName();  
//      lock.lock();  
        //this的含义是什么  
        while (count<30) {  
            synchronized (this) {  
                if (count%3==0) {  
                    //a  
                    if (nameString.equalsIgnoreCase("a")) {  
                        System.out.print("a");  
                        count++;  
                        this.notifyAll();  
                    }  
                    else {  
                        try {  
                            this.wait();  
                        } catch (InterruptedException e) {  
                            // TODO Auto-generated catch block  
                            e.printStackTrace();  
                        }  
                    }  
                }  
                 if (count%3==1) {  
                    //b  
                    if (nameString.equalsIgnoreCase("b")) {  
                        System.out.print("b");  
                        count++;  
                        this.notifyAll();  
                    }  
                    else {  
                        try {  
                            this.wait();  
                        } catch (InterruptedException e) {  
                            // TODO Auto-generated catch block  
                            e.printStackTrace();  
                        }  
                    }  
                }  
                 if (count%3==2) {  
                    if (nameString.equalsIgnoreCase("c")) {  
                        System.out.print("c");  
                        count++;  
                        this.notifyAll();  
                    }  
                    else {  
                        try {  
                            this.wait();  
                        } catch (InterruptedException e) {  
                            // TODO Auto-generated catch block  
                            e.printStackTrace();  
                        }  
                    }  
                }  
            }  
        }  
      
  
//      lock.unlock();  
          
          
    }  
      
}  