<%--
  Created by IntelliJ IDEA.
  User: yalhejoj
  Date: 9/28/2022
  Time: 12:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Add Movie</title>
</head>
<body>
<div id="wrapper">
    <div id="header">Movie Form</div>
    <div id="container">
        <h3>Add Movie</h3>
        <form:form action="addMovie" method="POST" modelAttribute="movie">
            <table>
                <tbody>
                <tr>
                    <td><label>Title </label></td>
                    <td><form:input path="title"/></td>
                </tr>

                <tr>
                    <td><label>Language </label></td>
                    <td><form:input path="language"/></td>
                </tr>


                <tr>
                    <td><label>Type</label></td>
                    <td><form:input path="type"/></td>
                </tr>


                <tr>
                    <td><label>Release Date</label></td>
                    <td><form:input path="releaseDate" type="datetime-local"/>
                            <%--
                            <fmt:formatDate pattern = "yyyy-MM-dd"  value = "${now}" />
                            --%>
                            <%-- <label for="party">Enter a date and time for your party booking:</label>
                             <input id="party" type="datetime-local" name="party" />--%>
                    </td>
                </tr>


                <tr>
                    <td><label>Adult</label></td>
                    <td><form:input path="adult"/></td>
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
        <div class="clear; both;"></div>
        <p>
            <a href="${pageContext.request.contextPath}/view/viewList"> back to the List </a>
        </p>

    </div>
</div>
</body>
</html>
