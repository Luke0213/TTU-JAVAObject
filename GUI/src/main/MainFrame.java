package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private InputPanel inputPanel; // 定義輸入
    private ScrollTextPanel scrollTextPanel; // 定義滾動文本
    private SliderPanel sliderPanel; // 定義滑動條
    private ButtonPanel buttonPanel; // 定義鍵
    private ArrayList<Contact> contactList; // 聯絡人列表

    public MainFrame() {
        setTitle("GUI 通訊錄");
        setSize(500, 600); // 視窗大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 初始化聯絡人列表
        contactList = new ArrayList<>();

        // 初始化各個面板
        inputPanel = new InputPanel();
        scrollTextPanel = new ScrollTextPanel();
        sliderPanel = new SliderPanel();
        
        // 將聯絡人列表和輸入面板傳給 ButtonPanel
        buttonPanel = new ButtonPanel(contactList, inputPanel);

        // 創建中心面板
        JPanel centerPanel = new JPanel(); 
        centerPanel.setLayout(new GridLayout(3, 1)); // 設定3行1列
        centerPanel.add(inputPanel);
        centerPanel.add(scrollTextPanel);
        centerPanel.add(sliderPanel);

        // 添加中心面板和按鈕面板到框架
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
