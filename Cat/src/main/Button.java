package main;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.net.URL;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Button{
    int clickCount = 0;
    JButton btn;
    ImageIcon catImage;
    JLabel clickLabel;
    Timer timer;
    Clip backgroundMusicClip;

    public void addComponetsToPane(Container pane) {
        pane.setLayout(null);
        
        URL catImageURL = getClass().getResource("/objects/Cat.jpeg");
        
        if (catImageURL != null) {
            catImage = new ImageIcon(catImageURL);
        }

        clickLabel = new JLabel("Click count: 0");
        clickLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
        clickLabel.setBounds(525, 100, 230, 230);
        pane.add(clickLabel);

        btn = new JButton("Click");
        btn.setFont(new Font("Courier New", Font.BOLD, 20));
        btn.setBounds(500, 250, 230, 230);
        
        btn.addActionListener(e -> { 
        	btn.setIcon(catImage);
            btn.setText(""); 
            clickLabel.setText("Click count: " + (++clickCount)); 

            playSound("/SoundEffects/y869.wav"); 
            
            if (timer != null && timer.isRunning()) {
                timer.stop(); 
            }
            timer = new Timer(300, event->resetButton());
            timer.setRepeats(false); 
            timer.start();
        });
        pane.add(btn);
    }

    public void resetClickCount() {
        clickCount = 0;
        resetButton();
    }

    private void resetButton() {
        btn.setIcon(null); 
        btn.setText("Click"); 
        clickLabel.setText("Click count: " + clickCount); 
    }

    private void playSound(String soundFilePath) {
        try {
        	
        	URL soundFileURL = getClass().getResource(soundFilePath);
        	
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFileURL);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
}
