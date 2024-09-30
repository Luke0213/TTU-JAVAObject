package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
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

    public void run() {
    }
}
