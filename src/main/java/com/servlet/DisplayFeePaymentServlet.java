package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

public class DisplayFeePaymentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {

            FeePaymentDAO dao = new FeePaymentDAO();

            List<FeePayment> list = dao.getAll();

            req.setAttribute("list", list);

            RequestDispatcher rd =
                    req.getRequestDispatcher("feepaymentdisplay.jsp");

            rd.forward(req, res);

        } catch (Exception e) {

            e.printStackTrace();

            res.getWriter().println(
                    "Error : " + e.getMessage()
            );
        }
    }
}