<%-- 
    Document   : ageCalculator
    Created on : 23-Sep-2021, 2:24:16 PM
    Author     : bdavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calc</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="POST" action="ageCalculator"><%--action needs to be the url pattern of the desired target page--%>
            <label>Enter your age: </label>
            <input type='text' name="age" value="${ageString}"><br>
            <input type='submit' value='Age next birthday'>
        </form>
        <p name="response">${result}</p>
        <a href="/Lab03/arithmetic">Arithmetic Calculator
    </body>
</html>
