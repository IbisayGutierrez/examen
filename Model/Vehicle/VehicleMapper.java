/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Vehicle;

import Model.Mapper.Mapper;

/**
 *
 * @author 9567
 */
public class VehicleMapper implements Mapper<Vehicle, VehicleDTO>{

    @Override
    public VehicleDTO toDto(Vehicle ent) {
        if(ent==null) return null;
        return new VehicleDTO(
                ent.getLicensePlate(), 
                ent.getBrand(), 
                ent.getModel(), 
                ent.getYear(), 
                ent.getDailyRate(), 
                ent.isAvailable()
        );
    }

    @Override
    public Vehicle toEntity(VehicleDTO dto) {
        if(dto==null) return null;
        return new Vehicle(
                dto.getLicensePlate(),
                dto.getBrand(), 
                dto.getBrand(), 
                dto.getYear(), 
                dto.getDailyRate(), 
                dto.isAvailable()
        );
    }
    
}
