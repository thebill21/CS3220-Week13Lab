<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Poll</title>
</head>
<body>
<p><a href="/">Back to Polls</a></p>
<!-- Ensure that the poll and its answers are not null -->
<#if poll??>
    <p>${poll.question! "No question available"}</p>
    <!-- Check if the poll has answers and iterate over them -->
    <#if poll.answers?? && (poll.answers?size > 0)>
        <form action="/view/${poll.id}/vote" method="post">
            <#list poll.answers as answer>
                <p>
                    <label>
                        <!-- Check if the poll requires single choice (radio) or multiple choices (checkbox) -->
                        <#if poll.singleChoice??>
                            <input type="radio" name="pollAnswer" value="${answer.id}">
                        <#else>
                            <input type="checkbox" name="pollAnswer" value="${answer.id}">
                        </#if>
                        ${answer.content! "No content available"}
                    </label>
                </p>
            </#list>
            <input type="submit" value="Vote">
        </form>
    <#else>
        <p>No answers available.</p>
    </#if>
<#else>
    <p>Poll details are not available.</p>
</#if>
</body>
</html>
