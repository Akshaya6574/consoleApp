package login;

import ContactRepository.Repository;
import dto.Contacts;

import java.util.List;

public class LoginModel implements modelCallBack {
    private controllerCallBack controllerObj;

    public LoginModel(controllerCallBack controllerObj) {
        this.controllerObj = controllerObj;
    }


    @Override
    public boolean validUser(String userName, String password) {
        return Repository.getInstance().validUser(userName, password);
    }

    @Override
    public boolean addingContacts(String name, long phoneNumber, String address, String email) {
        return Repository.getInstance().addingContacts(name, phoneNumber, address, email);
    }

    @Override
    public List<Contacts> readingContacts() {
        return Repository.getInstance().readingContacts();
    }

    @Override
    public Contacts searchingContact(String name, long phoneNumber) {
        return Repository.getInstance().searchingContact(name, phoneNumber);
    }

    public boolean update(String name, long phoneNumber, String address, String email) {
        return Repository.getInstance().update(name, phoneNumber, address, email);

    }

    @Override
    public void deleteContact(String name, long phoneNumber) {
        Repository.getInstance().deleteContact(name, phoneNumber);
    }

    @Override
    public void exit() {
        Repository.getInstance().exit();
    }
}
