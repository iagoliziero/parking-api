package br.com.fiap.main.client;

import br.com.fiap.dao.CarDAO;
import br.com.fiap.dao.ClientDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Car;
import br.com.fiap.dto.Client;

import java.sql.Connection;
import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.openConnection();
        Scanner sc = new Scanner(System.in);

        System.out.println("Which your name?");
        String name = sc.nextLine();

        System.out.println("Which your License Plate?");
        String licensePlate = sc.nextLine();

        Client client = new Client();
        client.setName(name);
        client.setLicensePlate(licensePlate);

        ClientDAO clientDAO = new ClientDAO(con);
        System.out.println(clientDAO.insertClient(client));

        ConnectionFactory.closeConnection(con);

    }
}
