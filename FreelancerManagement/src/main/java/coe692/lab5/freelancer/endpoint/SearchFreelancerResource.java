package coe692.lab5.freelancer.endpoint;

import coe692.lab5.freelancer.business.SearchBusiness;
import coe692.lab5.freelancer.helper.FreelancerXML;
import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import java.io.IOException;

import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * REST Web Service
 *
 * @author student
 */
@Path("freelancer")
public class SearchFreelancerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SearchUserResource
     */
    public SearchFreelancerResource() {
    }

    /**
     * Retrieves representation of an instance of
     * coe692.lab4.freelancer.endpoint.SearchFreelancerResource
     *
     * @param query
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
    public String getXml(@QueryParam("id") int id) throws ClassNotFoundException, SQLException, ServerAddressNotSuppliedException, IOException, InterruptedException {
        // Check if getXML is reading the query properly
        System.out.println("getXml: The user entered \"" + id + "\"");

        SearchBusiness search = new SearchBusiness();
        FreelancerXML freelancers = search.getFreelancersById(id);

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(FreelancerXML.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(freelancers, sw);

            return (sw.toString());

        } catch (JAXBException ex) {
            Logger.getLogger(SearchFreelancerResource.class.getName()).log(Level.SEVERE, null, ex);
            return ("Error happened");
        }
    }

    /**
     * PUT method for updating or creating an instance of SearchUserResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
        //
    }
}