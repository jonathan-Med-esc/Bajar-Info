/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonathan.medesc
 */
public class GymPokemon {

    public static void main(String[] args) {

        System.out.println("asdasdasd");

        MaestroPokemon m1 = new MaestroPokemon("jhoin", "asdas123", 10000);
        MaestroPokemon m2 = new MaestroPokemon("ale", "1234asdq", 1234);

        ArrayList<Pokemon> listP = new ArrayList<>();

        File fi = new File("fichero_pakemon_exam.txt");
        File f2 = new File("Pokemon.txt");

        Pokemon p1 = new Pokemon(fi);
        Pokemon p2 = new Pokemon(fi);
        Pokemon p3 = new Pokemon(fi);

        HashSet<Pokemon> listPokemon = new HashSet<>();

        listPokemon.add(p1);
        listPokemon.add(p2);
        listPokemon.add(p3);

        //guardarPokemon(f2, listPokemon);
        listP = cargarPokemon(f2);

        // cargarPokemon(f2);
        System.out.println("\nPokemones serializados");
        System.out.println(listP);
    }

    public static void guardarPokemon(File fIn, HashSet<Pokemon> list) {
        FileOutputStream fileOut = null;
        ObjectOutputStream objectOut = null;

        try {

            fileOut = new FileOutputStream(fIn, true);
            objectOut = new ObjectOutputStream(fileOut);

            for (Pokemon po : list) {
                objectOut.writeObject(po);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                objectOut.close();
                fileOut.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }

    public static ArrayList<Pokemon> cargarPokemon(File fIn) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        ArrayList<Pokemon> list = new ArrayList<>();

        try {
            fis = new FileInputStream(fIn);
            ois = new ObjectInputStream(fis);

            while (true) {

                try {

                    Pokemon p = (Pokemon) ois.readObject();
                    list.add(p);

                } catch (Exception e) {
                    System.out.println("Se han cargado todos los personajes");
                    break;
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return list;

    }
}
