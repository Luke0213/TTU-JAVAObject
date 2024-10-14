package main;

import javax.swing.*;

public class ContactManagerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // 確保事件調度線程執行
            MainFrame frame = new MainFrame(); // 創建主窗口
            frame.setVisible(true);
        });
    }
}
