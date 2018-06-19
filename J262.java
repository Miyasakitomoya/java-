package java8��;

class Bank {

    private int count =0;//�˻����
    
    //��Ǯ
    public  synchronized void addMoney(int money){
        count +=money;
        System.out.println(System.currentTimeMillis()+"�����"+money);
    }
    
    //ȡǮ
    public  synchronized void subMoney(int money){
        if(count-money < 0){
            System.out.println("����");
            return;
        }
        count -=money;
        System.out.println(+System.currentTimeMillis()+"ȡ����"+money);
    }
    
    //��ѯ
    public void lookMoney(){
        System.out.println("�˻���"+count);
    }
}
	public class J262{
    public static void main(String args[]){
        final Bank bank=new Bank();
        
        Thread tadd=new Thread(new Runnable() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    bank.addMoney(100);
                    bank.lookMoney();
                    System.out.println("\n");
                    
                }
            }
        });
        
        Thread tsub = new Thread(new Runnable() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(true){
                    bank.subMoney(100);
                    bank.lookMoney();
                    System.out.println("\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }    
                }
            }
        });
        tsub.start();
        
        tadd.start();
    }
}