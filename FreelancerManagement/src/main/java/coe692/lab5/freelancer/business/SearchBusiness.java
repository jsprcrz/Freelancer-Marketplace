package coe692.lab5.freelancer.business;

import coe692.lab5.freelancer.business.Messaging;
import coe692.lab5.freelancer.helper.FreelancerXML;
import coe692.lab5.freelancer.helper.Freelancer;
import coe692.lab5.freelancer.persistence.FreelancerCRUD;

import java.util.ArrayList;
import java.util.Set;
import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import java.io.IOException;
import java.sql.SQLException;

public class SearchBusiness {

    public FreelancerXML getFreelancersByQuery(String query)
            throws ClassNotFoundException, SQLException, ServerAddressNotSuppliedException, IOException, InterruptedException {
        // Check if getUsersByQuery is reading the query properly
        System.out.println("getUsersByQuery: The user entered \"" + query + "\"");

        Set<Freelancer> freelancers = FreelancerCRUD.searchForFreelancers(query);
        ArrayList<Freelancer> arr = new ArrayList<Freelancer>();
        for (Freelancer fl : freelancers) {
            arr.add(fl);
        }
        FreelancerXML fl = new FreelancerXML();
        fl.setFreelancer(arr);

        Messaging.sendmessage("Query:" + query);

        return (fl);
    }

    public FreelancerXML getFreelancersById(int id)
            throws ClassNotFoundException, SQLException, ServerAddressNotSuppliedException, IOException, InterruptedException {
        // Check if getUsersByQuery is reading the query properly
        System.out.println("getUsersByQuery: The user entered \"" + id + "\"");

        Freelancer worker = FreelancerCRUD.searchById(id);
        ArrayList<Freelancer> arr = new ArrayList<Freelancer>();
        arr.add(worker);
        FreelancerXML fl = new FreelancerXML();
        fl.setFreelancer(arr);

        Messaging.sendmessage("ID:" + id);        

        return (fl);
    }
}
