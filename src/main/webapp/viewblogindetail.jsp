<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Blog Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            border-radius: 5px;
        }

        h1 {
            font-size: 24px;
            color: #333;
        }

        p {
            margin: 10px 0;
            color: #444;
        }

        img {
            max-width: 100%;
            height: auto;
        }

        button {
            display: inline-block;
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
        }

        button:hover {
            background-color: #45a049;
        }

        /* Add CSS for comment section */
        .comment-section {
            margin-top: 20px;
            border-top: 1px solid #ccc;
            padding-top: 20px;
        }

        .comment-input {
            width: 90%;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 10px;
        }

        .submit-button {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            margin-right: 10px;
        }

        .view-comments-button {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>${blog.title}</h1>
        <p>Author: ${blog.author}</p>
        <img src="displayproimage?id=${blog.id}" alt="Blog Image">
        <p>${blog.content}</p><br>
        <button onclick="goBack()">Back</button>
        
        <!-- Comment section -->
        <div class="comment-section">
        <form method="post" action="addcomment">
		    <input type="hidden" id="name" name="name"  value="${eusername}"  />
		    <input type="hidden" id="uid" name="uid" value="${eid}">
		    <input type="hidden" name="id" id="id" value="${blog.id}" />
            <input type="text" class="comment-input" placeholder="Add a comment" id="comment" name="comment">
            <button type="submit" class="submit-button">Submit</button>
            </form>
             <!--   <a href="viewallcomments?id=${comment.id}" class="view-comments-button">View All Comments</a>-->
        </div>
       <c:forEach items="${blog.comments}" var="comment">
    <div class="comment">
    
    <p><b style="color: green;"><label placeholder="${comment.name}"></b>: ${comment.comment}</p>
    <!-- <a href='<c:url value="deletecomment/${comment.id}"></c:url>' style="color: red; text-decoration: none; margin-left: 10px;">Delete</a>-->
	</div>

	
    </c:forEach>
    </div>
    <script>
    // Variable to store the previous URL
   //	 var previousUrl = document.referrer || '/';

    // Function to go back
    function goBack() {
        // Use the stored previous URL to navigate back
        window.history.back();
    }
</script>


    
</body>
</html>
