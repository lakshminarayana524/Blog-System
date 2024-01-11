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
            padding-botton:10px;
        }

        
        button {
    font-family: inherit;
    font-size: 20px;
    background: royalblue;
    color: white;
   padding: 12px 25px;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    border: none;
    border-radius: 16px;
    overflow: hidden;
    -webkit-transition: all 0.2s;
    transition: all 0.2s;
    cursor: pointer;
  }
  
  button span {
    display: block;
    margin-left: 0.3em;
    -webkit-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
  }
  
  button svg {
    display: block;
    -webkit-transform-origin: center center;
    -ms-transform-origin: center center;
    transform-origin: center center;
    -webkit-transition: -webkit-transform 0.3s ease-in-out;
    transition: -webkit-transform 0.3s ease-in-out;
    transition: transform 0.3s ease-in-out;
    transition: transform 0.3s ease-in-out, -webkit-transform 0.3s ease-in-out;
  }
  
  button:hover .svg-wrapper {
    -webkit-animation: fly-1 0.6s ease-in-out infinite alternate;
    animation: fly-1 0.6s ease-in-out infinite alternate;
  }
  
  button:hover svg {
    -webkit-transform: translateX(1.2em) rotate(45deg) scale(1.1);
    -ms-transform: translateX(1.2em) rotate(45deg) scale(1.1);
    transform: translateX(1.2em) rotate(45deg) scale(1.1);
  }
  
  button:hover span {
    -webkit-transform: translateX(5em);
    -ms-transform: translateX(5em);
    transform: translateX(5em);
  }
  
  button:active {
    -webkit-transform: scale(0.95);
    -ms-transform: scale(0.95);
    transform: scale(0.95);
  }
  
  @-webkit-keyframes fly-1 {
    from {
      -webkit-transform: translateY(0.1em);
      transform: translateY(0.1em);
    }
  
    to {
      -webkit-transform: translateY(-0.1em);
      transform: translateY(-0.1em);
    }
  }
  
  @keyframes fly-1 {
    from {
      -webkit-transform: translateY(0.1em);
      transform: translateY(0.1em);
    }
  
    to {
      -webkit-transform: translateY(-0.1em);
      transform: translateY(-0.1em);
    }
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

	        <button type=submit>
	    <div class="svg-wrapper-1">
	      <div class="svg-wrapper">
	        <svg
	          xmlns="http://www.w3.org/2000/svg"
	          viewBox="0 0 24 24"
	          width="24"
	          height="24"
	        >
	          <path fill="none" d="M0 0h24v24H0z"></path>
	          <path
	            fill="currentColor"
	            d="M1.946 9.315c-.522-.174-.527-.455.01-.634l19.087-6.362c.529-.176.832.12.684.638l-5.454 19.086c-.15.529-.455.547-.679.045L12 14l6-8-8 6-8.054-2.685z"
	          ></path>
	        </svg>
	      </div>
	    </div>
	    <span>Send</span>
	  </button>
    </form>
</div>
</body>
</html>
