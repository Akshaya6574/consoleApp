package login;

import dto.Contacts;

import java.util.List;

public interface controllerCallBack {
    void decideOptions(int option);

    void decideLogin(int option);

    boolean validUser(String userName, String password);

    boolean addingContacts(String name, long phoneNumber, String address, String email);

    void decideToProceed(int option);

    List<Contacts> readingContacts();

    Contacts searchingContact(String name, long phoneNumber);

    boolean update(String name, long phoneNumber, String address, String email);

    void deleteContact(String name, long phoneNumber);

    void exit();
}
