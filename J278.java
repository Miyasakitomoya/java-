package java8级;
class Test {  
	  
private int size=0;  
  
    public synchronized void doSome(){  
size++;  
    }  
      
public synchronized void doTest(Test test){  
try {  
Thread.sleep(1000);//睡眠1秒  效果更明显  
} catch (InterruptedException e) {  
e.printStackTrace();  
}  
        test.doSome();   //另外一个对象调用synchronized 函数  需要取得该对象的对象锁定  
  
  
  
}  
  
  
  
}  
public class J278 {  
    public static void main(String[] args) {  
  
        final Test t1=new Test();  
        final Test t2=new Test();  
          
        Thread th1=new Thread(new Runnable() {  
              
            @Override  
            public void run() {  
                // TODO Auto-generated method stub  
                t1.doTest(t2);  
            }  
        });  
          
        Thread th2=new Thread(new Runnable() {  
              
            @Override  
            public void run() {  
                // TODO Auto-generated method stub  
                t2.doTest(t1);  
            }  
        });  
          
        th1.start();  
        th2.start();  
          
          
    }  
      
  
}  