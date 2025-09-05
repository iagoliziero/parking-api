package br.com.fiap.main.client;

import br.com.fiap.dao.CarDAO;
import br.com.fiap.dao.ClientDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Car;
import br.com.fiap.dto.Client;

import java.sql.Connection;
import java.util.Scanner;

public class TestDeleteClient {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.openConnection();
        Client client = new Client();
        Scanner sc = new Scanner(System.in);

        System.out.println("\"Who do you want to delete? Choose from ID\"");
        int id = sc.nextInt();
        client.setId(id);

        ClientDAO clientDAO = new ClientDAO(con);
        System.out.println(clientDAO.deleteClient(client));

        ConnectionFactory.closeConnection(con);
    }
}
