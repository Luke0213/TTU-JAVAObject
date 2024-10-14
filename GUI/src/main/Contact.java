
package main;

public class Contact {
    private String name;
    private String postalCode;
    private String address;
    private boolean married;
    private String gender;
    private String email;

    public Contact(String name, String postalCode, String address, boolean married, String gender, String email) {
        this.name = name;
        this.postalCode = postalCode;
        this.address = address;
        this.married = married;
        this.gender = gender;
        this.email = email;
    }

    public String toString() {
        return "姓名: " + name + ", 郵遞區號: " + postalCode + ", 地址: " + address + 
               ", 已婚: " + married + ", 性別: " + gender + ", Email: " + email;
    }

    public String getName() {
        return name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return address;
    }

    public boolean isMarried() {
        return married;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }
}
