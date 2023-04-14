package coe692.lab5.business;

import coe692.lab5.helper.User;
import coe692.lab5.helper.UserXML;

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

public class UserBusiness {

    public static boolean isAuthenticated(String username, String password) {
        try {
            Client searchClient = ClientBuilder.newClient();
            String userService = System.getenv("userService");
            WebTarget verifyUsers
                    = searchClient.target("http://" + userService
                            + "/RegisteredUserManagement/webresources/login/");
            InputStream is
                    = verifyUsers
                            .queryParam("userText", username)
                            .queryParam("userPassword", password)
                            .request(MediaType.APPLICATION_XML).get(InputStream.class);

            String xml = IOUtils.toString(is, "utf-8");
            UserXML user = userXmlToObjects(xml);
            if (user != null && user.getUsers() != null && user.getUsers().size() > 0) {
                for (User u : user.getUsers()) {
                    if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static UserXML getServices(String username, String password, String token) throws IOException {
        Client searchClient = ClientBuilder.newClient();
        String userService = System.getenv("userService");
        WebTarget verifyUsers
                = searchClient.target("http://" + userService
                        + "/RegisteredUserManagement/webresources/login/");
        InputStream is
                = verifyUsers
                        .queryParam("userText", username)
                        .queryParam("userPassword", password)
                        .request(MediaType.APPLICATION_XML).get(InputStream.class);

        String xml = IOUtils.toString(is, "utf-8");
        UserXML users = userXmlToObjects(xml);

        return users;
    }

    private static UserXML userXmlToObjects(String xml) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(UserXML.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            UserXML users = (UserXML) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return users;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static User userToObjects(String xml) {
        if (xml.isEmpty()) {
            return null;
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(User.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            User user = (User) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return user;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
