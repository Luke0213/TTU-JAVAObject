package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener {

    private Button button;

    public Key(Button button) {
        this.button = button;
    }

    public void keyTyped(KeyEvent e) {
    	
    }
    
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_R) {
            button.resetClickCount();
        }
    }
    
    public void keyReleased(KeyEvent e) {
        
    }
}
