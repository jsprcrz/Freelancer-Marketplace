package coe692.lab5.business;

import coe692.lab5.helper.Freelancer;
import coe692.lab5.helper.FreelancerXML;

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

public class FreelancerBusiness {

    public static FreelancerXML getFreelancerById(int id) throws IOException {
        Client searchClient = ClientBuilder.newClient();
        String freelancerService = System.getenv("freelancerService");
        WebTarget searchwebTarget
                = searchClient.target("http://" + freelancerService
                        + "/FreelancerManagement/webresources/freelancer/");
        InputStream is
                = searchwebTarget
                        .queryParam("id", id)
                        .request(MediaType.APPLICATION_XML).get(InputStream.class);

        String xml = IOUtils.toString(is, "utf-8");
        FreelancerXML freelancers = freelancerXmlToObjects(xml);

        return freelancers;
    }

    private static FreelancerXML freelancerXmlToObjects(String xml) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(FreelancerXML.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            FreelancerXML freelancers = (FreelancerXML) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return freelancers;

        } catch (JAXBException e) {
            System.out.println(e);
        }
        return null;
    }

    private static Freelancer freelancerToObjects(String xml) {
        if (xml.isEmpty()) {
            return null;
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Freelancer.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Freelancer freelancer = (Freelancer) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return freelancer;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
