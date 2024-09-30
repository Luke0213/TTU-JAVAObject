package main;

import javax.sound.sampled.*;
import javax.swing.*;
import java.net.URL;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class Button{
    int clickCount = 0;
    JButton btn;
    ImageIcon[] catImages;
    JLabel clickLabel;
    Timer timer;
    Clip backgroundMusicClip;

    public void addComponetsToPane(Container pane) {
        pane.setLayout(null);
        
        URL catImageURL1 = getClass().getResource("/objects/Cat.jpeg");
        URL catImageURL2 = getClass().getResource("/objects/Cat2.jpeg");
        URL catImageURL3 = getClass().getResource("/objects/Cat3.jpeg");
        URL catImageURL4 = getClass().getResource("/objects/Cat4.jpeg");
        
        catImages = new ImageIcon[4];
        if (catImageURL1 != null) {
            catImages[0] = new ImageIcon(catImageURL1);
        }
        if (catImageURL2 != null) {
            catImages[1] = new ImageIcon(catImageURL2);
        }
        if (catImageURL1 != null) {
            catImages[2] = new ImageIcon(catImageURL3);
        }
        if (catImageURL2 != null) {
            catImages[3] = new ImageIcon(catImageURL4);
        }


        clickLabel = new JLabel("Click count: 0");
        clickLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
        clickLabel.setBounds(525, 100, 230, 230);
        pane.add(clickLabel);

        btn = new JButton("Click");
        btn.setFont(new Font("Courier New", Font.BOLD, 20));
        btn.setBounds(500, 250, 230, 230);
        
        btn.addActionListener(e -> { 
        	Random random = new Random();
            int randomIndex = random.nextInt(catImages.length);
            btn.setIcon(catImages[randomIndex]);
            btn.setText(""); 
            clickLabel.setText("Click count: " + (++clickCount)); 

            playSound("/SoundEffects/y869.wav"); 
            
            if (timer != null && timer.isRunning()) {
                timer.stop(); 
            }
            timer = new Timer(30000, event->resetButton());
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
