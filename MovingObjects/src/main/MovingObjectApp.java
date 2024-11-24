package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovingObjectApp extends JFrame {

    private DrawCanvas canvas;
    private int circleX = 50, circleY = 50; // 圓的初始位置
    private int aX = 150, aY = 150; // 字母 A 的初始位置
    private int rectX = 20, rectY = 20; // 方塊的初始位置
    private String selectedObject = "circle"; // 預設選擇圓形

    public MovingObjectApp() {
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(400, 300));

        // 設定 JFrame
        this.setContentPane(canvas);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setTitle("Move an Object");
        this.setLayout(new BorderLayout());

        // 加入按鈕面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));

        JButton upButton = new JButton("上");
        JButton downButton = new JButton("下");
        JButton leftButton = new JButton("左");
        JButton rightButton = new JButton("右");

        buttonPanel.add(upButton);
        buttonPanel.add(downButton);
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);

        this.add(buttonPanel, BorderLayout.EAST);

        // 按鈕動作監聽
        upButton.addActionListener(e -> moveUp());
        downButton.addActionListener(e -> moveDown());
        leftButton.addActionListener(e -> moveLeft());
        rightButton.addActionListener(e -> moveRight());

        // 鍵盤監聽
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> moveUp();
                    case KeyEvent.VK_DOWN -> moveDown();
                    case KeyEvent.VK_LEFT -> moveLeft();
                    case KeyEvent.VK_RIGHT -> moveRight();
                }
            }
        });

        // 滑鼠監聽，用於選擇物體
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                // 檢查點擊是否在圓形內
                if (mouseX >= circleX && mouseX <= circleX + 50 &&
                    mouseY >= circleY && mouseY <= circleY + 50) {
                    selectedObject = "circle";
                }

                // 檢查點擊是否在方塊內
                if (mouseX >= rectX && mouseX <= rectX + 50 &&
                    mouseY >= rectY && mouseY <= rectY + 50) {
                    selectedObject = "rectangle";
                }

                // 檢查點擊是否在字母 A 附近
                if (mouseX >= aX && mouseX <= aX + 20 &&
                    mouseY >= aY - 20 && mouseY <= aY) {
                    selectedObject = "A";
                }
            }
        });

        this.setFocusable(true);
        this.setVisible(true);
    }

    // 移動方法
    private void moveUp() {
        switch (selectedObject) {
            case "circle" -> circleY -= 10;
            case "rectangle" -> rectY -= 10;
            case "A" -> aY -= 10;
        }
        canvas.repaint();
    }

    private void moveDown() {
        switch (selectedObject) {
            case "circle" -> circleY += 10;
            case "rectangle" -> rectY += 10;
            case "A" -> aY += 10;
        }
        canvas.repaint();
    }

    private void moveLeft() {
        switch (selectedObject) {
            case "circle" -> circleX -= 10;
            case "rectangle" -> rectX -= 10;
            case "A" -> aX -= 10;
        }
        canvas.repaint();
    }

    private void moveRight() {
        switch (selectedObject) {
            case "circle" -> circleX += 10;
            case "rectangle" -> rectX += 10;
            case "A" -> aX += 10;
        }
        canvas.repaint();
    }

    // 繪圖畫布
    private class DrawCanvas extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.CYAN);

            // 畫長方形
            g.setColor(Color.BLUE);
            g.fillRect(rectX, rectY, 50, 50);

            // 畫圓形
            g.setColor(Color.RED);
            g.fillOval(circleX, circleY, 50, 50);

            // 畫字母
            g.setColor(Color.BLACK);
            g.drawString("A", aX, aY);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MovingObjectApp::new);
    }
}
