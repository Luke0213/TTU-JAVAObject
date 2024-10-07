package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

    	
        SwingUtilities.invokeLater(new Runnable() { // 確保不會出錯
            public void run() {
                JFrame BMI = new JFrame("BMI Calculator");

                BMI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 設關閉鍵
                BMI.setResizable(false);

                Panel p = new Panel(); 

                BMI.add(p);
                BMI.pack(); 
                
                BMI.setLocationRelativeTo(null);
                BMI.setVisible(true); // 顯示視窗
            }
        });
    }
}
