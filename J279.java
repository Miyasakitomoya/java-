package java8��;

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
                            System.out.println("��ѭ����ѭ����ThreadCount == " + (j+1));  
                        }  
                        System.out.println("��ѭ��ִ���� --->"+(i+1)+"��10��");  
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
                //���߳��ó������ȴ����̻߳���  
                object.wait();  
                for (int j = 0; j < 15; j++) {  
                    System.out.println("��ѭ����ѭ����MainCount == " + (j+1));  
                }  
                System.out.println("��ѭ��ִ���� --->"+(i+1)+"��20��");                
                object.notify();                  
            }  
        }  
    }     
}