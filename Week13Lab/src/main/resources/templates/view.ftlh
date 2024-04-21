<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Poll</title>
</head>

<p>${poll.question}</p>
<#list poll.answers as answer>
<p>
  <#if poll.singleChoice>
    <input type="radio">
  <#else>
    <input type="checkbox">
  </#if>
  ${answer}
</p>
</#list>

</body>
</html>