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
                <h3>Table users</h3>
                <a href="/admin/user/create" class="btn btn-primary">Create a user</a>
            </div>
            <hr/>
            <table class="table table-ordered table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                </thead>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <th>${user.id}</th>
                        <td>${user.fullName}</td>
                        <td>${user.email}</td>
                        <td>
                            <!-- Cú pháp {} tức ben trong nó là 1 biến số -->
                            <div>
                                <a href="/admin/user/${user.id}" class="btn btn-success">View</a>
                                <a href="/admin/user/update/${user.id}" class="btn btn-warning mx-2">Update</a>
                                <a href="/admin/user/delete/${user.id}" class="btn btn-danger">Delete</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
<html>