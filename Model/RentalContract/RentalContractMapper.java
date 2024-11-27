/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.RentalContract;

import DataBase.DataBase;
import Model.Customer.Customer;
import Model.Customer.CustomerDAO;
import Model.Customer.CustomerMapper;
import Model.Mapper.Mapper;
import Model.Vehicle.VehicleDAO;
import Model.Vehicle.VehicleMapper;
import Utils.UtilDate;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 9567
 */
public class RentalContractMapper implements Mapper<RentalContract, RentalContractDto> {

    @Override
    public RentalContractDto toDto(RentalContract ent) {
        if (ent == null) {
            return null;
        }
        return new RentalContractDto(
                ent.getId(),
                ent.getCustomer().getId(),
                ent.getVehicle().getLicensePlate(),
                ent.getVehicle().getDailyRate(),
                UtilDate.toSqlDate(ent.getStartDate()),
                UtilDate.toSqlDate(ent.getStartDate())
        );
    }

    @Override
    public RentalContract toEntity(RentalContractDto dto) {
        try {
            if (dto == null) {
                return null;
            }

            return new RentalContract(
                    dto.getId(),
                    new CustomerMapper().toEntity(new CustomerDAO(DataBase.getConnection()).read(dto.getCustomer())),
                    new VehicleMapper().toEntity(new VehicleDAO(DataBase.getConnection()).read(dto.getVehicle())),
                    UtilDate.toLocalDate(dto.getStartDate()),
                    UtilDate.toLocalDate(dto.getEndDate())
            );
        } catch (SQLException ex) {
            Logger.getLogger(RentalContractMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RentalContractMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
