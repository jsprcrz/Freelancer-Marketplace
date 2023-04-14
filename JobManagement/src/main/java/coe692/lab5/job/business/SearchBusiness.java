package coe692.lab5.job.business;

import coe692.lab5.job.helper.JobXML;
import coe692.lab5.job.helper.Job;
import coe692.lab5.job.persistence.JobCRUD;
import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import java.io.IOException;

import static java.lang.System.in;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

public class SearchBusiness {

    public JobXML getAllJobs() {
        Set<Job> jobs = JobCRUD.searchForAllJobs();
        ArrayList<Job> arr = new ArrayList<Job>();
        for (Job jb : jobs) {
            arr.add(jb);
        }
        JobXML jb = new JobXML();
        jb.setJobs(arr);
        return (jb);
    }

    public JobXML getJobsByQuery(String filter, String category) {
        System.out.println("getJobsByQuery: The user entered filter: \"" + filter + "\" and category:" + category + "\"");

        Set<Job> jobs = JobCRUD.searchForJobs(filter, category);
        ArrayList<Job> arr = new ArrayList<Job>();
        for (Job jb : jobs) {
            arr.add(jb);
        }
        JobXML jb = new JobXML();
        jb.setJobs(arr);
        return (jb);
    }
}
