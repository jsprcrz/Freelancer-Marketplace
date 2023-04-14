<%@page import="coe692.lab5.helper.Job"%>
<%@page import="coe692.lab5.helper.JobXML"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1,
              shrink-to-fit=no"/>
        <title>Search</title>

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

            <!-- Request the job listings and list them out in a row -->
            <%
                JobXML jobs = (JobXML) request.getAttribute("jobList");
                if (jobs != null && jobs.getJobs() != null) {
                    for (Job j : jobs.getJobs()) {
            %>
            <div class="card my-3">
                <div class="row g-0">                    
                    <div class="col-md-2">
                        <img
                            src="https://st3.depositphotos.com/6672868/13701/v/600/depositphotos_137014128-stock-illustration-user-profile-icon.jpg"
                            class="img-fluid rounded"
                            style="width:100%; height:100%; object-fit: cover">
                    </div>
                    <div class="col-md-10">
                        <div class="card-body">       
                            <!-- Display the job's name, cost, category, location, and desc -->
                            <h5 class="card-title"><%=j.getJobName()%> <span class="badge bg-dark">$<%=j.getPrice()%></span> </h5>
                            <h6 class="card-subtitle mb-2 text-muted"><%=j.getJobCategory()%> | <%=j.getJobLocation()%></h6>
                            <p class="card-text"><%=j.getJobDesc()%></p>

                            <form action="homepage" method="post">   
                                <input type="hidden" name="pageName" value="hire"/>
                                <input type="hidden" name="freelancerId" value="<%=j.getFreelancerId()%>"/>
                                <button type="submit" class="btn btn-dark btn-md">
                                    Hire Me
                                </button>                                                               
                            </form>
                        </div>                                                    

                        <div class="card-footer">
                            <p class="card-text"><small class="text-muted">Posted on <%=j.getDateCreated()%></small></p>
                        </div>
                    </div>                    
                </div>
            </div>
            <%}%>
            <%} else {%>
            <div class="my-5">                        
                <p class="text-muted">Sorry, no freelancers match your search criteria</p>
            </div>
            <%}%>

            <% if (request.getAttribute("notif") != null) { %>
            <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
                <div class="toast show" role="alert" aria-live="assertive" aria-atomic="true">
                    <div class="toast-header">
                        <strong class="me-auto">Hiring Confirmation</strong>
                        <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                    </div>

                    <div class="toast-body">
                        Congratulations! You have successfully hired a freelancer. 
                    </div>
                </div>
            </div>
            <%}%>
        </div>

        <!-- Bootstrap CS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>
</html>