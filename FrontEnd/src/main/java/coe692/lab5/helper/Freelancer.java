package coe692.lab5.helper;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "freelancer")
@XmlType(propOrder = {"freelancerId", "username", "password", "firstName", "lastName", "email", "phoneNumber", "streetAddress"})
public class Freelancer {

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String streetAddress;

    private int freelancerId;

    private ArrayList<Job> offeredJobs = new ArrayList<Job>();

    public Freelancer() {
    }

    public Freelancer(String name, String pass, String fname, String lname, String pnumber, String email, String addr, int id) {
        username = name;
        password = pass;
        firstName = fname;
        lastName = lname;
        emailAddress = email;
        phoneNumber = pnumber;
        streetAddress = addr;
        freelancerId = id;
    }

    @XmlElement(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        username = name;
    }

    @XmlElement(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        password = pass;
    }

    @XmlElement(name = "firstNasme")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fname) {
        firstName = fname;
    }

    @XmlElement(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lname) {
        lastName = lname;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @XmlElement(name = "email")
    public String getEmail() {
        return emailAddress;
    }

    public void setEmail(String email) {
        emailAddress = email;
    }

    @XmlElement(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String pnumber) {
        phoneNumber = pnumber;
    }

    @XmlElement(name = "streetAddress")
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String addr) {
        streetAddress = addr;
    }

    @XmlElement(name = "freelancerId")
    public int getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(int id) {
        freelancerId = id;
    }

    public ArrayList<Job> getOfferedJobs() {
        return offeredJobs;
    }

    public void addJob(Job j) {
        offeredJobs.add(new Job(j.getJobName(), j.getJobDesc(), j.getJobCategory(), j.getPrice(), j.getJobLocation(), j.getDateCreated(), j.getFreelancerId()));
    }

    public void removeJob(Job j) {
        offeredJobs.remove(j);
    }
}
