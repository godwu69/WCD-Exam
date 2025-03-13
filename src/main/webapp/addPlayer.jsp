<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Player</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }

    h1 {
      color: #333;
    }

    form {
      max-width: 400px;
      margin: 20px 0;
    }

    label {
      display: block;
      margin-bottom: 8px;
      font-weight: bold;
    }

    input[type="text"],
    input[type="number"] {
      width: 100%;
      padding: 8px;
      margin-bottom: 15px;
      border: 1px solid #ddd;
      border-radius: 4px;
    }

    button {
      padding: 10px 20px;
      background-color: #28a745;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    button:hover {
      background-color: #218838;
    }

    .back-link {
      display: inline-block;
      margin-top: 20px;
      color: #007bff;
      text-decoration: none;
    }

    .back-link:hover {
      text-decoration: underline;
    }
  </style>
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
<a href="players" class="back-link">Back to Player List</a>
</body>
</html>