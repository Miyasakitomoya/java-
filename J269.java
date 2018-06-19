package java8º∂;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

//≤‚ ‘Runnable
public class J269 extends JFrame implements Runnable {
    public static void main(String[] args) {
        J269 r = new J269();
        r.setSize(300,300);
        r.setVisible(true);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread t = new Thread(r);
        t.start();    
    }
    @Override
    public void run() {
        int i = 0;
        JPanel panel = new JPanel();
        panel.setSize(300,300);
        this.setContentPane(panel);
        while(true){
            i = i==0?1:0;
            if(i==0){
                panel.setBackground(Color.RED);
                panel.setBackground(Color.ORANGE);
                panel.setBackground(Color.YELLOW);
            }else{
                panel.setBackground(Color.GREEN);
                panel.setBackground(Color.BLACK);
                panel.setBackground(Color.BLUE);
            }
        }
    }
}