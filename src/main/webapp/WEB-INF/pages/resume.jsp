<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>HelloWorld page</title>
</head>
<body>

<form method="post" action="/resume/send" enctype="multipart/form-data">
    <table>

        <img src="resources/images/jiuru.jpg"  alt="aaa"/>

        <input type="file" name="testfile">
        <input type="submit" value="upload"/>
    </table>
</form>

</body>
</html>