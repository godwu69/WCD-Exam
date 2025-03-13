<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Player</title>
</head>
<body>
<h1>Add New Player</h1>
<form action="addPlayer" method="post">
  <label for="playerName">Player Name:</label>
  <input type="text" id="playerName" name="playerName" required><br><br>

  <label for="playerAge">Player Age:</label>
  <input type="number" id="playerAge" name="playerAge" required><br><br>

  <label for="indexName">Index Name:</label>
  <input type="text" id="indexName" name="indexName" required><br><br>

  <label for="indexValue">Index Value:</label>
  <input type="number" id="indexValue" name="indexValue" required><br><br>

  <button type="submit">Add Player</button>
</form>
<br>
<a href="players">Back to Player List</a>
</body>
</html>