package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FeePaymentDAO;

public class DeleteFeePaymentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {

            int id =
                    Integer.parseInt(req.getParameter("id"));

            FeePaymentDAO dao = new FeePaymentDAO();

            dao.deletePayment(id);

            res.sendRedirect("DisplayFeePaymentsServlet");

        } catch (Exception e) {

            e.printStackTrace();

            res.getWriter().println(
                    "Error : " + e.getMessage()
            );
        }
    }
}