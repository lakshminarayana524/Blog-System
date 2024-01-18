   <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <base href="${pageContext.request.contextPath}/">
    <!-- Other head elements -->


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Include Font Awesome CSS for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        /* Reset default margin and padding */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            
        }

        /* Body styles */
        .bodynav {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            position:fixes	;
        }

        /* Navbar styles */
        .navbar {
            background-color: rgba(246, 240, 240, 0.7); /* Transparent black background */
            color: #fff;
            padding: 10px 0;
        }

        /* containernav styles */
        .containernav {
            display: flex;
            justify-content: space-between;
            align-items: center;
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
            height: 100px;
        }

        /* Logo styles */
        .logo {
            text-decoration: none;
            font-size: 24px;
            font-weight: bold;
            color: #000000;
            margin-right:300px;
            order: 1; /* Moves the logo to the leftmost position */
        }

        /* Menu styles */
        .menu {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            justify-content:space-around; /* Add this line to space menu elements evenly */
            align-items: center;
            order: 2; /* Moves the menu to the right */
        }

        .menu li {
            margin-right: 70px;
        }

        .menu li:last-child {
            margin-right: 0;
        }

        .menu a {
            text-decoration: none;
            color: black; /* Change menu link color to black */
            font-weight: bold;
            transition: color 0.3s;
        }

        .menu a:hover {
            color: rgb(46, 213, 0); /* Vibrant green color */
        }

        /* Avatar icon styles */
        #avatar {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 50px; /* Increase the size of the icon */
            height: 50px; /* Increase the size of the icon */
            border-radius: 50%;
            background-color: #c9c0c0; /* Add a background color for the circular border */
        }

        /* Dropdown menu styles */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #fff;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
            z-index: 1;
            border-radius: 5px;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            transition: background-color 0.3s;
        }

        .dropdown-content a:hover {
            background-color: #f4f4f4;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

       /* .logout-button {
            background-color: #6a6262; /* Red button background color */
         /*   color: #d2c7c7; /* Text color */
         /*   border: none;
            padding: 10px 20px; /* Adjust the padding as needed */
           /* border-radius: 0; /* Rounded corners */
            /*font-weight: bold;
            text-transform: uppercase; /* Convert text to uppercase */
            /*cursor: pointer;
            transition: background-color 0.3s;
        }

        .logout-button:hover {
            background-color: #ffffff; /* Change background color on hover */
        /*}*/
    </style>
</head>
<body class="bodynav">
    <nav class="navbar">
        <div class="containernav">
            <a href="viewAllblog" class="logo">Blog Guru</a>
            <ul class="menu">
                <li><a href="viewAllblog">Home</a></li>
                <!-- Dropdown menu for Blog -->
                <li class="dropdown"> 
                     <a href="javascript:void(0)">Blog</a>
                     <div class="dropdown-content">
                        <a href="CreatePost.jsp">Create a Post</a>
                        <a href="viewAllblog">All Blogs</a>
                    </div>
                </li>
                <li><a href="contact.jsp">Contact</a></li>
                <li><a href="about.jsp">About</a></li>
                 <li class="dropdown">
                   
                          
                            <div id="avatar">
                                <i class="fa fa-user" style="font-size: 23px;"></i>
                            </div>
                       
                     <div class="dropdown-content">
						<a href="${pageContext.request.contextPath}/profile/${eusername}" id="usernameLink">Hi, <span>${eusername}</span></a>
                        <a href="javascript:void(0)" onclick="viewMyBlogs(${eid})">My Blogs</a>
                        <a href="index.jsp" >Logout</a>
                    </div>
                </li>
            </ul>
        </div>
        <script>
        var usernameLink = document.getElementById("usernameLink");

        // If the username link does not exist, show a pop-up message
        if (!usernameLink) {
            alert("Username not found. Please try to relogin.");
        }

        
    function viewMyBlogs(uid) {
        // Redirect to the controller with the uid parameter
        window.location.href = "viewallblogmyuid" + uid;
    }
</script>
    </nav>
    
</body>
</html>
