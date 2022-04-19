package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/putServlet")
public class PutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String strs;

        strs = request.getParameter("id");
        int id = Integer.parseInt(strs);

        String watchbrand = request.getParameter("watchbrand");
        String watchmodel = request.getParameter("watchmodel");

        strs = request.getParameter("price");
        int price = Integer.parseInt(strs);
        if(price < 1000 ){
            throw new IOException("Unfortunately, amount has to be larger than 1000");
        }
        strs = request.getParameter("year");
        int year = Integer.parseInt(strs);
        if (year < 2020) {
            throw new IOException("Sorry this shop sells only new watches");
        }


        Employee employee = new Employee();
        employee.setId(id);
        employee.setWatchbrand(watchbrand);
        employee.setWatchmodel(watchmodel);
        employee.setPrice(price);
        employee.setYear(year);


        int status = EmployeeRepository.update(employee);

        if (status > 0) {
            response.sendRedirect("viewServlet");
        } else {
            out.println("Sorry! unable to update record");
        }
        out.close();
    }
}
