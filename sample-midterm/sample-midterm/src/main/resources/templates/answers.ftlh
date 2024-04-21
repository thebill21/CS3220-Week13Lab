<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Answer</title>
</head>

<p><a href="/">Back to Polls</a></p>

<#-- Ensure that the poll object itself is not null -->
<#if polls??>
    <p>${polls.question! "No question available"}</p>

<#-- Check if the answers list is not null and has items -->
    <#if polls.answers?? && (polls.answers?size > 0)>
    <#-- Iterate through each answer in the poll -->
        <#list polls.answers as answer>
            <p>${answer.content! "No content available"}</p>
        </#list>
    <#else>
        <p>No answers available.</p>
        <p>Please add a new answer to the poll.</p>
    </#if>
<#else>
    <p>Poll details are not available.</p>
</#if>

<form method="post">
<input type="text" name="answer"> <button>Add</button>
</form>
</body>
</html>