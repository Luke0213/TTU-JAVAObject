package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    Thread CatThread;
    Button button;

    public Panel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.pink);
        this.setLayout(null);

        button = new Button(); 
        button.addComponetsToPane(this);

        Key keyListener = new Key(button);
        this.addKeyListener(keyListener);
        this.setFocusable(true); 
        this.requestFocus();    
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        this.requestFocusInWindow();
    }

    public void launchCat() {
        CatThread = new Thread(this);
        CatThread.start();
    }

    public void run() {
    }
}
