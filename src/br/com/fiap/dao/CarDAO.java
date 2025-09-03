package br.com.fiap.dao;

import br.com.fiap.dto.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarDAO {
    private Connection con;

    public CarDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String insertCar(Car car) {
        String sql = "INSERT INTO car (license_plate, color, description) VALUES(?,?,?)";
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

    public String updateCar(Car car) {
        String sql = "UPDATE car set color = ?, description = ? WHERE license_plate = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, car.getColor());
            ps.setString(2, car.getDescription());
            ps.setString(3, car.getLicensePlate());

            if(ps.executeUpdate() > 0) {
                return "Insert sucess";
            } else {
                return "Insert error";
            }

        } catch (SQLException e) {
            return "SQL error:" + e.getMessage();
        }
    }

    public String deleteCar(Car car) {
        String sql = "DELETE FROM car WHERE license_plate = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, car.getLicensePlate());
            if(ps.executeUpdate() > 0) {
                return "Insert sucess";
            } else {
                return "Insert error";
            }

        } catch (SQLException e) {
            return "SQL error:" + e.getMessage();
        }
    }

    public ArrayList<Car> allListCar() {
        String sql = "SELECT * FROM car ORDER BY license_plate";
        ArrayList<Car> listCar = new ArrayList<>();

        try(PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            if(rs != null) {
                while (rs.next()) {
                    Car car = new Car();
                    car.setLicensePlate(rs.getString(1));
                    car.setColor(rs.getString(2));
                    car.setDescription(rs.getString(3));
                    listCar.add(car);
                }

                return listCar;

            }  else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("SQL error:" + e.getMessage());
            return null;
        }
    }

}
