package coe692.lab5.registeredUser.endpoint;

import coe692.lab5.registeredUser.business.SearchBusiness;
import coe692.lab5.registeredUser.helper.UserXML;

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
@Path("login/")
public class SearchUserResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SearchUserResource
     */
    public SearchUserResource() {
    }

    /**
     * Retrieves representation of an instance of
     * coe692.lab4.registeredUser.endpoint.SearchUserResource
     *
     * @param query
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
    public String getXml(@QueryParam("userText") String username, @QueryParam("userPassword") String password) {
        // Check if getXML is reading the query properly
        System.out.println("getUsersByQuery: The user entered \"" + username + "\" and \"" + password + "\"" );
        
        SearchBusiness search = new SearchBusiness();
        UserXML users = search.getUsersByQuery(username, password); 

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(UserXML.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(users, sw);

            return (sw.toString());

        } catch (JAXBException ex) {
            Logger.getLogger(SearchUserResource.class.getName()).log(Level.SEVERE, null, ex);
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
