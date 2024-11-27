/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Payment;

import Model.Mapper.Mapper;
import Model.RentalContract.RentalContract;
import Model.RentalContract.RentalContractMapper;
import Utils.UtilDate;
import DataBase.DataBase;
import Model.RentalContract.RentalContractDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 9567
 */
public class PaymentMapper implements Mapper<Payment, PaymentDTO>{

    @Override
    public PaymentDTO toDto(Payment ent) {
        if(ent==null)return null;
        return new PaymentDTO(
                ent.getId(),
                ent.getRentalContract().getId(),
                ent.getAmount(),
                ent.getPaymentMethod(),
                UtilDate.toSqlDate(ent.getDate()));
    }

    @Override
    public Payment toEntity(PaymentDTO dto) {
        if(dto == null) return null;
        try {
            return new Payment(
                    dto.getId(),
                    new RentalContractMapper().toEntity(new RentalContractDAO(DataBase.getConnection()).read(dto.getRentalContract())),
                    dto.getAmount(),
                    dto.getPaymentMethod(),
                    UtilDate.toLocalDate(dto.getDate())
            );
        } catch (SQLException ex) {
            Logger.getLogger(PaymentMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaymentMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
