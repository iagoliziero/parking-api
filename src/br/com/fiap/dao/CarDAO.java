package br.com.fiap.dao;

import br.com.fiap.dto.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarDAO {
    private Connection con;

    public CarDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String insertCar(Car car) {
        String sql = "INSERT INTO ddd_car(licensePlate, color, description) VALUES(?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, car.getLicensePlate());
            ps.setString(2, car.getColor());
            ps.setString(3, car.getDescription());

            if(ps.executeUpdate() > 0) {
                return "Insert sucess";
            } else {
                return "Insert error";
            }
        } catch (SQLException e) {
           return "SQL error:" + e.getMessage();
        }
    }
}
