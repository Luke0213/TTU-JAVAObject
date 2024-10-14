package main;

import java.util.ArrayList;

public class ContactManager { // 負責聲明聯絡人
    private ArrayList<Contact> contacts; // 存儲聯絡人

    public ContactManager() {
        contacts = new ArrayList<>(); // 初始化聯絡人
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added: " + contact); 
    }

    public void printContacts() {
        System.out.println("--- Contact List ---");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public ArrayList<Contact> getContactList() { 
        return contacts;
    }
}