package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);

            Employee employee = EmployeeRepository.getEmployeeById(id);

            if (employee.getId() == 0) {
                throw new IOException("wrong ID");
            }
            EmployeeRepository.delete(id);
            //            out.print ("ID deleted successfully!");
            response.sendRedirect("viewServlet");
        }

        catch (Throwable e) {
            out.print ("not exist ID");
        }
    }
}