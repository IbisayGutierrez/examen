/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Customer;

import Model.Mapper.Mapper;
import Utils.UtilDate;
import java.sql.Date;

/**
 *
 * @author sofia
 */
public class CustomerMapper implements Mapper<Customer, CustomerDTO>{

    @Override
    public CustomerDTO toDto(Customer ent) {
        return new CustomerDTO(
                ent.getId(),
                ent.getName(),
                UtilDate.toSqlDate(ent.getBirthDate()),
                ent.getPhone(),
                ent.getEmail()
        );
    }

    @Override
    public Customer toEntity(CustomerDTO dto) {
       if(dto == null) return null;
       return new Customer(
               dto.getId(),
               dto.getName(),
               UtilDate.toLocalDate(dto.getBirthDate()),
               dto.getPhone(),
               dto.getEmail()
       );
    }
    
}
