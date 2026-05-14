package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FeePaymentDAO;

public class ReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {

            String type = req.getParameter("type");

            FeePaymentDAO dao = new FeePaymentDAO();

            if ("overdue".equals(type)) {

                req.setAttribute("list", dao.getOverdue());

            } else {

                String fromStr = req.getParameter("from");
                String toStr = req.getParameter("to");

                if (fromStr != null && toStr != null
                        && !fromStr.isEmpty()
                        && !toStr.isEmpty()) {

                    Date from = Date.valueOf(fromStr);
                    Date to = Date.valueOf(toStr);

                    double total =
                            dao.getTotal(from, to);

                    req.setAttribute("total", total);

                } else {

                    req.setAttribute(
                            "error",
                            "Invalid Date Input"
                    );
                }
            }

            req.getRequestDispatcher("report_result.jsp")
                    .forward(req, res);

        } catch (Exception e) {

            e.printStackTrace();

            res.getWriter().println(
                    "Error : " + e.getMessage()
            );
        }
    }
}