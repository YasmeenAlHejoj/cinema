<%--
  Created by IntelliJ IDEA.
  User: yalhejoj
  Date: 9/29/2022
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>The Movie Crew </title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>The Movie Crew</h2>
        <style>
            <%@include file="/WEB-INF/css/style.css"%>
        </style>
    </div>
    <div id="container">
        <div id="content">
            <input type="button" value="add Crew" onclick="window.location.href='showAddForm/movieId/${movieId}';return false;" class="add-button">
            <table>
                <tr>
                    <%--<th>movieId</th>--%>
                    <th>name</th>
                    <th>type</th>
                    <th>job</th>
                    <th>characters</th>
                    <th></th>
                </tr>
                <%--Loop over and print customer--%>
                <c:forEach var="tempCrew" items="${crews}">


                    <%-- construct an update link --%>
                    <c:url var="updateLink" value="showFormUpdate">
                        <c:param name="crewId" value="${tempCrew.id}"/>
                    </c:url>


                    <%-- construct an delete link --%>
                    <c:url var="deleteLink" value="deleteCrew">
                        <c:param name="crewId" value="${tempCrew.id}"/>
                        <c:param name="movieId" value="${movieId}"/>
                    </c:url>
                    <tr>
                            <%--<td>${tempCrew.movieId}</td>--%>
                        <td>${tempCrew.name}</td>
                        <td>${tempCrew.type}</td>
                        <td>${tempCrew.job}</td>
                        <td>${tempCrew.characters}</td>

                        <td><%--display link --%>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}" onclick="if(!(confirm('Are You Sure ? ')))return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>
</body>
</html>
