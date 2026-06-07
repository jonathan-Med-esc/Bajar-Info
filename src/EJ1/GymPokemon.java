/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ1;

import java.util.ArrayList;

/**
 *
 * @author jonathan.medesc
 */
public class GymPokemon {
    public static void main(String[] args) {
        
        
        System.out.println("asdasdasd");
        
        MaestroPokemon m1 = new MaestroPokemon("jhoin", "asdas123", 10000);
        MaestroPokemon m2 = new MaestroPokemon("ale", "1234asdq", 1234);
        
        System.out.println(m1);
        System.out.println(m2);
        
        Pokemon p1 = new Pokemon();
        System.out.println(p1);
        Pokemon p2 = new Pokemon();
        
        m1.capturarPokemon(new Pokemon());
        m2.capturarPokemon(p2);
        
        
        m1.atacarMaestro(m2);
        m1.ordenarPokemon();
        
        
        
        
        System.out.println(p2);
        
    }
}
