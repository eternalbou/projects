<%-- 
    Document   : collection
    Created on : 30.08.2017, 15:33:41
    Author     : Kirill
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vinyl Collection</title>
    </head>
    <body>
        <h1>Vinyl list:</h1>
        <table>
            <tr>
                <th>ID</th><th>Artist</th><th>Album</th><th>Description</th>
            </tr>
            <c:forEach var="vinyl" items="${vinyls}">
                <tr>
                    <td>
                        <c:out value="${vinyl.getCollectionId()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${vinyl.getArtist()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${vinyl.getAlbum()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${vinyl.getDescription()}"></c:out>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
