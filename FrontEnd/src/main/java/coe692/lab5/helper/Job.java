package coe692.lab5.helper;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "job")
@XmlType(propOrder = {"freelancerId", "jobName", "jobCategory", "price", "jobDesc", "jobLocation", "dateCreated"})
public class Job {

    private String jobName;
    private String jobDesc;

    private String jobCategory;
    private int jobPrice;
    private String jobLocation;
    private String dateCreated;

    private int freelancerId;

    public Job() {
    }

    public Job(String name, String desc, String cat, int cost, String loc, String date, int id) {
        jobName = name;
        jobDesc = desc;
        jobCategory = cat;
        jobPrice = cost;
        jobLocation = loc;
        dateCreated = date;
        freelancerId = id;
    }

    @XmlElement(name = "jobName")
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String name) {
        jobName = name;
    }

    @XmlElement(name = "jobDesc")
    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String desc) {
        jobDesc = desc;
    }

    @XmlElement(name = "jobCategory")
    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String cat) {
        jobCategory = cat;
    }

    @XmlElement(name = "price")
    public int getPrice() {
        return jobPrice;
    }

    public void setPrice(int cost) {
        jobPrice = cost;
    }

    @XmlElement(name = "jobLocation")
    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String loc) {
        jobLocation = loc;
    }

    @XmlElement(name = "dateCreated")
    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String date) {
        dateCreated = date;
    }

    @XmlElement(name = "freelancerId")
    public int getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(int id) {
        freelancerId = id;
    }
}
