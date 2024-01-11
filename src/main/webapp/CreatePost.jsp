<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create a Blog Post</title>
    <style>
        .createpost-container {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

       .createpost-container header {
            background-color: #ff6f61;
            color: #fff;
            padding: 20px;
            text-align: center;
            height: 100px;
            width: 300px;
            margin-top:20px;
            margin-bottom: 20px;
            transition: background-color 0.3s ease-in-out;
        }

       .createpost-container header:hover {
            background-color: #ff483f;
        }

        .createpost-container form {
            background-color: #fff;
            margin: 20px;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 450px; /* Set a maximum width for the form */
            margin: 0 auto; /* Center the form horizontally */
            transition: transform 0.3s ease-in-out;
        }

       .createpost-container form:hover {
            transform: scale(1.05);
        }

       .createpost-container label, input, textarea {
            display: block;
            margin-bottom: 15px;
        }

       .createpost-container input[type="text"],
        input[type="file"],
        textarea {
            width: 95%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            transition: border-color 0.3s ease-in-out;
        }

       .createpost-container input[type="text"]:focus,
        input[type="file"]:focus,
        textarea:focus {
            border-color: #ff6f61;
        }

        .createpost-container input[type="file"] {
            padding: 5px;
        }

        .createpost-container button {
            background-color: #ff6f61;
            color: #fff;
            border: none;
            padding: 12px 25px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s ease-in-out;
        }

       .createpost-container button:hover {
            background-color: #ff483f;
        }
    </style>
</head>
<body>
<%@ include file="userlognav.jsp" %>
<div class="createpost-container">
    <header>
        <h1>Create a Blog Post</h1>
    </header>

    <form method="post" action="insert-blog-post"  enctype="multipart/form-data">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>

        <label for="author">Author:</label>
        <input type="text" id="author" name="author" required>

        <label for="content">Content:</label>
        <textarea id="content" name="content" rows="6" required></textarea>

        <label for="image">Upload an Image:</label>
        <input type="file" id="image" name="image" accept="image/*">

        <button type="submit">Publish</button>
    </form>
</div>
</body>
</html>
