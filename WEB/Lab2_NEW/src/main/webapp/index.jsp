<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="Web programming second lab" name="description">
    <meta content="Danilov Pavel Iurievich" name="author">
    <title>Web programming - lab 2</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>

<body onload="drawCanvas()">

<jsp:useBean id="results" class="com.example.web2.model.Results" scope="session"/>
<jsp:useBean id="check" class="com.example.web2.model.Point" scope="session"/>

<script src="canvas_handler.js"></script>
<script src="validator.js"></script>

<header>
    <span id="author">
        Gorinov Daniil Andreevich, P32151, v. 14070
    </span>
</header>

<table class="page_table" align="center">
    <tr>
        <td>
            <canvas id="canvas"></canvas>
        </td>
    </tr>
    <tr>
        <td>
            <p hidden id="err_msg">Something went wrong!</p>
        </td>
    </tr>
    <tr>
        <td>
            <p id="enter-text">Enter values:</p>
        </td>
    </tr>
    <tr>
        <td>
            <div class="vars_table">
                <form id="form" method="GET" action="controllerServlet">
                    <p>X=
                        <label>
                            <select id="X_field" name="X_field" class="variable">
                                <option value="-2">-2</option>
                                <option value="-1.5">-1.5</option>
                                <option value="-1">-1</option>
                                <option value="-0.5">-0.5</option>
                                <option value="0" selected>0</option>
                                <option value="0.5">0.5</option>
                                <option value="1">1</option>
                                <option value="1.5">1.5</option>
                                <option value="2">2</option>
                            </select>
                        </label>
                    </p>
                    <p class="variable">Y=
                        <label for="Y_field"></label><input id="Y_field" type="text" name="Y_field" placeholder="Enter y:">
                    </p>
                    <p class="variable">R=
                        <label for="R_field"></label><input id="R_field" type="text" name="R_field" placeholder="Enter r:">
                        <%!
                            private int counter = 0;
                        %>
                        <%
                            counter = counter + 1;
                        %>
                        <%=counter%>
                    </p>
                    <p>
                        <button id="button" type="submit">Submit</button>
                    </p>
                </form>
            </div>
        </td>
    </tr>
    <tr>
        <td>
            <jsp:include page="all_table.jsp"/>
        </td>
    </tr>
</table>

</body>
</html>
