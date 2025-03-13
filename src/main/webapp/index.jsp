<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Player Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #f4f4f4;
            color: #333;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .add-button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .add-button:hover {
            background-color: #218838;
        }

        .action-buttons a {
            margin-right: 10px;
        }

        .action-buttons a.delete {
            color: #dc3545;
        }
    </style>
</head>
<body>
<h1>Player Information</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Player Name</th>
        <th>Player Age</th>
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
            <td class="action-buttons">
                <a href="editPlayer.jsp?id=${player.id}">Edit</a>
                <a href="deletePlayer?id=${player.id}" class="delete">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="addPlayer.jsp" class="add-button">Add New Player</a>
</body>
</html>