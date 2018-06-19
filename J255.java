package java8级;

public class J255 {  
    
    public static void main(String[] args) {  
        Person per = new Person();  
        per.student.start();    
        per.teacher.start();  
    }  
  
}  
  
class Person implements Runnable{  
    Thread student,teacher;  
    Person(){  
        student = new Thread(this);  
        student.setName("student1");  
        teacher = new Thread(this);  
        teacher.setName("teacher");  
    }  
      
    @Override  
    public void run() {  
        if (Thread.currentThread()==student) {  
            try {  
                System.out.println(student.getName()+"正在睡觉");  
                student.sleep(120*60*1000);  
            } catch (InterruptedException e) {  
                System.out.println(student.getName()+"被老师叫醒了");   
            }  
        }  
        else if(Thread.currentThread()==teacher){   
                System.out.println("上课");  
                try {  
                    Thread.sleep(500);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
            student.interrupt();  
    }  
}  


