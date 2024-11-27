/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Vehicle;

import Model.Customer.CustomerDTO;  
import Model.Dao.DaoCRUD;
import java.nio.MappedByteBuffer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 9567
 */
public class VehicleDAO extends DaoCRUD<VehicleDTO>{

    public VehicleDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(VehicleDTO dto) throws SQLException {
        stmt = connection.prepareStatement("call VehicleCreate(?,?,?,?,?,?)");
        stmt.setString(1, dto.getLicensePlate());
        stmt.setString(2, dto.getBrand());
        stmt.setString(3, dto.getModel());
        stmt.setInt(4, dto.getYear());
        stmt.setDouble(5, dto.getDailyRate());
        stmt.setBoolean(6, dto.isAvailable());
        return stmt.executeUpdate()>0;
    }

    @Override
    public VehicleDTO read(Object id) throws SQLException {
        stmt = connection.prepareStatement("call VehicleRead(?)");
        stmt.setString(1,String.valueOf(id));
        rs = stmt.executeQuery();
        if(rs.next()){
            return new VehicleDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getDouble(5),
                    rs.getBoolean(6)
            );
        }
        return null;
    }

    @Override
    public List<VehicleDTO> readAll() throws SQLException {
        stmt = connection.prepareStatement("call VehicleReadAll()");
        rs = stmt.executeQuery();
        List<VehicleDTO> dtos = new ArrayList();
        while(rs.next()){
            dtos.add(new VehicleDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getDouble(5),
                    rs.getBoolean(6)
            ));
        }
        return dtos;
    }

    @Override
    public boolean update(VehicleDTO dto) throws SQLException {
        stmt = connection.prepareStatement("call VehicleUpdate(?,?,?)");
        stmt.setString(1, dto.getLicensePlate());
        stmt.setDouble(2, dto.getDailyRate());
        stmt.setBoolean(3, dto.isAvailable());
        return stmt.executeUpdate()>0;
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        stmt = connection.prepareStatement("call VehicleDelete(?)");
        stmt.setString(1, String.valueOf(id));
        return stmt.executeUpdate()>0;
    }
    
}
