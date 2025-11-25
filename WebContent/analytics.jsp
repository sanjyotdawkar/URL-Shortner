<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.shortener.UrlData" %>
<%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
    <title>Analytics</title>
</head>
<body>
    <h2>URL Analytics</h2>

    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>Original URL</th>
            <th>Short Code</th>
            <th>Clicks</th>
        </tr>

        <%
            java.util.List<com.shortener.UrlData> list = 
                (java.util.List<com.shortener.UrlData>) request.getAttribute("analytics");

            if (list != null) {
                for (com.shortener.UrlData data : list) {
        %>
        <tr>
            <td><%= data.getId() %></td>
            <td><%= data.getLongUrl() %></td>
            <td><%= data.getShortCode() %></td>
            <td><%= data.getClicks() %></td>
        </tr>
        <% 
                }
            }
        %>
    </table>
</body>
</html>
