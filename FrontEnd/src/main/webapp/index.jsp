<!DOCTYPE html>
<html lang="en">
    <head>        
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <title>Freelancer Network</title>

        <!-- Font Awesome (Icons) -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/> 
        <!-- Roboto Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap"/>
        <!-- Bootstrap CS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

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
            <div class="card-title p-5">
                <h1 class="mb-3 fw-bold">
                    <b>Welcome to </b>
                    <span class="text-primary fw-bold">Freelancer Network</span>
                </h1>
                <p class="fw-light" style="color: gray">
                    Bridging the gap between talented freelancers and businesses seeking
                    their services
                </p>
            </div>

            <form action="homepage" method="post">
                <div class="card shadow-lg" style="border-radius: 1rem">
                    <div class="card-body p-5">
                        <!-- Email address input -->
                        <div class="form-outline mb-4">
                            <label class="form-label"><b>Username</b></label>
                            <input
                                class="form-control"
                                name="userText"
                                type="text"                                
                                placeholder="Enter username"
                                />
                        </div>

                        <!-- Password input -->
                        <div class="form-outline mb-5">
                            <label class="form-label"><b>Password</b></label>
                            <div class="input-group">
                                <input
                                    class="form-control"
                                    name="userPassword"
                                    type="password"                               
                                    placeholder="Enter password"
                                    />                              
                            </div>
                        </div>

                        <!-- Submit button -->
                        <div class="text-center">
                            <input type="hidden" name="pageName" value="login"/>
                            <button type="submit" class="btn btn-dark btn-md rounded-pill">
                                Sign In
                            </button>
                        </div>
                    </div>
                </div>
            </form>           
        </div>

        <% if (request.getAttribute("error") != null) { %>
        <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
            <div class="toast show" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="toast-header">
                    <strong class="me-auto">Warning</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>

                <div class="toast-body">
                    The username or password is incorrect.
                </div>
            </div>
        </div>
        <%}%>

        <!-- Bootstrap JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>
