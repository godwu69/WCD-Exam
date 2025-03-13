<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Player Information</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 10px;
        }
    </style>
</head>
<body>
<h1>Player Information</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Index Name</th>
        <th>Index Value</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="player" items="${players}">
        <tr>
            <td>${player.id}</td>
            <td>${player.name}</td>
            <td>${player.age}</td>
            <td>${player.indexName}</td>
            <td>${player.indexValue}</td>
            <td>
                <a href="editPlayer.jsp?id=${player.id}">Edit</a>
                <a href="deletePlayer?id=${player.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="addPlayer.jsp">Add New Player</a>
</body>
</html>