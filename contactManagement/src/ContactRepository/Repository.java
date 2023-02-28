package ContactRepository;

import dto.Contacts;
import dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    static Connection sql = null;
    static Statement st = null;
    static final String driver = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/contact";
    static final String user = "root";
    static final String pass = "Akshaya6574";
    private static Repository repositoryObj;
    List<User> userList = new ArrayList<>();
//    List<Contacts> contactsList=new ArrayList<>();

    public Repository() {

    }

    public static Repository getInstance() {
        if (repositoryObj == null) {
            repositoryObj = new Repository();
            repositoryObj.initialSetup();
            try {
                Class.forName(driver);
                sql = DriverManager.getConnection(url, user, pass);
                st = sql.createStatement();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {

            }
        }
        return repositoryObj;
    }

    public void initialSetup() {
        userList.add(new User("akshaya", "akshi"));
    }

    public boolean validUser(String userName, String password) {
        for (User it : userList) {
            if (it.getUserName().equals(userName) && it.getPassword().equals(password)) return false;
        }
        return userList.add(new User(userName, password));
    }

    public boolean addingContacts(String name, long phoneNumber, String address, String email) {
//        return contactsList.add(new Contacts(name,phoneNumber,address,email));
        try {
            String insert = "INSERT INTO contact_list VALUES(\"" + name + "\"," + phoneNumber + ",\"" + address + "\",\"" + email + "\")";
            st.execute(insert);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<Contacts> readingContacts() {
//        return  contactsList;
        List<Contacts> contactsList = new ArrayList<>();
        try {
            String search = "SELECT * FROM contact_list";
            ResultSet result = st.executeQuery(search);
            while (result.next()) {
                Contacts contactsObj = new Contacts(result.getString("name"), result.getLong("phoneNumber"), result.getString("address"), result.getString("email"));
                contactsList.add(contactsObj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactsList;
    }

    public Contacts searchingContact(String name, long phoneNumber) {
//        for(Contacts it:contactsList)
//        {
//            if(it.getName().equals(name)&&it.getPhoneNumber()==phoneNumber)
//                return it;
//        }
//        return null;
        try {
            String search = "SELECT * FROM contact_list WHERE name=\"" + name + "\" and phoneNumber=" + phoneNumber;
            ResultSet result = st.executeQuery(search);
            while (result.next()) {
                return new Contacts(result.getString("name"), result.getLong("phoneNumber"), result.getString("address"), result.getString("email"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(String name, long phoneNumber, String address, String email) {
//        for(Contacts it:contactsList)
//        {
//            if(it.getName().equals(name)||it.getPhoneNumber()==phoneNumber||it.getEmail().equals(email)||it.getPhoneNumber()==phoneNumber||it.getAddress().equals(address))
//            {
//               it.setName(name);
//               it.setPhoneNumber(phoneNumber);
//               it.setEmail(email);
//               it.setAddress(address);
//               return true;
//
//            }
//
//
//        }
//
//        return false;
//    }
        try {
            String search = "update contact_list set name=\"" + name + "\",phoneNumber=" + phoneNumber + ",address=\"" + address + "\",email=\"" + email + "\" where phoneNumber=" + phoneNumber;
            st.execute(search);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    public void deleteContact(String name, long phoneNumber) {
        try {
            String delete = "delete from contact_list where name=\"" + name + "\" and phoneNumber=" + phoneNumber;
            st.execute(delete);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void exit() {
        try {
            st.close();
            sql.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


