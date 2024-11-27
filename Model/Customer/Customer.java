/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Customer;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author jprod
 */

public class Customer {
    private String id;
    private String name;
    private LocalDate birthDate;
    private String phone;
    private String email;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    
    public int getAge() {
        return calulateAge(birthDate);
    }
    
    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer(String id, String name, LocalDate birthDate, String phone, String email) {
        this.id = id;
        this.name = name;
        this.birthDate=birthDate;
        this.phone = phone;
        this.email = email;
    }
    
    public static int calulateAge(LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}