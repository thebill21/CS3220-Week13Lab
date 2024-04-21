<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Answer</title>
</head>

<p><a href="/">Back to Polls</a></p>
<p>${poll.question}</p>
<#list poll.answers as answer>
<p>${answer}</p>
</#list>

<form method="post">
<input type="text" name="answer"> <button>Add</button>
</form>
</body>
</html>