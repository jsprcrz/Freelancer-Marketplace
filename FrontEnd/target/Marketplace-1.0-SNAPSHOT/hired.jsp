<%@page import="coe692.lab5.helper.Freelancer"%>
<%@page import="coe692.lab5.helper.FreelancerXML"%>
<%@page import="coe692.lab5.helper.Job"%>
<%@page import="coe692.lab5.helper.JobXML"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1,
              shrink-to-fit=no"/>
        <title>Profile</title>

        <!-- Font Awesome (Icons) -->
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/>
        <!-- Roboto Font -->
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap"/>
        <!-- Bootstrap CS -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous">

        <!-- Custom styles -->
        <style>
            body {
                position: relative;
                background-color: whitesmoke;
            }
        </style>
    </head>   
    <body>

        <div class="container py-5">
            <!-- Button to go back to homepage.jsp -->
            <button
                type="button"
                class="btn btn-dark btn-floating btn-md"
                onclick="history.back()">
                <i class="fa-sharp fa-solid fa-arrow-left"></i> Back
            </button>

            <!-- Request the freelancer's info and all of the jobs to query from -->
            <%
                FreelancerXML freelancers = (FreelancerXML) request.getAttribute("freelancersInfo");
                JobXML jobs = (JobXML) request.getAttribute("queryJobs");

                Freelancer f = freelancers.getFreelancers().get(0);

                // Add the following jobs to the respective freelancer
                if (jobs != null && jobs.getJobs() != null) {
                    for (Job j : jobs.getJobs()) {
                        if (f.getFreelancerId() == j.getFreelancerId()) {
                            f.addJob(j);
                        }
                    }
                }
            %>  
            <div class="row my-3">
                <div class="col-lg-4">

                    <!-- Profile -->
                    <div class="card mb-4">
                        <div class="card-body text-center">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava<%=f.getFreelancerId()%>.webp" alt="avatar"
                                 class="rounded-circle img-fluid" style="width: 150px;">
                            <h5 class="my-3">@<%=f.getUsername()%></h5>
                            <p class="text-muted mb-4"></p>
                            <div class="d-flex justify-content-center mb-2">
                                <button type="button" class="btn btn-primary">Follow</button>
                                <button type="button" class="btn btn-outline-primary ms-1">Send message</button>
                            </div>
                        </div>
                    </div>

                    <!-- Social Media Icons -->
                    <div class="card mb-4 mb-lg-0">
                        <div class="card-body p-0">
                            <ul class="list-group list-group-flush rounded-3">
                                <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                    <i class="fas fa-globe fa-lg text-warning"></i>
                                    <a href="#" class="mb-0">https://example.com</a>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                    <i class="fab fa-github fa-lg" style="color: #333333;"></i>
                                    <a href="#" class="mb-0">Github</a>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                    <i class="fab fa-twitter fa-lg" style="color: #55acee;"></i>
                                    <a href="#" class="mb-0">Twitter</a>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                    <i class="fab fa-instagram fa-lg" style="color: #ac2bac;"></i>
                                    <a href="#" class="mb-0">Instagram</a>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                    <i class="fab fa-facebook-f fa-lg" style="color: #3b5998;"></i>
                                    <a href="#" class="mb-0">Facebook</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8">
                    <!-- Display freelancer's info -->
                    <div class="card mb-4">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Full Name</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0"><%=f.getFullName()%></p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Email</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0"><%=f.getEmail()%></p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Phone</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0"><%=f.getPhoneNumber()%></p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Address</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0"><%=f.getStreetAddress()%></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Display freelancer's offered jobs -->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card mb-4 mb-md-0">
                                <div class="card-body">
                                    <p class="mb-4"><span class="text-primary font-italic me-1">Jobs</span> Project Status</p>
                                    <%
                                        Random rand = new Random();
                                        if (f.getOfferedJobs() != null) {
                                            for (Job j : f.getOfferedJobs()) {
                                                // Generate a random number to display status from 0 to 100
                                                int randomNumber = rand.nextInt(101);
                                    %>
                                    <p class="mb-1 my-3 text-muted"><%=j.getJobName()%></p>
                                    <div class="progress rounded" style="height: 5px;">
                                        <div class="progress-bar" role="progressbar" style="width: <%=randomNumber%>%" aria-valuenow="80"
                                             aria-valuemin="0" aria-valuemax="100"></div></div>
                                        <%}%>
                                        <%}%>
                                </div>
                            </div>                       
                        </div>
                    </div>
                </div>
            </div>   

            <!-- Bootstrap CS -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>
</html>
