package java8��;

class MyThread1 implements Runnable{
private String name;
MyThread1(String name){
this.name = name;
}
public void run(){
for(int i=0; i<10; i++){
System.out.println(name+i);
}
}
}
public class J273 {


public static void main(String[] args) {
// TODO Auto-generated method stub
MyThread1 mh = new MyThread1("�߳�һ��");  //ʵ����Runnable�������
MyThread1 mh1 = new MyThread1("�̶߳���");
Thread t1 = new Thread(mh);             //ʵ����Thread�����
Thread t2 = new Thread(mh1);
t1.start();
t2.start();
}


}