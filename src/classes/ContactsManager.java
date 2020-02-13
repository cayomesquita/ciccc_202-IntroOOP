package classes;

public class ContactsManager {

    Contact[] friendsList;
    int friendsCount;

    public ContactsManager() {
        friendsList = new Contact[500];
        friendsCount = 0;
    }

    void addContact(Contact contact) {
        friendsList[friendsCount] = contact;
        friendsCount++;
    }

    Contact searchContact(String name) {
        for (int i = 0; i < friendsCount; i++) {
            if (friendsList[i].name.equals(name)) {
                System.out.println("Found the match!");
                System.out.println(friendsList[i].name);
                System.out.println(friendsList[i].phone);
                System.out.println(friendsList[i].email);
                return friendsList[i];
            }
        }
        System.out.println("No match!");
        return null;
    }

    public void printAllContacts() {
        int i = 0;
        for (Contact contact : friendsList) {
            if (i == friendsCount) {
                break;
            }
            System.out.println("[" + 1 + "]: " + contact.name + " - " + contact.phone + ", " + contact.email);
            i++;
        }
    }
}
