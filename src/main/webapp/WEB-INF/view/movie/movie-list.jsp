<%--
  Created by IntelliJ IDEA.
  User: yalhejoj
  Date: 9/27/2022
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title> Movie List </title>
    <style>
        <%@include file="/WEB-INF/css/style.css"%>
    </style>

</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Cinema App </h2>
    </div>
    <div id="container">
        <div id="content">
            <%--Add Customer  button--%>
            <input type="button" value="add Movie"
                   onclick="window.location.href='showAddForm';return false;"
                   class="add-button">
            <table>
                <tr>
                    <th>Title</th>
                    <th>Language</th>
                    <th>Type</th>
                    <th>Release date</th>
                    <th>is Adult</th>
                    <th></th>
                </tr>
                <%--Loop over and print customer--%>
                <c:forEach var="tempMovie" items="${movieList}">


                    <%-- construct an update link --%>
                    <c:url var="updateLink" value="showFormUpdate">
                        <c:param name="movieId" value="${tempMovie.id}"/>
                    </c:url>

                    <c:url var="showCrewLink" value="/crewView/crewByMovieId">
                        <c:param name="movieId" value="${tempMovie.id}"/>
                    </c:url>
                    <%-- construct an delete link --%>
                    <c:url var="deleteLink" value="deleteMovie">
                        <c:param name="movieId" value="${tempMovie.id}"/>
                    </c:url>
                    <tr>
                        <td>${tempMovie.title}</td>
                        <td>${tempMovie.language}</td>
                        <td>${tempMovie.type}</td>
                        <td>${tempMovie.releaseDate}</td>
                        <td>${tempMovie.adult}</td>
                        <td><%--display link --%>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}" onclick="if(!(confirm('Are You Sure ? ')))return false">Delete</a>
                            |
                            <a href="${showCrewLink}">ViewCrew</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>

</body>
</html>
