package coe692.lab5.helper;

import coe692.lab5.helper.User;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserXML {

    @XmlElement(name = "user")
    private ArrayList<User> users;

    public UserXML() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> us) {
        users = us;
    }
}
