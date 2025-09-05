package br.com.fiap.main.car;

import br.com.fiap.dao.CarDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Car;

import java.sql.Connection;
import java.util.Scanner;

public class TestCar {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.openConnection();
        Scanner sc = new Scanner(System.in);

        System.out.println("Which License Plate?");
        String licensePlate = sc.nextLine();

        System.out.println("Which color?");
        String color = sc.nextLine();

        System.out.println("Which Description?");
        String description = sc.nextLine();

        Car car = new Car();
        car.setLicensePlate(licensePlate);
        car.setColor(color);
        car.setDescription(description);

        CarDAO carDAO = new CarDAO(con);
        System.out.println(carDAO.insertCar(car));

        ConnectionFactory.closeConnection(con);

    }
}
