/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ1;

import java.util.HashSet;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author jonathan.medesc
 */
public class Pokemon {

    private int id;
    private String nombre;
    private String tipo;
    private String onomatopeya;
    private double peso;
    private double altura;
    private static HashSet<Integer> listId = new HashSet<>();

    public Pokemon() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int contador = 0;
        String sql = "SELECT * FROM pokemon";
        int tipoId = 0;
        int comprobarId = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //se conecta
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/pokemon", "root", "");
            //sesión
            Statement stmt = conn.createStatement();
            //resultSet
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Elije el pokemon que quieras");

            while (rs.next()) {
                System.out.println("ID " + rs.getString(1) + " Nombre " + rs.getString(2));
                contador++;
            }
            rs.close();

            while (true) {
                opcion = sc.nextInt();
                if (opcion < 0 || opcion > contador) {
                    System.out.println("Valor erroneo intente de nuevo");
                } else {
                    break;
                }
            }

            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                comprobarId = Integer.parseInt(rs.getString(1));

                if (this.listId.add(comprobarId)) {
                    this.id = comprobarId;
                } else {
                    this.id = 0;
                }

                if (Integer.parseInt(rs.getString(1)) == opcion) {
                    this.nombre = rs.getString(2);
                    this.onomatopeya = rs.getString(4);
                    this.peso = Double.valueOf(rs.getString(5));
                    this.altura =  Double.valueOf(rs.getString(6));
                    tipoId = Integer.parseInt(rs.getString(3));
                    break;
                }

            }

            rs.close();
            rs = stmt.executeQuery("SELECT * FROM tipos");

            while (rs.next()) {

                if (comprobarId == Integer.parseInt(rs.getString(1))) {
                    this.tipo = rs.getString(2);
                    break;
                }

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException esql) {
            System.out.println("Error SQL: " + esql);
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e);
        }

    }

    public void atacarPokemon(Pokemon p) {

        System.out.println("Pelea pokemon " + this.getNombre() + " Ataca a " + p.getNombre());

        if (this.peso > p.getPeso()) {
            System.out.println("Ha ganado " + this.getNombre());
        } else if (this.peso < p.getPeso()) {
            System.out.println("Ha ganado " + p.getNombre());
        } else {
            System.out.println("Ha ganado " + p.getNombre());
        }
    }

    public String hablar() {
        return this.onomatopeya;
    }

    @Override
    public String toString() {
        return "Pokemon " + "nombre: " + nombre + " id: " + id + " onomatopeya: " + onomatopeya + " peso: " + peso + " altura: " + altura;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

}
