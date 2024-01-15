<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blog Display</title>
    <style>
        <!-- Your CSS styles remain unchanged -->
    </style>
</head>
<body>
    <%@ include file="userlognav.jsp" %>
    <div>
        <c:forEach items="${blog}" var="blogItem">
            <a href='<c:url value="viewblogwithcommentinuser?id=${blogItem.id}"></c:url>'>
                <div class="container">
                    <div class="blog-image">
                        <img src="displayproimage?id=${blogItem.id}" alt="Blog Image" style="max-width: 100%; height: auto;">
                    </div>
                    <div class="blog-details">
                        <div class="blog-title">${blogItem.title}</div>
                        <div class="blog-author">${blogItem.author}</div>
                        <p>${blogItem.content}</p>
                        <!-- Add more details here -->
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</body>
</html>
