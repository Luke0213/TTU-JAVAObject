
package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonPanel extends JPanel { 
    JButton addButton; 
    JButton clearButton; 
    JButton queryButton; 
    JButton exitButton; 

    public ButtonPanel(ArrayList<Contact> contactList, InputPanel inputPanel) {
        setLayout(new GridLayout(1, 4)); 
        
        addButton = new JButton("新增"); 
        clearButton = new JButton("清除");
        queryButton = new JButton("查詢");
        exitButton = new JButton("結束");

        add(addButton);
        add(clearButton);
        add(queryButton);
        add(exitButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Contact newContact = inputPanel.createContact();
                if (newContact != null) {
                    contactList.add(newContact);
                    JOptionPane.showMessageDialog(null, "已新增聯絡人: " + newContact);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nameToRemove = inputPanel.getNameInput();
                boolean removed = contactList.removeIf(contact -> contact.getName().equalsIgnoreCase(nameToRemove));
                if (removed) {
                    JOptionPane.showMessageDialog(null, "已清除聯絡人: " + nameToRemove);
                } else {
                    JOptionPane.showMessageDialog(null, "未找到聯絡人: " + nameToRemove);
                }
            }
        });

        queryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder contacts = new StringBuilder();
                for (Contact contact : contactList) {
                    contacts.append(contact).append("\n");
                }
                JOptionPane.showMessageDialog(null, "所有聯絡人:\n" + contacts.toString());
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
