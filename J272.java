package java8��;
	public class J272 {  
	    /** 
	     * ϵͳĬ�������ֻ�������̡߳� 
	     *  
	     * @param args 
	     */  
	    public static void main(String[] args) {  
	        // main�����������߳�  
	        //�����߳��п����������߳�  
	        Thread1 thread1 = new Thread1();  
	        Thread2 thread2 = new Thread2();  
	        thread1.start();  
	        thread2.start();  
	        System.out.println("���̻߳���3�뵽��ս����");  
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
	        System.out.println("���̳߳�����");  
	    }
}
	class Thread1 extends Thread {  
	    /** 
	     * �߳������ڼ�ִ�еĴ��� 
	     */  
	    @Override  
	    public void run() {  
	        // TODO Auto-generated method stub  
	        super.run();  
	        System.out.println("�߳�1��ʼ����......");  
	        try {  
	            Thread.sleep(3000);  
	        } catch (InterruptedException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	        System.out.println("�߳�1����ִ��......");  
	    }  
	}  
	class Thread2 extends Thread {  
	    /** 
	     * �߳������ڼ�ִ�еĴ��� 
	     */  
	    @Override  
	    public void run() {  
	        // TODO Auto-generated method stub  
	        super.run();  
	        System.out.println("�߳�2��ʼ����......");  
	        try {  
	            Thread.sleep(4000);  
	        } catch (InterruptedException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	        System.out.println("�߳�2����ִ��......");  
	    }  
	}  