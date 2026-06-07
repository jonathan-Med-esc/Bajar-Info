/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej3;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author jonathan.medesc
 */
public class Consultas {

    public static void main(String[] args) {

        int contador = 1;
        ArrayList<Double> listAltura = new ArrayList<>();
        double total = 0;
        HashSet<Double> listPeso = new HashSet<>();
        ArrayList<String> listNombre = new ArrayList<>();

        try {
            //se incluye JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            //se conecta
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/pokemon", "root", "");
            //sesión
            Statement stmt = conn.createStatement();
            //resultSet
            ResultSet rs = stmt.executeQuery("SELECT * FROM pokemon");

            System.out.println("Datos del pokemon Numero 5");
            while (rs.next()) {
                if (contador == 5) {
                    System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
                }

                listAltura.add(Double.parseDouble(rs.getString(6)));
                listPeso.add(Double.parseDouble(rs.getString(5)));
                listNombre.add(rs.getString(2));
                contador++;
            }

            //tijeras
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException esql) {
            System.out.println("Error SQL: " + esql);
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e);
        }

        for (int i = 0; i < listAltura.size(); i++) {
            total += listAltura.get(i);
        }
        System.out.println("Suma total de altura " + total);

        System.out.println("\nLista de peso sin repetidos");
        System.out.println(listPeso);

        System.out.println("Nombre palindromos");

        for (int i = 0; i < listNombre.size(); i++) {
            
            if (listNombre.get(i).charAt(i) == listNombre.get(i).charAt(i)){
                
            }
        }

    }
}
