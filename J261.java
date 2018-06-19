package java8��;

public class J261 extends Thread {  
	  
    private static int[] chopstick = { 1, 1, 1, 1, 1 };  
    private int i;  
  
    public J261(int i) {  
        this.i = i;  
    }  
  
    @Override  
    public void run() {  
  
        synchronized (chopstick) {  //��ע�ʹ��У������У���ͬ����5��perֻ�õ������  
        //{    
        eat(this.getName());  
  
        think(this.getName());  
        }  
  
    }  
  
    private void think(String name) {  
        chopstick[i] = 1;  
        chopstick[(i + 1) % 5] = 1;  
        System.out.println("per"+name+" is thinking...");  
          
    }  
  
    private void eat(String string) {  
  
            while (true) {  
  
                if (chopstick[i] != 0) {  
                    chopstick[i]--;  
                    System.out.println("per" + this.getName()  
                            + " got left chopstick.");  
                    break;  
                }  
  
            }  
  
            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
  
            while (true) {  
                if (chopstick[(i + 1) % 5] != 0) {  
                    chopstick[(i + 1) % 5]--;  
                    System.out.println("per" + this.getName()  
                            + " got right chopstick.");  
                    break;  
                }  
  
            }  
        System.out.println("per" + string + " is eating...");  
    }  
    public static void main(String[] args) {  
    	  
        
        for (int i = 0; i < 5; i++) {  
              
            Thread t = new J261(i);  
  
            t.start();  
        }         
    }  
}  