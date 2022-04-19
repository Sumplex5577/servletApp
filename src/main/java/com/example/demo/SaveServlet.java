package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/saveServlet")
public class SaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        String strs;

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
        employee.setWatchbrand(watchbrand);
        employee.setWatchmodel(watchmodel);
        employee.setPrice(price);
        employee.setYear(year);


        //out.println(employee.toString());
        //out.println(EmployeeRepository.getConnection());

        int status = EmployeeRepository.save(employee);
        //out.println(status);

        if (status > 0) {
            out.print("Record saved successfully!");
        } else {
            out.println("Sorry! unable to save record");
        }
        out.close();
    }
}
