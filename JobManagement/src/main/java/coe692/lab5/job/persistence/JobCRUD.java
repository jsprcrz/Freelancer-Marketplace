package coe692.lab5.job.persistence;

import coe692.lab5.job.helper.Job;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class JobCRUD {

    private static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connection = System.getenv("DB_URL");
            con = DriverManager.getConnection("jdbc:mysql://" + connection
                    + "/JobManagementDB?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");

            System.out.println("Connection established.");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static Set<Job> searchForAllJobs() {
        Set<Job> jobs = new HashSet<Job>();
        try {
            Connection con = getCon();

            String q = "SELECT * FROM Job;";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String jname = rs.getString("jobname");
                String jdesc = rs.getString("jobdesc");
                String jcat = rs.getString("jobcategory");
                Integer jcost = rs.getInt("jobprice");
                String location = rs.getString("locationoffered");
                String date = rs.getString("dateadded");
                Integer fId = rs.getInt("freelancerid");

                Job job = new Job(jname, jdesc, jcat, jcost, location, date, fId);
                jobs.add(job);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return jobs;
    }

    public static Set<Job> searchForJobs(String filter, String category) {
        Set<Job> jobs = new HashSet<Job>();
        try {
            Connection con = getCon();

            if (category.equals("All")) {
                String str = "SELECT * FROM Job WHERE jobname LIKE '%" + filter + "%'";
                PreparedStatement ps = con.prepareStatement(str);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String jname = rs.getString("jobname");
                    String jdesc = rs.getString("jobdesc");
                    String jcat = rs.getString("jobcategory");
                    Integer jcost = rs.getInt("jobprice");
                    String location = rs.getString("locationoffered");
                    String date = rs.getString("dateadded");
                    Integer fId = rs.getInt("freelancerid");

                    Job job = new Job(jname, jdesc, jcat, jcost, location, date, fId);
                    jobs.add(job);
                }
            } else {
                String str = "SELECT * FROM Job WHERE jobcategory LIKE '" + category + "' AND jobname LIKE '%" + filter + "%'";
                PreparedStatement ps = con.prepareStatement(str);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String jname = rs.getString("jobname");
                    String jdesc = rs.getString("jobdesc");
                    String jcat = rs.getString("jobcategory");
                    Integer jcost = rs.getInt("jobprice");
                    String location = rs.getString("locationoffered");
                    String date = rs.getString("dateadded");
                    Integer fId = rs.getInt("freelancerid");

                    Job job = new Job(jname, jdesc, jcat, jcost, location, date, fId);
                    jobs.add(job);
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return jobs;
    }

    public static Set<Job> searchFreelancerIDJob(int id) {
        Set<Job> jobs = new HashSet<Job>();
        try {
            Connection con = getCon();

            String q = "SELECT * FROM Job WHERE freelancerid='" + id + "';";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String jname = rs.getString("jobname");
                String jdesc = rs.getString("jobdesc");
                String jcat = rs.getString("jobcategory");
                Integer jcost = rs.getInt("jobprice");
                String location = rs.getString("locationoffered");
                String date = rs.getString("dateadded");
                Integer fId = rs.getInt("freelancerid");

                Job job = new Job(jname, jdesc, jcat, jcost, location, date, fId);
                jobs.add(job);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return jobs;
    }
}
