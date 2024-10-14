package main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderPanel extends JPanel {
    private JSlider heightSlider;
    private JSlider weightSlider;
    private JLabel heightLabel;
    private JLabel weightLabel;

    public SliderPanel() {
        setLayout(new GridLayout(2, 2)); 

        heightSlider = new JSlider(100, 250, 170); 
        heightSlider.setMajorTickSpacing(50);
        heightSlider.setMinorTickSpacing(10);
        heightSlider.setPaintTicks(true);
        heightSlider.setPaintLabels(true);
        heightLabel = new JLabel("身高: 170 cm"); 
        heightSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                heightLabel.setText("身高: " + heightSlider.getValue() + " cm");
            }
        });

        weightSlider = new JSlider(30, 150, 70); 
        weightSlider.setMajorTickSpacing(20);
        weightSlider.setMinorTickSpacing(5);
        weightSlider.setPaintTicks(true);
        weightSlider.setPaintLabels(true);
        weightLabel = new JLabel("體重: 70 kg"); 
        weightSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                weightLabel.setText("體重: " + weightSlider.getValue() + " kg");
            }
        });

        add(heightSlider);
        add(heightLabel);
        add(weightSlider);
        add(weightLabel);
    }

    public int getSelectedHeight() {
        return heightSlider.getValue();
}
}