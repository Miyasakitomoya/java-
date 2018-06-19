package java8¼¶;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class J257 {  
    public static void main(String[] args) {  
        BlockingQueue<Integer> queue =new ArrayBlockingQueue<Integer>(10);  
          
        boolean flag;  
        for(int i=1;i<=20;i++){  
            try {  
                flag = queue.offer(i,1,TimeUnit.SECONDS);  
                System.out.println(i+":"+flag);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        for(int i=0;i<10;i++){  
            queue.offer(i);  
        }  
          
        for(int i=1;i<=20;i++){  
            Integer in;  
            try {  
                in = queue.poll(1,TimeUnit.SECONDS);  
                System.out.println(in);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  
