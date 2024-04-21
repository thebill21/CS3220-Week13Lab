<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="UTF-8">
    <title>Vote Response</title>
    <p><a href="/">Back to Polls</a></p>
</head>

<body>
    <#-- Ensure that the poll object itself is not null -->
    <#if poll??>
        <p>${poll.question! "No question available"}</p>

    <#-- Check if the answers list is not null and has items -->
        <#if answers?? && (answers?size > 0)>
            <p>Your choice(s): </p>
        <#-- Iterate through each answer in the poll -->
            <#list answers as answer>
                <p>${answer.content! "No content available"}</p>
            </#list>
        <#else>
            <p>No answers available.</p>
            <p>Please add a new answer to the poll.</p>
        </#if>
    <#else>
        <p>Poll details are not available.</p>
    </#if>

    <p>${message}</p>
</body>
</html>