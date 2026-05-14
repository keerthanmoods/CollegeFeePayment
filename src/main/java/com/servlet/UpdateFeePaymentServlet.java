package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

public class UpdateFeePaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {

            int paymentId =
                    Integer.parseInt(req.getParameter("id"));

            String studentId =
                    req.getParameter("studentId");

            String studentName =
                    req.getParameter("studentName");

            Date paymentDate =
                    Date.valueOf(req.getParameter("paymentDate"));

            double amount =
                    Double.parseDouble(req.getParameter("amount"));

            String status =
                    req.getParameter("status");

            FeePayment fee = new FeePayment();

            fee.setPaymentId(paymentId);
            fee.setStudentId(studentId);
            fee.setStudentName(studentName);
            fee.setPaymentDate(paymentDate);
            fee.setAmount(amount);
            fee.setStatus(status);

            FeePaymentDAO dao = new FeePaymentDAO();

            dao.updatePayment(fee);

            res.sendRedirect("DisplayFeePaymentsServlet");

        } catch (Exception e) {

            e.printStackTrace();

            res.getWriter().println(
                    "Error : " + e.getMessage()
            );
        }
    }
}