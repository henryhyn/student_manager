package com.bestv.servlet;

import com.bestv.database.dao.DaoFactory;
import com.bestv.database.model.Student;

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
        String name = request.getParameter("name")!=null ? request.getParameter("name") : "";
        String number = request.getParameter("number")!=null ? request.getParameter("number") : "";
        Integer classId = request.getParameter("class_id")!=null ? Integer.valueOf(request.getParameter("class_id")) : 0;

        if ("index".equals(action)) {
            response.sendRedirect("/views/students/index.jsp");
        }

        if ("show".equals(action)) {
            response.sendRedirect("/views/students/show.jsp?id=" + id);
        }

        if ("new".equals(action)) {
            response.sendRedirect("/views/students/form.jsp");
        }

        if ("create".equals(action)) {
            Student student = new Student();
            student.setName(name);
            student.setNumber(number);
            student.setClassId(classId);
            DaoFactory.getStudentDao().save(student);
            response.sendRedirect("/student?action=index");
        }

        if ("edit".equals(action)) {
            response.sendRedirect("/views/students/form.jsp?action=update&id=" + id);
        }

        if ("update".equals(action)) {
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setNumber(number);
            student.setClassId(classId);
            DaoFactory.getStudentDao().update(student);
            response.sendRedirect("/student?action=index");
        }

        if ("destroy".equals(action)) {
            Student student = DaoFactory.getStudentDao().find(id);
            DaoFactory.getStudentDao().delete(student);
            response.sendRedirect("/student?action=index");
        }
    }
}
