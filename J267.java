package java8��;


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
        sleep(5000); // ���߳��ӳ�5��  
        thread.exit = true;  // ��ֹ�߳�thread  
        thread.join();  
        System.out.println("�߳��˳�!");  
    }  
}  
