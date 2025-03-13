<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Player</title>
</head>
<body>
<h1>Edit Player</h1>
<form action="updatePlayer" method="post">
    <input type="hidden" name="playerId" value="${player.id}">

    <label for="playerName">Player Name:</label>
    <input type="text" id="playerName" name="playerName" value="${player.name}" required><br><br>

    <label for="playerAge">Player Age:</label>
    <input type="number" id="playerAge" name="playerAge" value="${player.age}" required><br><br>

    <label for="indexName">Index Name:</label>
    <input type="text" id="indexName" name="indexName" value="${player.indexName}" required><br><br>

    <label for="indexValue">Index Value:</label>
    <input type="number" id="indexValue" name="indexValue" value="${player.indexValue}" required><br><br>

    <button type="submit">Update Player</button>
</form>
<br>
<a href="players">Back to Player List</a>
</body>
</html>