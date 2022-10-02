<%--
  Created by IntelliJ IDEA.
  User: yalhejoj
  Date: 9/29/2022
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Update Crew</title>
</head>
<body>
<div id="wrapper">
    <div id="header">Crew Form</div>
    <div id="container">
        <h3>Update Movie</h3>
        <form:form action="updateCrew" method="POST" modelAttribute="crew">

            <form:hidden path="id"/>
            <form:hidden path="movieId"/>
            <table>
                <tbody>
                <tr>
                    <td><label>name </label></td>
                    <td><form:input path="name"/></td>
                </tr>

                <tr>
                    <td><label>type </label></td>
                    <td><form:radiobuttons path="type" items="${types}" /></td>
                </tr>


                <tr>
                    <td><label>job</label></td>
                    <td><form:input path="job"/></td>
                </tr>


                <tr>
                    <td><label>characters</label></td>
                    <td><form:input path="characters"/></td>
                </tr>




                <tr style="visibility: hidden">
                    <td><label>createAt</label></td>
                    <td><form:input path="createAt"/></td>
                </tr>


                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>
                </tbody>
            </table>



        </form:form>
        <div class="clear; both;"> </div>
        <p>
            <a href="${pageContext.request.contextPath}/crew/crewByMovieId?movieId=${crew.movieId}"> back to the List </a>
        </p>

    </div>
</div>
</body>
</html>
