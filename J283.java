package java8��;

public class J283 {  
	  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Object obj = new Object();  
        Shuzi s = new Shuzi(obj);  
        Zimu z = new Zimu(obj);  
        Thread th1 = new Thread(s);  
        Thread th2 = new Thread(z);  
        th1.start();//���ֵ��߳������У�������ִ��  
        th2.start();  
        /*th2.start(); 
         * th1.start();��ĸ���߳������У�����ִ����ĸ 
         */  
    }  
}  
  
class Shuzi implements Runnable{  
    private Object obj;//����һ���������  
    public Shuzi(Object obj){  
        this.obj = obj; //ͨ�����������������Դ-->���󴫽���  
    }  
      
    @Override  
    public void run() {  
        synchronized(obj){//��������Դ����  
            for(int i = 1;i < 53;i++ ){  
                System.out.println(i);  
                if(i % 2 == 0){  
                    obj.notifyAll();//���������߳�  
                  
                    try {  
                        obj.wait();//�ȴ����ͷ���  
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
                    obj.notifyAll();//���������߳�  
                try {  
                    obj.wait();//�ͷ����ȴ�  
                } catch (InterruptedException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
            }  
        }  
          
    }  
      
} 