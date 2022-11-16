#Y_field {
color: var(--background-color);
}#Y_field {
color: var(--background-color);
}<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="Web programming second lab" name="description">
    <meta content="Gorinov Daniil Andreevich" name="author">
    <title>Check result</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

<header>
    <span id="author">
        Gorinov Daniil Andreevich, P32151, v. 14070
    </span>
</header>

<table class="page_table" align="center">

    <tr>
        <td>
            <p id="enter-text">Check results</p>
        </td>
    </tr>
    <tr>
        <td>
            <jsp:include page="res_table.jsp" />
        </td>
    </tr>
    <tr>
        <td>
            <form method="get" action="controllerServlet">
                <button id="button" class="back_button" type="submit">Take me back.</button>
            </form>
        </td>
    </tr>
</table>

</body>
</html>
