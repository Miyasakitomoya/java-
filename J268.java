package java8��;

public class J268 {
    public static void main (String [] args) throws InterruptedException {
    Thread t =new Thread(new EmergencyThread(),"�̣߳�");//�����߳�
        t.start(); //�����߳�
        for(int i=1;i<6;i++){
            System.out.println(Thread.currentThread().getName()+"����:"+i);
            if(i==2){
                t.join(); //����join��������
            }
            Thread.sleep(500); //�߳�����500����
        }
    }
}

class  EmergencyThread  implements  Runnable{
    public void run(){

        for (int i=1;i<6;i++){
            System.out.println(Thread.currentThread().getName()+"����:"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
