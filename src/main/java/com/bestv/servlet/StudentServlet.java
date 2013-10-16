package com.bestv.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: richard
 * Date: 13-10-17
 * Time: 上午1:19
 * To change this template use File | Settings | File Templates.
 */
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        generate(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        generate(request, response);
    }

    private void generate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "index";
        Integer id = request.getParameter("id") != null ? Integer.valueOf(request.getParameter("id")) : 0;

        if ("index".equals(action)) {
            response.sendRedirect("/views/students/index.jsp");
        }

        if ("show".equals(action)) {
            response.sendRedirect("/views/students/show.jsp?id=" + id);
        }
    }
}
