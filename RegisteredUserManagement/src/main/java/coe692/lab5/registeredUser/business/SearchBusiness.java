package coe692.lab5.registeredUser.business;

import coe692.lab5.registeredUser.helper.UserXML;
import coe692.lab5.registeredUser.helper.User;
import coe692.lab5.registeredUser.persistence.UserCRUD;

import static java.lang.System.in;
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

    public UserXML getUsersByQuery(String query) {
        // Check if getUsersByQuery is reading the query properly
        System.out.println("getUsersByQuery: The user entered \"" + query + "\"");

        Set<User> users = UserCRUD.searchForUsers(query);
        Map<String, User> allUsers = new HashMap();      
        for (User us : users) {            
            allUsers.put(us.getFullName(), us);
        }
        UserXML us = new UserXML();
        us.setUsers(new ArrayList(allUsers.values()));
        return (us);
    }
    
        public UserXML getUsersByQuery(String username, String password) {
        // Check if getUsersByQuery is reading the query properly
        System.out.println("getUsersByQuery: The user entered \"" + username + "\" and \"" + password + "\"" );

        Set<User> users = UserCRUD.read(username, password);
        Map<String, User> allUsers = new HashMap();      
        for (User us : users) {            
            allUsers.put(us.getFullName(), us);
        }
        UserXML us = new UserXML();
        us.setUsers(new ArrayList(allUsers.values()));
        return (us);
    }
}
