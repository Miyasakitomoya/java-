package java8级;


public class J267 extends Thread  
{  
    public volatile boolean exit = false;  
  
    public void run()  
    {  
        while (!exit);  
    }  
    public static void main(String[] args) throws Exception  
    {  
    	J267 thread = new J267();  
        thread.start();  
        sleep(5000); // 主线程延迟5秒  
        thread.exit = true;  // 终止线程thread  
        thread.join();  
        System.out.println("线程退出!");  
    }  
}  
