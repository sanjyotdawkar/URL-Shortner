<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>URL Shortener</title>
</head>
<body>
    <h2>URL Shortener</h2>
    <form action="shorten" method="post">
        <label>Enter URL: </label>
        <input type="text" name="longUrl" size="50" required />
        <button type="submit">Shorten</button>
    </form>

    <%
        String shortUrl = (String) request.getAttribute("shortUrl");
        if (shortUrl != null) {
    %>
        <p><strong>Shortened URL:</strong> 
            <a href="<%= shortUrl %>"><%= shortUrl %></a>
        </p>
    <% } %>
</body>
</html>
