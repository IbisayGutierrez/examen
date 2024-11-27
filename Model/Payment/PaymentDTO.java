/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Payment;

import Model.RentalContract.RentalContract;
import java.time.LocalDate;
import java.sql.Date;

/**
 *
 * @author jprod
 */
public class PaymentDTO {
    private int id;
    private int rentalContract;
    private double amount;
    private String paymentMethod;
    private Date date;
    

    public int getId() {
        return id;
    }

    public int getRentalContract() {
        return rentalContract;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Date getDate() {
        return date;
    }

    protected PaymentDTO(int id,int rentalContract, double amount, String paymentMethod, Date date) {
        this.id = id;
        this.rentalContract=rentalContract;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

}
