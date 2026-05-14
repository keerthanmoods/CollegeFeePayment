package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReportCriteriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {

            String type = req.getParameter("type");

            if ("overdue".equals(type)) {

                res.sendRedirect("ReportServlet?type=overdue");

            } else {

                req.getRequestDispatcher("report_form.jsp")
                        .forward(req, res);
            }

        } catch (Exception e) {

            e.printStackTrace();

            res.getWriter().println(
                    "Error : " + e.getMessage()
            );
        }
    }
}