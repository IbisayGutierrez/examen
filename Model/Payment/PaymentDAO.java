/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Payment;

import Model.Dao.DaoCRD;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofia
 */
public class PaymentDAO extends DaoCRD<PaymentDTO> {

    public PaymentDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(PaymentDTO dto) throws SQLException {
        stmt = connection.prepareStatement("call PaymentCreate(?,?,?,?)");
        stmt.setInt(1, dto.getRentalContract());
        stmt.setDouble(2, dto.getAmount());
        stmt.setString(3, dto.getPaymentMethod());
        stmt.setDate(4, dto.getDate());
        return stmt.executeUpdate() > 0;
    }

    @Override
    public PaymentDTO read(Object id) throws SQLException {
        stmt = connection.prepareStatement("call PaymentRead(?)");
        stmt.setInt(1, Integer.parseInt(String.valueOf(id)));
        rs = stmt.executeQuery();
        if (rs.next()) {
            return new PaymentDTO(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getDouble(3),
                    rs.getString(4),
                    rs.getDate(5)
            );
        }
        return null;
    }

    @Override
    public List<PaymentDTO> readAll() throws SQLException {
        stmt = connection.prepareStatement("call PaymentReadAll()");
        rs = stmt.executeQuery();
        List<PaymentDTO> dtos = new ArrayList();
        while (rs.next()) {
            dtos.add(new PaymentDTO(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getDouble(3),
                    rs.getString(4),
                    rs.getDate(5)
            ));
        }
        return dtos;
    }


    @Override
    public boolean delete(Object id) throws SQLException {
        stmt = connection.prepareStatement("call PaymentDelete(?)");
        stmt.setInt(1, Integer.parseInt(String.valueOf(id)));
        return stmt.executeUpdate() > 0;
    }

}
