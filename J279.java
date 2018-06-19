package java8级;

public class J279 {  
    private static Object object = new Object();  
    public static void main(String[] args) throws InterruptedException {  
        // TODO Auto-generated method stub  
        new Thread(new Runnable() {  
              
            public void run() {  
                // TODO Auto-generated method stub  
                for (int i = 0; i < 50; i++) {  
                    synchronized (object) {  
                        for (int j = 0; j < 10; j++) {  
                            System.out.println("子循环在循环：ThreadCount == " + (j+1));  
                        }  
                        System.out.println("子循环执行了 --->"+(i+1)+"个10次");  
                        object.notify();  
                        try {  
                            object.wait();  
                        } catch (InterruptedException e) {  
                            // TODO Auto-generated catch block  
                            e.printStackTrace();  
                        }                         
                    }  
                }  
            }  
        }).start();  
  
        for(int i = 0; i < 20; i++){  
            synchronized (object) {  
                //主线程让出锁，等待子线程唤醒  
                object.wait();  
                for (int j = 0; j < 15; j++) {  
                    System.out.println("主循环在循环：MainCount == " + (j+1));  
                }  
                System.out.println("主循环执行了 --->"+(i+1)+"个20次");                
                object.notify();                  
            }  
        }  
    }     
}