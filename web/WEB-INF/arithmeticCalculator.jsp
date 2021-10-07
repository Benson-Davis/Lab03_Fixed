<%-- 
    Document   : arithmeticCalculator.jsp
    Created on : 30-Sep-2021, 1:30:28 PM
    Author     : bdavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arith Calc</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="POST" action="arithmetic"><%--action needs to be the url pattern of the desired target page--%>
            <label>First: </label>
            <input type='text' name="first" value="${first}"><br>
            <label>Second: </label>
            <input type='text' name="second" value="${second}"><br>
            <input type='submit' name="add" value='+'><input type='submit' name="subtract" value='-'><input type='submit' name="multiply" value='*'><input type='submit' name="modulo" value='%'>
        </form>
        <p name="response">Result: ${answer}</p>
        <a href="/Lab03/ageCalculator">Age Calculator
    </body>
    </body>
</html>
