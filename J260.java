package java8��;

import java.awt.*;
import javax.swing.*;
public class J260 extends JFrame{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Thread thread1;//�����߳�
    private Thread thread2;
    private Thread thread3;
    private Thread thread4;
    //��д���췽��
    public J260(){
        Container c = getContentPane();
        c.setLayout(new GridLayout(4,1));
        JProgressBar bar1 = new JProgressBar(); //��ȡ���������
        JProgressBar bar2 = new JProgressBar();
        JProgressBar bar3 = new JProgressBar();
        JProgressBar bar4 = new JProgressBar();
        bar1.setName("bar1");    //Ϊ��ǩ������ƣ�����۲��ĸ�����������
        bar2.setName("bar2");
        bar3.setName("bar3");
        bar4.setName("bar4");
        c.add(bar1); //��ӽ��������
        c.add(bar2);
        c.add(bar3);
        c.add(bar4);
        thread1 = new Thread(new MyThread(bar1));//��ȡ�߳�ʵ��������Ϊʵ����Runnable �ӿڵ��Զ�����
        thread2 = new Thread(new MyThread(bar2));
        thread3 = new Thread(new MyThread(bar3));
        thread4 = new Thread(new MyThread(bar4));
        setPriority("thread1",10,thread1); //�����߳����ȼ����������߳�
        setPriority("thread2",10,thread2);
        setPriority("thread3",4,thread3);
        setPriority("thread4",3,thread4);
    }
    //��̬�����������߳����ȼ��������߳�
    public static void setPriority(String threadName,int priority,Thread t){
        t.setPriority(priority);
        t.setName(threadName);
        t.start();
    }

    //�Զ����ڲ��࣬ʵ����Runnable�ӿ�
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
                    //�����ĸ��������Ľ��������ӣ��Ϳ���֪���ĸ�����������
                    System.out.println(bar.getName()+"������"+count+"��");
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
    //��ʼ�����ڵľ�̬����
    public static void init(JFrame frame,int width,int height){
            frame.setSize(width,height);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    public static void main(String[] args) {
        //���ñ���ľ�̬����ǰ��ɲ���������ֱ�ӵ���
        //init(new PriorityTest(),300,200); Ҳ����
    	J260.init(new J260(),300,200);
    }

}