<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring Boot Hello World Example with FreeMarker</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<h2 class="hello-title">${name}</h2>
<#list lists as aaa>
<p class="hello-title">
    ${aaa}
</p>

</#list>
<script src="/js/main.js"></script>
</body>
</html>
