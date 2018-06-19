package java8级;

import java.text.SimpleDateFormat;
import java.util.Date;

public class J259{
    public static void main(String[] args) {
        
       
        Thread t1 =new Thread(){
            @Override
           public void run() {
                while(true){
                        SimpleDateFormat sdf =new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                       Date now =new Date();
                       System.out.println(sdf.format(now));
                       try {
                           Thread.sleep(3000);
                       } catch (InterruptedException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                       }
                   }
           }
        };
        t1.setDaemon(true);
        t1.start();
        try {
           //如果不阻塞main 只剩下守护进程的时候 gc直接调出 结束进程了
            Thread.sleep(10000000);
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
        
   }
}