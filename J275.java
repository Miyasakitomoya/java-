package java8级;

class Hero{
    public String name;
    public float hp;
     
    public int damage;
     
    public void attackHero(Hero h) {
        try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
         
        if(h.isDead())
            System.out.println(h.name +"死了！");
    }
 
    public boolean isDead() {
        return 0>=hp?true:false;
    }
 
}

class KillThread extends Thread{
    
    private Hero h1;
    private Hero h2;
 
    public KillThread(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }
 
    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}

public class J275{  
        
		public static void main(String[] args) {
	         
	        Hero gareen = new Hero();
	        gareen.name = "盖伦";
	        gareen.hp = 616;
	        gareen.damage = 50;
	 
	        Hero teemo = new Hero();
	        teemo.name = "提莫";
	        teemo.hp = 300;
	        teemo.damage = 30;
	         
	        Hero bh = new Hero();
	        bh.name = "赏金猎人";
	        bh.hp = 500;
	        bh.damage = 65;
	         
	        Hero leesin = new Hero();
	        leesin.name = "盲僧";
	        leesin.hp = 455;
	        leesin.damage = 80;
	         
	        KillThread killThread1 = new KillThread(gareen,teemo);
	        killThread1.start();
	        KillThread killThread2 = new KillThread(bh,leesin);
	        killThread2.start();
	         
	    
    } 
}  

