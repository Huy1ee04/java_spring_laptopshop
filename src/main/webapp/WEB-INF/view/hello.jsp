<!-- File này đóng vai trò là view trong mo hình MVC -->
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"> </script>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link href = "/css/demo.css" rel = "stylesheet">
</head>

<body>
hello from jsp
    <h1>
        <c:out value = "${huy}" />
        ${huy}        <%-- cú pháp in ra 1 biến từ controller ném sang view của jsp --%>
    </h1>
    <h2>
        ${hung}
    </h2>
    <button> Submit </button>
</body>
</html>