package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import com.model.FeePayment;

public class FeePaymentDAO {

    public void addPayment(FeePayment f) throws Exception {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO FeePayments(StudentID,StudentName,PaymentDate,Amount,Status) VALUES(?,?,?,?,?)"
        );

        ps.setString(1, f.getStudentId());
        ps.setString(2, f.getStudentName());
        ps.setDate(3, f.getPaymentDate());
        ps.setDouble(4, f.getAmount());
        ps.setString(5, f.getStatus());

        ps.executeUpdate();

        con.close();
    }

    public void updatePayment(FeePayment f) throws Exception {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "UPDATE FeePayments SET StudentID=?, StudentName=?, PaymentDate=?, Amount=?, Status=? WHERE PaymentID=?"
        );

        ps.setString(1, f.getStudentId());
        ps.setString(2, f.getStudentName());
        ps.setDate(3, f.getPaymentDate());
        ps.setDouble(4, f.getAmount());
        ps.setString(5, f.getStatus());
        ps.setInt(6, f.getPaymentId());

        ps.executeUpdate();

        con.close();
    }

    public void deletePayment(int id) throws Exception {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM FeePayments WHERE PaymentID=?"
        );

        ps.setInt(1, id);

        ps.executeUpdate();

        con.close();
    }

    public List<FeePayment> getAll() throws Exception {

        List<FeePayment> list = new ArrayList<>();

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement("SELECT * FROM FeePayments");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            FeePayment f = new FeePayment();

            f.setPaymentId(rs.getInt("PaymentID"));
            f.setStudentId(rs.getString("StudentID"));
            f.setStudentName(rs.getString("StudentName"));
            f.setPaymentDate(rs.getDate("PaymentDate"));
            f.setAmount(rs.getDouble("Amount"));
            f.setStatus(rs.getString("Status"));

            list.add(f);
        }

        con.close();

        return list;
    }

    public List<FeePayment> getOverdue() throws Exception {

        List<FeePayment> list = new ArrayList<>();

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM FeePayments WHERE Status='Overdue'"
        );

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            FeePayment f = new FeePayment();

            f.setPaymentId(rs.getInt("PaymentID"));
            f.setStudentId(rs.getString("StudentID"));
            f.setStudentName(rs.getString("StudentName"));
            f.setPaymentDate(rs.getDate("PaymentDate"));
            f.setAmount(rs.getDouble("Amount"));
            f.setStatus(rs.getString("Status"));

            list.add(f);
        }

        con.close();

        return list;
    }

    public double getTotal(Date from, Date to) throws Exception {

        double total = 0;

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT SUM(Amount) FROM FeePayments WHERE PaymentDate BETWEEN ? AND ?"
        );

        ps.setDate(1, from);
        ps.setDate(2, to);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            total = rs.getDouble(1);
        }

        con.close();

        return total;
    }
}