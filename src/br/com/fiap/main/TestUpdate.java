package br.com.fiap.main;

import br.com.fiap.dao.CarDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Car;

import java.sql.Connection;

public class TestUpdate {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.openConnection();

        Car car = new Car();

        car.setLicensePlate("BDS1876");
        car.setColor("Black");
        car.setDescription("Civic");

        CarDAO carDAO = new CarDAO(con);
        System.out.println(carDAO.updateCar(car));

        ConnectionFactory.closeConnection(con);
    }
}
