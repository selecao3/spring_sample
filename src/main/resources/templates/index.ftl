<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring Boot Hello World Example with FreeMarker</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<h2 class="hello-title">Spring Boot Hello World Example with FreeMarker</h2>
<script src="/js/main.js"></script>
<#list fruits as x>
<p class="hello-title">
    ${x.name}
</p>
</#list>
<h2 class="hello-title">inputテスト</h2>
<form method="post" action="/upload" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="Submit">
</form>
<p></p>
</body>
</html>