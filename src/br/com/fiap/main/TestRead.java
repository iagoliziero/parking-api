package br.com.fiap.main;

import br.com.fiap.dao.CarDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Car;

import java.sql.Connection;
import java.util.ArrayList;

public class TestRead {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.openConnection();

        CarDAO carDAO = new CarDAO(con);
        ArrayList<Car> result = carDAO.allListCar();

        if(result != null) {
            for(Car car : result) {
                System.out.printf("License Plate: %s \nColor: %s \nDescription: %s \n", car.getLicensePlate(), car.getColor(), car.getDescription());
            }
        }

        ConnectionFactory.closeConnection(con);
    }
}
