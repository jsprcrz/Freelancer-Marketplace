package coe692.lab5.job.endpoint;

import coe692.lab5.job.business.SearchBusiness;
import coe692.lab5.job.helper.JobXML;

import java.io.StringWriter;
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
@Path("job/")
public class SearchJobResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SearchJobResource
     */
    public SearchJobResource() {
    }

    /**
     * Retrieves representation of an instance of
     * coe692.lab4.job.endpoint.SearchJobResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
    public String getXml(@QueryParam("userFilter") String filter, @QueryParam("btnradio") String category) {
        SearchBusiness search = new SearchBusiness();
        JobXML jobs;
        if (filter.isEmpty() && category.isEmpty()) {
            jobs = search.getAllJobs();
        } else {
            jobs = search.getJobsByQuery(filter, category);
        }

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(JobXML.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(jobs, sw);

            return (sw.toString());

        } catch (JAXBException ex) {
            Logger.getLogger(SearchJobResource.class.getName()).log(Level.SEVERE, null, ex);
            return ("Error happened");
        }
    }

    /**
     * PUT method for updating or creating an instance of SearchJobResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
        //
    }
}
