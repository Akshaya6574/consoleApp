package login;

import dto.Contacts;

import java.util.List;

public class LoginController implements controllerCallBack, modelCallBack {
    private loginViewCallBack viewObj;
    private modelCallBack modelObj;

    public LoginController(loginViewCallBack viewObj) {
        this.viewObj = viewObj;
        modelObj = new LoginModel(this);

    }

    public void decideOptions(int option) {
        switch (option) {
            case 1:
                viewObj.addContact();
                break;
            case 2:
                viewObj.readContact();
                break;
            case 3:
                viewObj.searchContact();
                break;
            case 4:
                viewObj.deleteContact();
                break;
            case 5:
                viewObj.renameContact();
                break;
            case 9:
                viewObj.exit();
                break;
            default:
                viewObj.invalid();
                break;
        }
    }

    @Override
    public void decideLogin(int option) {
        switch (option) {
            case 1:
                viewObj.newUser();
                break;
            case 2:
                viewObj.newUser();
                break;
            default:
                viewObj.invalid();
        }
    }

    public boolean validUser(String userName, String password) {
        return modelObj.validUser(userName, password);

    }

    @Override
    public boolean addingContacts(String name, long phoneNumber, String address, String email) {
        return modelObj.addingContacts(name, phoneNumber, address, email);
    }

    @Override
    public void decideToProceed(int option) {
        switch (option) {
            case 1:
                viewObj.addContact();
                break;
            case 2:
                viewObj.welcome();
                break;
            default:
                viewObj.invalid();
                break;
        }
    }

    public List<Contacts> readingContacts() {
        return modelObj.readingContacts();
    }

    @Override
    public Contacts searchingContact(String name, long phoneNumber) {
        return modelObj.searchingContact(name, phoneNumber);
    }

    public boolean update(String name, long phoneNumber, String address, String email) {
        return modelObj.update(name, phoneNumber, address, email);

    }

    @Override
    public void deleteContact(String name, long phoneNumber) {
        modelObj.deleteContact(name, phoneNumber);
    }

    @Override
    public void exit() {
        modelObj.exit();
    }
}
