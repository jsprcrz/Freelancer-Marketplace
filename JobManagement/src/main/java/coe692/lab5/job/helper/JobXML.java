package coe692.lab5.job.helper;

import coe692.lab5.job.helper.Job;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "jobs")
@XmlAccessorType(XmlAccessType.FIELD)
public class JobXML {

    @XmlElement(name = "job")
    private ArrayList<Job> jobs;

    public JobXML() {
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<Job> jb) {
        jobs = jb;
    }
}
