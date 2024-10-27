package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class AddressBook extends JFrame {
    // UI元件
    private JTextField accountField; // 帳號
    private JPasswordField passwordField; // 密碼
    private JCheckBox marriedCheckBox; // 已婚
    private JSlider heightSlider, weightSlider; // 身高和體重
    private JLabel heightValueLabel, weightValueLabel; // 顯示身高和體重的數值
    private JTextArea bioTextArea; // 簡介
    private JButton addButton, deleteButton, clearButton, searchButton, saveButton, exitButton; // 按鈕

    // 資料儲存
    private ArrayList<Contact> contacts = new ArrayList<>(); // 用於儲存聯絡人的資料

    public AddressBook() {
        // 初始化元件
        accountField = new JTextField(20); // 帳號輸入欄位
        passwordField = new JPasswordField(20); // 密碼輸入欄位
        marriedCheckBox = new JCheckBox("已婚"); // 已婚勾選框
        heightSlider = new JSlider(100, 200, 150); // 身高滑桿，範圍100到200公分
        weightSlider = new JSlider(30, 150, 70);   // 體重滑桿，範圍30到150公斤
        heightValueLabel = new JLabel(String.valueOf(heightSlider.getValue())); // 顯示初始身高數值
        weightValueLabel = new JLabel(String.valueOf(weightSlider.getValue())); // 顯示初始體重數值
        bioTextArea = new JTextArea(5, 20); // 簡介多行文字區域
        JScrollPane bioScrollPane = new JScrollPane(bioTextArea); // 加上捲動條

        // 顯示目前的數值
        heightSlider.addChangeListener(e -> heightValueLabel.setText(String.valueOf(heightSlider.getValue())));
        weightSlider.addChangeListener(e -> weightValueLabel.setText(String.valueOf(weightSlider.getValue())));

        // 按鈕
        addButton = new JButton("新增"); // 新增
        deleteButton = new JButton("刪除"); // 刪除
        clearButton = new JButton("清除"); // 清除
        searchButton = new JButton("查詢"); // 查詢
        saveButton = new JButton("存檔"); // 存檔
        exitButton = new JButton("結束"); // 結束

        // 設定佈局
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("帳號:"), gbc); // 帳號標籤
        gbc.gridx = 1;
        add(accountField, gbc); // 帳號輸入欄位

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("密碼:"), gbc); // 密碼標籤
        gbc.gridx = 1;
        add(passwordField, gbc); // 密碼輸入欄位

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("已婚:"), gbc); // 已婚標籤
        gbc.gridx = 1;
        add(marriedCheckBox, gbc); // 已婚勾選框

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("身高 (cm):"), gbc); // 身高標籤
        gbc.gridx = 1;
        add(heightSlider, gbc); // 身高滑桿

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("身高數值:"), gbc); // 顯示身高數值的標籤
        gbc.gridx = 1;
        add(heightValueLabel, gbc); // 身高數值

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("體重 (kg):"), gbc); // 體重標籤
        gbc.gridx = 1;
        add(weightSlider, gbc); // 體重滑桿

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("體重數值:"), gbc); // 顯示體重數值的標籤
        gbc.gridx = 1;
        add(weightValueLabel, gbc); // 體重數值

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("簡介:"), gbc); // 簡介標籤
        gbc.gridx = 1;
        add(bioScrollPane, gbc); // 簡介文字區域（含捲動條）

        // 添加按鈕到面板
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        JPanel buttonPanel = new JPanel(new FlowLayout()); // 使用流式佈局
        buttonPanel.add(addButton); // 新增
        buttonPanel.add(deleteButton); // 刪除
        buttonPanel.add(clearButton); // 清除
        buttonPanel.add(searchButton); // 查詢
        buttonPanel.add(saveButton); // 存檔
        buttonPanel.add(exitButton); // 結束
        add(buttonPanel, gbc); // 添加按鈕面板

        // 設定JFrame屬性
        setTitle("GUI通訊錄"); // 設定視窗標題
        setSize(500, 600); // 設定視窗大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 設定關閉操作
        setVisible(true); // 設定視窗可見

        // 為按鈕添加事件監聽器
        addButton.addActionListener(e -> addContact()); // 新增聯絡人事件
        deleteButton.addActionListener(e -> deleteContact()); // 刪除聯絡人事件
        clearButton.addActionListener(e -> clearFields()); // 清除欄位事件
        searchButton.addActionListener(e -> searchContact()); // 查詢聯絡人事件
        saveButton.addActionListener(e -> saveToFile()); // 存檔事件
        exitButton.addActionListener(e -> System.exit(0)); // 結束程式事件
    }

    // 新增聯絡人方法
    private void addContact() {
        String account = accountField.getText(); // 獲取帳號
        String password = new String(passwordField.getPassword()); // 獲取密碼
        boolean married = marriedCheckBox.isSelected(); // 獲取已婚狀態
        int height = heightSlider.getValue(); // 獲取身高
        int weight = weightSlider.getValue(); // 獲取體重
        String bio = bioTextArea.getText(); // 獲取簡介

        Contact contact = new Contact(account, password, married, height, weight, bio); // 建立聯絡人對象
        contacts.add(contact); // 將聯絡人加入列表
        JOptionPane.showMessageDialog(this, "資料新增成功!"); // 顯示新增成功訊息
    }

    // 刪除聯絡人方法
    private void deleteContact() {
        String account = JOptionPane.showInputDialog(this, "輸入要刪除的帳號:"); // 獲取要刪除的帳號
        contacts.removeIf(contact -> contact.getAccount().equals(account)); // 根據帳號刪除聯絡人
        JOptionPane.showMessageDialog(this, "資料已刪除!"); // 顯示刪除成功訊息
    }

    // 清除欄位方法
    private void clearFields() {
        accountField.setText(""); // 清除帳號欄位
        passwordField.setText(""); // 清除密碼欄位
        marriedCheckBox.setSelected(false); // 取消已婚勾選
        heightSlider.setValue(150); // 重設身高滑桿
        weightSlider.setValue(70); // 重設體重滑桿
        bioTextArea.setText(""); // 清除簡介欄位
    }

    // 查詢聯絡人方法
    private void searchContact() {
        String account = JOptionPane.showInputDialog(this, "輸入要查詢的帳號:"); // 獲取要查詢的帳號
        for (Contact contact : contacts) {
            if (contact.getAccount().equals(account)) {
                accountField.setText(contact.getAccount()); // 顯示查詢到的帳號
                passwordField.setText(contact.getPassword()); // 顯示查詢到的密碼
                marriedCheckBox.setSelected(contact.isMarried()); // 顯示查詢到的已婚狀態
                heightSlider.setValue(contact.getHeight()); // 顯示查詢到的身高
                weightSlider.setValue(contact.getWeight()); // 顯示查詢到的體重
                bioTextArea.setText(contact.getBio()); // 顯示查詢到的簡介
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "找不到相關資料!"); // 顯示查詢失敗訊息
    }

    // 將聯絡人儲存到檔案的方法
    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("contacts.txt"))) {
            for (Contact contact : contacts) {
                writer.println(contact); // 將聯絡人資料寫入檔案
            }
            JOptionPane.showMessageDialog(this, "資料已存檔!"); // 顯示存檔成功訊息
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "存檔失敗: " + e.getMessage()); // 顯示存檔失敗訊息
        }
    }

    public static void main(String[] args) {
        new AddressBook(); // 建立並顯示通訊錄視窗
    }
}

// 聯絡人類別，用於儲存個別聯絡人的資料
class Contact {
    private String account; // 帳號
    private String password; // 密碼
    private boolean married; // 已婚狀態
    private int height; // 身高
    private int weight; // 體重
    private String bio; // 簡介

    public Contact(String account, String password, boolean married, int height, int weight, String bio) {
        this.account = account;
        this.password = password;
        this.married = married;
        this.height = height;
        this.weight = weight;
        this.bio = bio;
    }

    public String getAccount() {
        return account; // 獲取帳號
    }

    public String getPassword() {
        return password; // 獲取密碼
    }

    public boolean isMarried() {
        return married; // 獲取已婚狀態
    }

    public int getHeight() {
        return height; // 獲取身高
    }

    public int getWeight() {
        return weight; // 獲取體重
    }

    public String getBio() {
        return bio; // 獲取簡介
    }

    public String toString() {
        return account + "," + password + "," + married + "," + height + "," + weight + "," + bio; // 將聯絡人資料轉為字串
    }
}
