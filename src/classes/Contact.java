package classes;

public class Contact {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Contact(String name, String phone, String email) {
        this(name, phone);
        this.email = email;
    }
}
