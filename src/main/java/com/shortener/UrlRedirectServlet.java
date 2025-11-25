package com.shortener;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UrlRedirectServlet extends HttpServlet {

    private UrlDao dao = new UrlDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String shortCode = request.getPathInfo().substring(1);

        String longUrl = dao.getLongUrl(shortCode);
        dao.incrementClicks(shortCode);

        response.sendRedirect(longUrl);
    }
}
