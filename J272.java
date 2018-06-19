package java8级;
	public class J272 {  
	    /** 
	     * 系统默认情况下只运行主线程。 
	     *  
	     * @param args 
	     */  
	    public static void main(String[] args) {  
	        // main方法就是主线程  
	        //在主线程中开启两个子线程  
	        Thread1 thread1 = new Thread1();  
	        Thread2 thread2 = new Thread2();  
	        thread1.start();  
	        thread2.start();  
	        System.out.println("主线程还有3秒到达战场！");  
	        try {  
	            Thread.sleep(1000);  
	        } catch (InterruptedException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	        System.out.println("2...");  
	        try {  
	            Thread.sleep(1000);  
	        } catch (InterruptedException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	        System.out.println("1!!!");  
	        try {  
	            Thread.sleep(1000);  
	        } catch (InterruptedException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	        System.out.println("主线程出击！");  
	    }
}
	class Thread1 extends Thread {  
	    /** 
	     * 线程运行期间执行的代码 
	     */  
	    @Override  
	    public void run() {  
	        // TODO Auto-generated method stub  
	        super.run();  
	        System.out.println("线程1开始运行......");  
	        try {  
	            Thread.sleep(3000);  
	        } catch (InterruptedException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	        System.out.println("线程1继续执行......");  
	    }  
	}  
	class Thread2 extends Thread {  
	    /** 
	     * 线程运行期间执行的代码 
	     */  
	    @Override  
	    public void run() {  
	        // TODO Auto-generated method stub  
	        super.run();  
	        System.out.println("线程2开始运行......");  
	        try {  
	            Thread.sleep(4000);  
	        } catch (InterruptedException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	        System.out.println("线程2继续执行......");  
	    }  
	}  