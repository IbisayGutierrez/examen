/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.RentalContract;

import Model.Dao.DaoCRUD;
import Model.Vehicle.VehicleDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 9567
 */
public class RentalContractDAO extends DaoCRUD<RentalContractDto>{

    public RentalContractDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(RentalContractDto dto) throws SQLException {
        stmt = connection.prepareStatement("call RentalContractCreate(?,?,?,?)");
        stmt.setString(1, dto.getCustomer());
        stmt.setString(2, dto.getVehicle());
        stmt.setDouble(3, dto.getDailyRate());
        stmt.setDate(4, dto.getStartDate());
        return stmt.executeUpdate()>0;
    }

    @Override
    public RentalContractDto read(Object id) throws SQLException {
        stmt = connection.prepareStatement("call RentalContractRead(?)");
        stmt.setInt(1, Integer.parseInt(String.valueOf(id)));
        rs = stmt.executeQuery();
        if(rs.next()){
            return new RentalContractDto(
                    rs.getInt(1), 
                    rs.getString(2),
                    rs.getString(3), 
                    rs.getDouble(4), 
                    rs.getDate(5), 
                    rs.getDate(6)
            );
        }
        return null;
    }

    @Override
    public List<RentalContractDto> readAll() throws SQLException {
        stmt = connection.prepareStatement("call RentalContractReadAll()");
        rs = stmt.executeQuery();
        List<RentalContractDto> dtos = new ArrayList();
        while(rs.next()){
            dtos.add(new RentalContractDto(
                    rs.getInt(1), 
                    rs.getString(2),
                    rs.getString(3), 
                    rs.getDouble(4), 
                    rs.getDate(5), 
                    rs.getDate(6)
            ));
        }
        return dtos;
    }

    @Override
    public boolean update(RentalContractDto dto) throws SQLException {
        stmt = connection.prepareStatement("call RentalContractUpdate(?, ?)");
        stmt.setInt(1, dto.getId());
        stmt.setDate(2, dto.getEndDate());
        return stmt.executeUpdate()>0;
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        stmt = connection.prepareStatement("call RentalContractDelete(?)");
        stmt.setInt(1, Integer.parseInt(String.valueOf(id)));
        return stmt.executeUpdate()>0;
    }
    
}
