package main;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    JTextField nameField;
    JComboBox<String> postalCodeBox;
    JTextField addressField;
    JCheckBox marriedCheckBox;
    JRadioButton maleRadioButton;
    JRadioButton femaleRadioButton;
    JTextField emailField;
    ButtonGroup genderGroup;

    public InputPanel() {
        setLayout(new GridLayout(7, 2));

        add(new JLabel("姓名: "));
        nameField = new JTextField(10);
        add(nameField);

        add(new JLabel("郵遞區號: "));
        String[] postalCodes = { "100", "101", "102", "103", "104", "105", "106", "107", "108" }; 
        postalCodeBox = new JComboBox<>(postalCodes);
        add(postalCodeBox);

        add(new JLabel("地址: "));
        addressField = new JTextField(20);
        add(addressField);

        add(new JLabel("已婚: "));
        marriedCheckBox = new JCheckBox();
        add(marriedCheckBox);

        add(new JLabel("性別: "));
        JPanel genderPanel = new JPanel();
        maleRadioButton = new JRadioButton("男");
        femaleRadioButton = new JRadioButton("女");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        add(genderPanel);

        add(new JLabel("Email: "));
        emailField = new JTextField(20);
        add(emailField);
    }

    public Contact createContact() {
        String gender = maleRadioButton.isSelected() ? "男" : "女";
        return new Contact(
            nameField.getText(),
            (String) postalCodeBox.getSelectedItem(), 
            addressField.getText(),
            marriedCheckBox.isSelected(),
            gender,
            emailField.getText()
        );
    }

    public String getNameInput() {
        return nameField.getText();
    }
}
