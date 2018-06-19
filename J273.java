package java8级;

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
MyThread1 mh = new MyThread1("线程一：");  //实例化Runnable子类对象
MyThread1 mh1 = new MyThread1("线程二：");
Thread t1 = new Thread(mh);             //实例化Thread类对象
Thread t2 = new Thread(mh1);
t1.start();
t2.start();
}


}