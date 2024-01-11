<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        /* Reset default margin and padding */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Body styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        /* Navbar styles */
        .navbar {
            background-color: rgba(246, 240, 240, 0.7); /* Transparent black background */
            color: #fff;
            padding: 10px 0;
        }

        /* Container styles */
        .container {
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
            order: 1; /* Moves the logo to the leftmost position */
        }

        /* Menu styles */
        .menu {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
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


        /* Login button styles */
        .login-button {
            background-color: #090a0a; /* Button background color */
            color: #fff; /* Text color */
            border: none;
            padding: 10px 20px; /* Adjust the padding as needed */
            border-radius: 5px; /* Rounded corners */
            font-weight: bold;
            text-transform: uppercase; /* Convert text to uppercase */
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .login-button:hover {
            background-color: #626a73; /* Change background color on hover */
            color: white;
        }

        .login-button a {
            text-decoration: none;
            color: #e3f6df; /* Text color for the link */
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
    </style>
</head>
<body>
    <nav class="navbar">
        <div class="container">
            <a href="index.html" class="logo">Blog Guru</a>
            <ul class="menu">
                <li><a href="index.jsp">Home</a></li>
                <!-- Dropdown menu for Blog -->
                <li class="dropdown">
                    <a href="javascript:void(0)">Blog</a>
                    <div class="dropdown-content">
                        <a href="login.jsp">Create a Post</a>
                        <a href="login.jsp">See All Blogs</a>
                    </div>
                </li>
                <li><a href="about.html">About</a></li>
                <li><a href="contact.html">Contact</a></li>
               	<div class="animate___animated
               				animate_bounce
               				animate_infinite">
                <li><button class="login-button"><a href="login.jsp">Login</a></button></li></div>
            </ul>
        </div>
    </nav>
</body>
</html>
