<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Users</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- <link href="/css/demo.css" rel="stylesheet"> -->

</head>

<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-12 mx-auto">
            <div class="justify-content-between d-flex">
                <h3>Delete user with id = ${id}</h3>
            </div>
            <hr/>
            <div class="alert alert-danger" role="alert">
                A simple danger alert—check it out!
            </div>
            <!-- method post dùng được hầu hết trong các trường hợp nên co thể dùng post thay vì method delete-->
            <form:form method="post" action="/admin/user/delete" modelAttribute="User">
                <div class="mb-3" style="display: none">    <!-- display:none để ẩn không cho người dùng nhìn, nhưng admin van thay  -->
                    <label class="form-label">Id:</label>
                    <form:input type="text" class="form-control" path="id" />
                </div>
                <button type="submit" class="btn btn-danger">Confirm</button>
            </form:form>
        </div>
    </div>
</div>
</body>
<html>