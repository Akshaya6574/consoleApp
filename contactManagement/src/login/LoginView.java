package login;

import dto.Contacts;

import java.util.List;
import java.util.Scanner;

public class LoginView implements loginViewCallBack {
    private Scanner sc = new Scanner(System.in);
    private controllerCallBack controllerObj;

    public LoginView() {
        controllerObj = new LoginController(this);
    }

    public static void main(String[] args) {
        LoginView mainObj = new LoginView();
        mainObj.userLogin();
        mainObj.welcome();
    }

    private void userLogin() {
        System.out.println("Press 1 -->Login");
        System.out.println("Press 2 --> SignUp");
        int option = sc.nextInt();
        controllerObj.decideLogin(option);
    }

    public void newUser() {
        System.out.println("Enter username");
        String userName = sc.next();
        System.out.println("Enter password");
        String password = sc.next();
        if (controllerObj.validUser(userName, password)) {
            System.out.println("New User Login Successful");
        } else {
            System.out.println("Already Existing User");
        }
    }

    public void welcome() {
        System.out.println("------------------------ CONTACT BOOK -----------------------------------------------");
        System.out.println("Press 1 --> Add contacts");
        System.out.println("Press 2 --> Read  contacts");
        System.out.println("Press 3 --> Search Contact");
        System.out.println("Press 4 --> Delete Contact");
        System.out.println("Press 5 --> Rename or Update ");
        System.out.println("Press 9 --> Exit ");
        System.out.println("-------------------------------------------------------------------------------------------");
        int option = sc.nextInt();
        controllerObj.decideOptions(option);
    }

    @Override
    public void addContact() {
        System.out.println("Enter The Name");
        String name = sc.next();
        System.out.println("Enter The PhoneNumber");
        long phoneNumber = sc.nextLong();
        System.out.println("Enter The Address");
        String address = sc.next();
        System.out.println("Enter The Email Id ");
        String email = sc.next();
        if (controllerObj.addingContacts(name, phoneNumber, address, email))
            System.out.println("Successfully Added");
        System.out.println("--------------------------------------------------------------------------------------------");
        proceedFurther();


    }

    public void proceedFurther() {
        System.out.println("Press 1 --> To Add Another Contact");
        System.out.println("Press 2 --> Exit");
        int option = sc.nextInt();
        controllerObj.decideToProceed(option);
    }


    @Override
    public void readContact() {
        System.out.printf("%-25s", "Contacts List");
        System.out.println();
        List<Contacts> contactsList = controllerObj.readingContacts();
        if (contactsList.size() == 0) {
            System.out.println("No Contacts Available");
        } else {
            System.out.printf("%-15s%-12s%-12s%-5s", "Name", "PhoneNumber", "Address", "Email");
            System.out.println();
            for (Contacts it : contactsList) {
                System.out.printf("%-15s%-12s%-12s%-5s", it.getName(), it.getPhoneNumber(), it.getAddress(), it.getEmail());
                System.out.println();

            }
        }
        welcome();

    }

    @Override
    public void searchContact() {
        System.out.println("Enter The Name");
        String name = sc.next();
        System.out.println("Enter The PhoneNumber");
        long phoneNumber = sc.nextLong();
        Contacts search = controllerObj.searchingContact(name, phoneNumber);
        if (search == null)
            System.out.println("No Contacts Found");
        else {
            System.out.printf("%-15s%-12s%-12s%-5s", "Name", "PhoneNumber", "Address", "Email");
            System.out.println();
            System.out.printf("%-15s%-12s%-12s%-5s", search.getName(), search.getPhoneNumber(), search.getAddress(), search.getEmail());
            System.out.println();
        }
        welcome();
    }

    @Override
    public void deleteContact() {
        //displaying contacts list to delete contacts
        System.out.printf("%-25s", "Contacts List");
        System.out.println();
        List<Contacts> contactsList = controllerObj.readingContacts();
        if (contactsList.size() == 0) {
            System.out.println("No Contacts Available");
        } else {
            System.out.printf("%-15s%-12s%-12s%-5s", "Name", "PhoneNumber", "Address", "Email");
            System.out.println();
            for (Contacts it : contactsList) {
                System.out.printf("%-15s%-12s%-12s%-5s", it.getName(), it.getPhoneNumber(), it.getAddress(), it.getEmail());
                System.out.println();

            }

            System.out.println("Enter The Name");
            String name = sc.next();
            System.out.println("Enter The PhoneNumber");
            long phoneNumber = sc.nextLong();
            for (Contacts it : contactsList) {
                if (it.getName().equals(name) && it.getPhoneNumber() == phoneNumber) {
                    controllerObj.deleteContact(name, phoneNumber);
                    System.out.println("Successfully Deleted");
                }
            }
        }
        welcome();
    }


    @Override
    public void renameContact() {
        //displaying contacts list to delete contacts
        System.out.printf("%-25s", "Contacts List");
        System.out.println();
        List<Contacts> contactsList = controllerObj.readingContacts();
        if (contactsList.size() == 0) {
            System.out.println("No Contacts Available");
        } else {
            System.out.printf("%-15s%-12s%-12s%-5s", "Name", "PhoneNumber", "Address", "Email");
            System.out.println();
            for (Contacts it : contactsList) {
                System.out.printf("%-15s%-12s%-12s%-5s", it.getName(), it.getPhoneNumber(), it.getAddress(), it.getEmail());
                System.out.println();

            }
            System.out.println("To Update Enter The Below Details");
            System.out.println("Enter The Name");
            String name = sc.next();
            System.out.println("Enter The PhoneNumber");
            long phoneNumber = sc.nextLong();
            System.out.println("Enter The Address");
            String address = sc.next();
            System.out.println("Enter The Email");
            String email = sc.next();
            if (controllerObj.update(name, phoneNumber, address, email))
                System.out.println("Updated Successfully");
            else
                System.out.println("Contact Not Found");
            welcome();


        }
    }

    public void exit() {
        controllerObj.exit();
        System.out.println("-----------------------Thank you !---------------------");
    }

    @Override
    public void invalid() {
        System.out.println("Improper Input");
        proceedFurther();


    }
}
