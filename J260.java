package java8级;

import java.awt.*;
import javax.swing.*;
public class J260 extends JFrame{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Thread thread1;//定义线程
    private Thread thread2;
    private Thread thread3;
    private Thread thread4;
    //重写构造方法
    public J260(){
        Container c = getContentPane();
        c.setLayout(new GridLayout(4,1));
        JProgressBar bar1 = new JProgressBar(); //获取进度条组件
        JProgressBar bar2 = new JProgressBar();
        JProgressBar bar3 = new JProgressBar();
        JProgressBar bar4 = new JProgressBar();
        bar1.setName("bar1");    //为标签添加名称，方便观察哪个进程先运行
        bar2.setName("bar2");
        bar3.setName("bar3");
        bar4.setName("bar4");
        c.add(bar1); //添加进度条组件
        c.add(bar2);
        c.add(bar3);
        c.add(bar4);
        thread1 = new Thread(new MyThread(bar1));//获取线程实例，参数为实现了Runnable 接口的自定义类
        thread2 = new Thread(new MyThread(bar2));
        thread3 = new Thread(new MyThread(bar3));
        thread4 = new Thread(new MyThread(bar4));
        setPriority("thread1",10,thread1); //设置线程优先级，并启动线程
        setPriority("thread2",10,thread2);
        setPriority("thread3",4,thread3);
        setPriority("thread4",3,thread4);
    }
    //静态方法，定义线程优先级并启动线程
    public static void setPriority(String threadName,int priority,Thread t){
        t.setPriority(priority);
        t.setName(threadName);
        t.start();
    }

    //自定义内部类，实现了Runnable接口
    private class MyThread implements Runnable{
        private JProgressBar bar;
        private int count = 0;
        private MyThread(JProgressBar bar){
            this.bar = bar;
            bar.setStringPainted(true);
        }
        public void run(){
            while(true){
                try{
                    bar.setValue(++count);
                    //看到哪个进度条的进度再增加，就可以知道哪个进程在运行
                    System.out.println(bar.getName()+"已运行"+count+"次");
                    Thread.sleep(100);
                    if(count==100){
                        break;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    //初始化窗口的静态方法
    public static void init(JFrame frame,int width,int height){
            frame.setSize(width,height);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    public static void main(String[] args) {
        //调用本类的静态方法前面可不加类名，直接调用
        //init(new PriorityTest(),300,200); 也可以
    	J260.init(new J260(),300,200);
    }

}