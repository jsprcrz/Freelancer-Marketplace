package coe692.lab5.freelancer.helper;

import coe692.lab5.freelancer.helper.Freelancer;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "freelancers")
@XmlAccessorType(XmlAccessType.FIELD)
public class FreelancerXML {

    @XmlElement(name = "freelancer")
    private ArrayList<Freelancer> freelancers;

    public FreelancerXML() {
    }

    public List<Freelancer> getFreelancers() {
        return freelancers;
    }

    public void setFreelancer(ArrayList<Freelancer> fl) {
        freelancers = fl;
    }
}
