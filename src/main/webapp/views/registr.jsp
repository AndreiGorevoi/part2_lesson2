<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .div_registr{
            text-align: center;
        }
    </style>
    <title>Title</title>
</head>
<body>
<div class="div_registr">
    <h1>Registration</h1>
    <form method="post" action="/part2_lesson2_war/registration">
        <label>Login</label>
        <input type="text" name="login"/>
        <br>
        <label>Password</label>
        <input type="password" name="password"/>
        <br>
        <label>Name</label>
        <input type="text" name="name"/>
        <br>
        <button type="submit">Registration</button>

    </form>

</div>

</body>
</html>
