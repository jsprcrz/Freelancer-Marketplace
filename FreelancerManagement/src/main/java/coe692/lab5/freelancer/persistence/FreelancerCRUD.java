package coe692.lab5.freelancer.persistence;

import coe692.lab5.freelancer.helper.Freelancer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class FreelancerCRUD {

    private static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connection = System.getenv("DB_URL");
            con = DriverManager.getConnection("jdbc:mysql://" + connection
                    + "/FreelancerManagementDB?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");

            System.out.println("Connection established.");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    // Searches Freelancer table using query to filter first and last name
    public static Set<Freelancer> searchForFreelancers(String query) {
        Set<Freelancer> freelancers = new HashSet<Freelancer>();
        try {
            Connection con = getCon();

            String q = "SELECT * FROM Freelancer WHERE firstname LIKE '%" + query + "%'"
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
                String addr = rs.getString("address");
                Integer fId = rs.getInt("freelancerid");

                // Create a new instance of freelancer and add it to HashSet
                Freelancer f = new Freelancer(uname, pword, fname, lname, pnumber, email, addr, fId);
                freelancers.add(f);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return freelancers;
    }

    // Searches freelancer by id
    public static Freelancer searchById(int id) {
        Freelancer fl = null;
        try {
            Connection con = getCon();

            String q = "SELECT * FROM Freelancer WHERE freelancerid LIKE '%" + id + "%';";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String uname = rs.getString("username");
                String pword = rs.getString("password");
                String fname = rs.getString("firstname");
                String lname = rs.getString("lastname");
                String pnumber = rs.getString("phonenumber");
                String email = rs.getString("email");
                String addr = rs.getString("address");
                Integer fId = rs.getInt("freelancerid");

                // Create a new instance of freelancer and add it to HashSet
                fl = new Freelancer(uname, pword, fname, lname, pnumber, email, addr, fId);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return fl;
    }
}
