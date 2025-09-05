package br.com.fiap.dao;

import br.com.fiap.dto.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAO {
    private Connection con;

    public ClientDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String insertClient(Client client) {
        String sql = "INSERT INTO clients (name, license_plate) VALUES(?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, client.getName());
            ps.setString(2, client.getLicensePlate());

            if(ps.executeUpdate() > 0) {
                return "Insert sucess";
            } else {
                return "Insert error";
            }
        } catch (SQLException e) {
            return "SQL error:" + e.getMessage();
        }
    }

    public String updateClient(Client client) {
        String sql = "UPDATE clients SET name = ?, license_plate = ? WHERE id = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, client.getName());
            ps.setString(2, client.getLicensePlate());
            ps.setInt(3, client.getId());

            if(ps.executeUpdate() > 0) {
                return "Insert sucess";
            } else {
                return "Insert error";
            }

        } catch (SQLException e) {
            return "SQL error:" + e.getMessage();
        }
    }

    public String deleteClient(Client client) {
        String sql = "DELETE FROM clients WHERE id = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setInt(1, client.getId());
            if(ps.executeUpdate() > 0) {
                return "Insert sucess";
            } else {
                return "Insert error";
            }

        } catch (SQLException e) {
            return "SQL error:" + e.getMessage();
        }
    }

    public ArrayList<Client> allListClient() {
        String sql = "SELECT * FROM clients ORDER BY id";
        ArrayList<Client> listClient = new ArrayList<>();

        try(PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            if(rs != null) {
                while (rs.next()) {
                    Client client = new Client();
                    client.setId(rs.getInt(1));
                    client.setName(rs.getString(2));
                    client.setLicensePlate(rs.getString(3));
                    listClient.add(client);
                }

                return listClient;

            }  else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("SQL error:" + e.getMessage());
            return null;
        }
    }

}
