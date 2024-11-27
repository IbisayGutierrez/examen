/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.RentalContract;

import Model.Customer.Customer;
import Model.Vehicle.Vehicle;
import java.time.LocalDate;
import java.time.Period;
import java.sql.Date;

/**
 *
 * @author jprod
 */
public class RentalContractDto {
    private int id;
    private String customer;
    private String vehicle;
    private double dailyRate;
    private Date startDate;
    private Date endDate;

    public int getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public String getVehicle() {
        return vehicle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    
    public double getDailyRate() {
        return dailyRate;
    }
    
    protected RentalContractDto(int id, String customer, String vehicle,double dailyRate, Date startDate, Date endDate) {
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    //private int calculateDaysOfRent(){
        //if (endDate == null) {
            //throw new IllegalArgumentException("La fecha de finalizacion no puede ser nula");
        //}
        //return Period.between(startDate, endDate).getDays();
    //}
    
    //private double calculateRentalCost(int days){        
        //return days*vehicle.getDailyRate(); 
    //}

}
