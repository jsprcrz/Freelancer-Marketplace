package coe692.lab5.business;

import coe692.lab5.helper.Job;
import coe692.lab5.helper.JobXML;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.io.IOUtils;

public class JobBusiness {

    public static JobXML getAllJobs() throws IOException {
        Client searchClient = ClientBuilder.newClient();
        String jobService = System.getenv("jobService");
        WebTarget searchwebTarget
                = searchClient.target("http://" + jobService
                        + "/JobManagement/webresources/job/");
        InputStream is
                = searchwebTarget
                        .queryParam("userFilter", "")
                        .queryParam("btnradio", "")
                        .request(MediaType.APPLICATION_XML).get(InputStream.class);

        String xml = IOUtils.toString(is, "utf-8");
        JobXML jobs = jobXmlToObjects(xml);

        return jobs;
    }

    public static JobXML getJobsByQuery(String filter, String category) throws IOException {
        Client searchClient = ClientBuilder.newClient();
        String jobService = System.getenv("jobService");
        WebTarget searchwebTarget
                = searchClient.target("http://" + jobService
                        + "/JobManagement/webresources/job/");
        InputStream is
                = searchwebTarget
                        .queryParam("userFilter", filter)
                        .queryParam("btnradio", category)
                        .request(MediaType.APPLICATION_XML).get(InputStream.class);

        String xml = IOUtils.toString(is, "utf-8");
        JobXML jobs = jobXmlToObjects(xml);

        return jobs;
    }

    private static JobXML jobXmlToObjects(String xml) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(JobXML.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            JobXML jobs = (JobXML) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return jobs;

        } catch (JAXBException e) {
            System.out.println(e);
        }
        return null;
    }

    private static Job jobToObjects(String xml) {
        if (xml.isEmpty()) {
            return null;
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Job.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Job job = (Job) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return job;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
