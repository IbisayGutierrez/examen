/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author 9567
 */
public abstract class DaoCRUD<Dto> extends DaoCRD<Dto> {

    public DaoCRUD(Connection connection) {
        super(connection);
    }

    public abstract boolean update(Dto dto) throws SQLException;

}
