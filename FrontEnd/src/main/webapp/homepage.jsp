<%@page import="coe692.lab5.helper.User"%>
<%@page import="coe692.lab5.helper.UserXML"%>
<%@page import="coe692.lab5.helper.Job"%>
<%@page import="coe692.lab5.helper.JobXML"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Random"%>
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
            <!-- Display registered user's full name and logout button-->
            <form action="homepage" method="post">
                <h1 class="fw-light">      
                    <%
                        UserXML user = (UserXML) request.getAttribute("userInfo");
                        User u = user.getUsers().get(0);
                    %>
                    Hi, <%=u.getFullName()%> <i class="fa-solid fa-user"></i>               
                    <input type="hidden" name="pageName" value="logout"/>
                    <button type="submit" class="btn btn-light btn-lg float-end">
                        <i class="fas fa-sign-out-alt"></i> Log out
                    </button>                  
                </h1>
            </form>         

            <form action="homepage" method="post">     
                <div class="card shadow-lg mb-4">
                    <div class="card-body p-5 text-center">
                        <div class="input-group rounded">
                            <input
                                name="userFilter"
                                type="search"
                                class="form-control rounded"
                                placeholder="Search for ..."
                                aria-label="Search" aria-describedby="search-addon" />
                            <span class="input-group-text border-0" id="search-addon">
                                <i class="fas fa-search"></i>
                            </span>
                        </div>                        
                    </div>                    
                    <div class="card-text mb-3 text-center">
                        <!-- Selects the different categories of freelance work -->           
                        <div class="btn-group mb-4" role="group" aria-label="Basic radio toggle button group">
                            <input class="btn-check" type="radio" name="btnradio" type="radio" id="btnradio1" value="All" autocomplete="off" checked/>
                            <label class="btn btn-outline-dark" for="btnradio1">All</label>

                            <input class="btn-check" name="btnradio" type="radio" id="btnradio2" value="Creative" autocomplete="off"/>
                            <label class="btn btn-outline-dark" for="btnradio2"><i class="fa-solid fa-paint-roller"></i> Creative</label>

                            <input class="btn-check" name="btnradio" type="radio" id="btnradio3" value="Education" autocomplete="off"/>
                            <label class="btn btn-outline-dark" for="btnradio3"><i class="fa-sharp fa-solid fa-school"></i> Education</label>

                            <input class="btn-check" name="btnradio" type="radio" id="btnradio4" value="House & Construction" autocomplete="off"/>
                            <label class="btn btn-outline-dark" for="btnradio4"><i class="fa-sharp fa-solid fa-house"></i> House & Construction</label>

                            <input class="btn-check" name="btnradio" type="radio" id="btnradio5" value="Marketing & Sales" autocomplete="off"/>
                            <label class="btn btn-outline-dark" for="btnradio5"><i class="fa-solid fa-shop"></i> Marketing & Sales</label>

                            <input class="btn-check" name="btnradio" type="radio" id="btnradio6" value="Personal Service" autocomplete="off"/>
                            <label class="btn btn-outline-dark" for="btnradio6"><i class="fa-solid fa-person-running"></i> Personal Service</label>
                        </div>
                    </div>
                    <input type="hidden" name="pageName" value="search"/>
                </div>
            </form>

            <!-- Request the job listings and list them out in a card layout below the search bar-->
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <%
                    JobXML jobs = (JobXML) request.getAttribute("jobList");
                    if (jobs != null && jobs.getJobs() != null) {
                        for (Job j : jobs.getJobs()) {
                %>
                <div class="col">
                    <div class="card h-100 shadow-md">
                        <%
                            Random rand = new Random();
                            int randomNumber = rand.nextInt(201 - 100) + 100;
                        %>
                        <img
                            src="https://mdbcdn.b-cdn.net/img/new/standard/nature/<%=randomNumber%>.webp"
                            class="mask card-img-top"/>
                        <div class="card-body">
                            <h5 class="card-title"><%=j.getJobName()%> <span class="badge bg-dark">$<%=j.getPrice()%></span></h5>
                            <p class="card-text text-truncate"><%=j.getJobDesc()%></p>

                        </div>   
                    </div>
                </div>
                <%}%>
                <%}%>
            </div>
        </div>

        <!-- Bootstrap CS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </body>
</html>
