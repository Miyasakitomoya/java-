package java8��;

import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
  
public class J256 {  
  
    /** 
     * @param args 
     * ʹ��ExecutorServiceʵ���̳߳أ���ϸҪ�����£� 
        1�� �̳߳�Ҫִ�е�����Ϊÿ��һ�����һ�ε�ǰ�̵߳����֣��ܼ����10�Ρ� 
        2�� ����һ���̳߳أ����̳߳���ֻ���������̡߳� 
        3�� ʹ�̳߳�ִ��5�β���һ������ 
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
        System.out.println("ִ�е�ǰ������߳�Ϊ��" + name);  
        for(int i=0; i<10; i++){  
            System.out.println(name + ":" + i);  
            try{  
                Thread.sleep(1000);  
            }catch(InterruptedException e){  
                e.printStackTrace();  
            }  
        }  
        System.out.println(name+":�������");  
    }  
}  