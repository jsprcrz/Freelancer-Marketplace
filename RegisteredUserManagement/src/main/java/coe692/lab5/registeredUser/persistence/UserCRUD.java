package coe692.lab5.registeredUser.persistence;

import coe692.lab5.registeredUser.helper.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class UserCRUD {

    private static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connection = System.getenv("DB_URL");
            con = DriverManager.getConnection("jdbc:mysql://" + connection
                    + "/UserManagementDB?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");

            System.out.println("Connection established.");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    // Searches User table using query to filter first and last name
    public static Set<User> searchForUsers(String query) {
        Set<User> users = new HashSet<User>();
        try {
            Connection con = getCon();

            String q = "SELECT * FROM RegisteredUser WHERE firstname LIKE '%" + query + "%'"
                    + " OR lastname LIKE '%" + query + "%';";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String uname = rs.getString("username");
                String pword = rs.getString("password");

                String fname = rs.getString("firstname");
                String lname = rs.getString("lastname");
                String pnumber = rs.getString("phonenumber");
                String email = rs.getString("email");

                // Create a new instance of user and add it to HashSet
                User u = new User(uname, pword, fname, lname, pnumber, email);
                users.add(u);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return users;
    }

    // Read registered user's info and create an instance of User
    public static Set<User> read(String username, String password) {
        Set<User> users = new HashSet<User>();
        try {
            Connection con = getCon();

            String str1 = "SELECT * FROM RegisteredUser WHERE username LIKE '" + username + "'";
            PreparedStatement ps = con.prepareStatement(str1);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String uname = rs.getString("username");
                String pword = rs.getString("password");

                String fname = rs.getString("firstname");
                String lname = rs.getString("lastname");
                String pnumber = rs.getString("phonenumber");
                String email = rs.getString("email");

                if (uname.equals(username) && pword.equals(password)) {
                    User u = new User(username, password, fname, lname, pnumber, email);
                    users.add(u);

                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return users;
    }
}
