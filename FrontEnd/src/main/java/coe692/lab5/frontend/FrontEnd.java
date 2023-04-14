package coe692.lab5.frontend;

import coe692.lab5.helper.UserXML;
import coe692.lab5.helper.FreelancerXML;
import coe692.lab5.helper.JobXML;
import coe692.lab5.business.JobBusiness;
import coe692.lab5.business.UserBusiness;
import coe692.lab5.business.FreelancerBusiness;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Marketplace", urlPatterns = {"/homepage"})
public class FrontEnd extends HttpServlet {

    Authenticate autho;

    public FrontEnd() {
        autho = new Authenticate();
    }
    private final String authenticationCookieName = "login_token";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String token = isAuthenticated(request).getKey();
        String uname = isAuthenticated(request).getValue();
        String hiddenParam = request.getParameter("pageName");

        switch (hiddenParam) {
            case "login":
                // Retrive username and password from index.html
                String username = (String) request.getParameter("userText");
                String password = (String) request.getParameter("userPassword");

                boolean isAuthenticated = UserBusiness.isAuthenticated(username, password);
                if (isAuthenticated) {
                    // User is authenticated
                    request.setAttribute("error", null);
                    request.setAttribute("userText", username);
                    token = autho.createJWT("FrontEnd", username, 100000);

                    Cookie newCookie = new Cookie(authenticationCookieName, token);
                    response.addCookie(newCookie);

                    // Obtain XML representation of users with matching username and password 
                    UserXML result = retreiveUsersFromBackend(username, password, token);
                    request.setAttribute("userInfo", result);

                    // Obtain XML representation of all jobs 
                    JobXML listings = retrieveJobsFromBackend();
                    request.setAttribute("jobList", listings);

                    RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
                    rd.forward(request, response);
                } else {
                    // User is not authenticated
                    request.setAttribute("error", "true");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
                break;
            case "search":
                // Search jobs by filter and category
                String filter = (String) request.getParameter("userFilter");
                String category = (String) request.getParameter("btnradio");

                JobXML listings = retrieveJobsFromBackend(filter, category);
                request.setAttribute("jobList", listings);

                RequestDispatcher sr = request.getRequestDispatcher("search.jsp");
                sr.forward(request, response);
                break;
            case "hire":
                // Hire freelancer by getting freelancer ID
                String quantityParam = request.getParameter("freelancerId");
                int fId = Integer.parseInt(quantityParam);

                FreelancerXML hiredFl = retrieveFreelancerFromBackend(fId);
                request.setAttribute("freelancersInfo", hiredFl);

                JobXML addJobsToFreelancer = retrieveJobsFromBackend();
                request.setAttribute("queryJobs", addJobsToFreelancer);

                RequestDispatcher hr = request.getRequestDispatcher("hired.jsp");
                hr.forward(request, response);
                break;
            case "logout":
                // Logout from homepage
                RequestDispatcher lg = request.getRequestDispatcher("index.jsp");
                lg.forward(request, response);
        }
    }

    private Map.Entry<String, String> isAuthenticated(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String token = "";

        System.out.println("TOKEN IS");
        try {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                if (cookie.getName().equals(authenticationCookieName)) {
                    token = cookie.getValue();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        if (!token.isEmpty())
           try {
            Entry<Boolean, String> verification = autho.verify(token);
            if (verification.getKey()) {
                Map.Entry entry = new AbstractMap.SimpleEntry<String, String>(token, verification.getValue());
                return entry;

            } else {
                Map.Entry entry = new AbstractMap.SimpleEntry<String, String>("", "");
                return entry;
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
        }

        Map.Entry entry = new AbstractMap.SimpleEntry<String, String>("", "");
        return entry;
    }

    private UserXML retreiveUsersFromBackend(String username, String password, String token) {
        try {
            return (UserBusiness.getServices(username, password, token));
        } catch (IOException ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
            return (null);
        }
    }

    private JobXML retrieveJobsFromBackend() {
        try {
            return (JobBusiness.getAllJobs());
        } catch (IOException ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
            return (null);
        }
    }

    private JobXML retrieveJobsFromBackend(String filter, String category) {
        try {
            return (JobBusiness.getJobsByQuery(filter, category));
        } catch (IOException ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
            return (null);
        }
    }

    private FreelancerXML retrieveFreelancerFromBackend(int id) {
        try {
            return (FreelancerBusiness.getFreelancerById(id));
        } catch (IOException ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
            return (null);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
