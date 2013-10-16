package com.bestv.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: richard
 * Date: 13-10-17
 * Time: 上午1:19
 * To change this template use File | Settings | File Templates.
 */
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        generate(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        generate(request, response);
    }

    private void generate(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out;
        try {
            out = response.getWriter();
            out.println("Hello world!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
