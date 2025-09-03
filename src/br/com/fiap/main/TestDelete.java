package br.com.fiap.main;

import br.com.fiap.dao.CarDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Car;

import java.sql.Connection;

public class TestDelete {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.openConnection();

        Car car = new Car();

        car.setLicensePlate("BDS1876");

        CarDAO carDAO = new CarDAO(con);
        System.out.println(carDAO.deleteCar(car));

        ConnectionFactory.closeConnection(con);
    }
}
