<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Polls</title>
</head>
<body>
<p><a href="add">Create Poll</a></p>
<table border="1">
  <#list polls as poll>
    <tr>
       <td><a href="view/${poll.id}">${poll.question}</a></td>
       <td><a href="answers/${poll.id}">Add Answers</a></td>
    </tr>
  </#list>
</table>
</body>
</html>