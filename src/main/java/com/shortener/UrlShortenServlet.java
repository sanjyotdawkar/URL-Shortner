package com.shortener;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UrlShortenServlet extends HttpServlet {

    private UrlDao dao = new UrlDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String longUrl = request.getParameter("longUrl");
        String shortCode = HashGenerator.generateHash();

        dao.saveUrl(longUrl, shortCode);

        String shortUrl = request.getRequestURL().toString().replace("shorten", "r/" + shortCode);

        request.setAttribute("shortUrl", shortUrl);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
