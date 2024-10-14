package main;

import javax.swing.*;
import java.awt.*;

public class ScrollTextPanel extends JPanel { // 負責定義滾動文本
    JTextArea textArea; // 定義文本區
    JScrollBar scrollBar; // // 定義滾動條

    public ScrollTextPanel() {
        setLayout(new BorderLayout());
        textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        scrollBar = new JScrollBar();
        add(scrollBar, BorderLayout.EAST); // 放在右邊
    }
}
