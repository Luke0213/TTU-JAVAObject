package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class Panel extends JPanel implements Runnable {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    private JTextField weightField;
    private JTextField heightField;
    private JButton calculateButton;
    private JButton clearButton;

    public Panel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.lightGray);

        // 設定垂直排列
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 

        // 1.input體重
        JPanel weightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel weightLabel = new JLabel("Kg:");
        weightField = new JTextField(10); // 字元大小
        weightPanel.add(weightLabel); // 標籤
        weightPanel.add(weightField); // 輸入框

        // 2.input身高
        JPanel heightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel heightLabel = new JLabel("Height:");
        heightField = new JTextField(10);
        heightPanel.add(heightLabel);
        heightPanel.add(heightField);

        // 3.按鈕
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        
        
        // 點擊按鈕return
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateBMI(); // 計算 BMI
            }
        });

        // 點擊按鈕return
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields(); // Clear
            }
        });

        add(weightPanel);
        add(heightPanel);
        add(buttonPanel);

        this.setFocusable(true);
        this.requestFocus();
    }
    
    // 計算 BMI 
    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText()); // 取體重
            double height = Double.parseDouble(heightField.getText()); // 取身高

            double bmi = weight / ((height / 100) * (height / 100)); // 公式

            String bmiCategory;
            if (bmi < 18.5) {
                bmiCategory = "過輕";
            } else if (bmi >= 18.5 && bmi < 24) {
                bmiCategory = "正常";
            } else if (bmi >= 24.1 && bmi <= 26.9) {
                bmiCategory = "過重";
            } else if (bmi >= 27 && bmi <= 29.9) {
                bmiCategory = "輕度肥胖";
            } else if (bmi >= 30 && bmi <= 34.9) {
                bmiCategory = "中度肥胖";
            } else {
            	bmiCategory = "重度肥胖";
            }

            JOptionPane.showMessageDialog(this, "BMI = " + String.format("%.2f", bmi) + "\n分類: " + bmiCategory);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "請輸入有效的數字！");
        }
    }
    
    // clear
    private void clearFields() {
        weightField.setText("");
        heightField.setText("");
    }
    
    public void run() {
    }
}
