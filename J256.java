package java8级;

import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
  
public class J256 {  
  
    /** 
     * @param args 
     * 使用ExecutorService实现线程池，详细要求如下： 
        1） 线程池要执行的任务为每隔一秒输出一次当前线程的名字，总计输出10次。 
        2） 创建一个线程池，该线程池中只有两个空线程。 
        3） 使线程池执行5次步骤一的任务。 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
  
        ExecutorService threadPool = Executors.newFixedThreadPool(2);  
        for(int i=0; i<5; i++){  
            Handler handler = new Handler();  
            threadPool.execute(handler);  
        }  
          
    }  
  
}  
  
class Handler implements Runnable{  
    public void run(){  
        String name = Thread.currentThread().getName();  
        System.out.println("执行当前任务的线程为：" + name);  
        for(int i=0; i<10; i++){  
            System.out.println(name + ":" + i);  
            try{  
                Thread.sleep(1000);  
            }catch(InterruptedException e){  
                e.printStackTrace();  
            }  
        }  
        System.out.println(name+":任务完毕");  
    }  
}  