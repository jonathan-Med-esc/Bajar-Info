/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EJ1;

import java.util.ArrayList;

/**
 *
 * @author jonathan.medesc
 */
public class MaestroPokemon {

    private String nombre;
    private Tipo rango;
    private String dni;
    private int numPokeball;
    private ArrayList<Pokemon> listPokemon = new ArrayList<Pokemon>();
    private Andarin pokemonFuera;

    public MaestroPokemon(String nombreIn, String dni, int numPokeball) {
        this.nombre = nombreIn;
        this.rango = Tipo.PRINCIPIANTE;
        this.dni = dni;
        this.numPokeball = 0;
        this.pokemonFuera = null;
    }

    @Override
    public String toString() {
        System.out.println("MaestroPokemon{" + "nombre=" + nombre + ", rango=" + rango + ", dni=" + dni + ", numPokeball=" + numPokeball + '}');
        verPokemon();
        return "";
    }
    
    public void verPokemon() {
        for (Pokemon po : listPokemon) {
            System.out.println(po.toString());
        }
    }
    

    public void setPokemonFuera(Andarin p) {
        if (this.pokemonFuera == null) {
            System.out.println("Has capturado a " + p.getNombre());
        } else {
            System.out.println("Ya tienes un pokemon capturado");
        }
    }

    public void perderPokemon() {
        if (this.pokemonFuera != null) {
            System.out.println("Has perdido a " + this.pokemonFuera.getNombre());
            this.pokemonFuera = null;
        } else {
            System.out.println("Ya lo has perdido antes");
        }
    }

    public void atacarMaestro(MaestroPokemon maestro) {

        System.out.println("Pelea pokemon entre " + this.nombre + " y " + maestro.getNombre());

        if (this.listPokemon.size() > maestro.listPokemon.size()) {
            System.out.println("Ha ganado " + this.getNombre());
            this.nextCategoria();
        } else if (maestro.listPokemon.size() > this.listPokemon.size()) {
            System.out.println("Ha ganado " + maestro.getNombre());
            maestro.nextCategoria();
        } else {
            System.out.println("Ha ocurrido empate");
        }

    }

    public void cojerPokeball(int numPokeballIn) {
        this.numPokeball += numPokeballIn;
        System.out.println("AHora tienes " + this.numPokeball);
    }

    public void capturarPokemon(Pokemon p) {

        if (this.numPokeball > 0) {
            this.listPokemon.add(p);
            this.numPokeball--;
        } else {
            System.out.println("No te quedan pokeball");
        }
    }

    public void ordenarPokemon() {

        Pokemon arrayP[] = new Pokemon[this.listPokemon.size()];

        for (int i = 0; i < arrayP.length; i++) {
            arrayP[i] = this.listPokemon.get(i);
        }

        for (int i = 0; i < arrayP.length - 1; i++) {
            for (int j = 0; j < arrayP.length - 1; j++) {
                if (arrayP[j].getAltura() > arrayP[j + 1].getAltura()) {
                    Pokemon aux = arrayP[j];
                    arrayP[j] = arrayP[j + 1];
                    arrayP[j + 1] = aux;
                }
            }

        }
        this.listPokemon.clear();
        for (int i = 0; i < arrayP.length; i++) {
            this.listPokemon.add(arrayP[i]);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getRango() {
        return rango;
    }

    public int getNumPokeball() {
        return numPokeball;
    }

    public void nextCategoria() {

        if (this.rango.equals("PRINCIPIANTE")) {
            System.out.println("Felizidades ahora eres " + Tipo.VETERANO.toString().toLowerCase());
            this.rango = Tipo.VETERANO;
        } else if (this.rango.equals("VETERANO")) {
            System.out.println("Felizidades ahora eres " + Tipo.CAMPEON.toString().toLowerCase());
            this.rango = Tipo.CAMPEON;
        } else {
            System.out.println("Ya eres campeon");
        }
    }

}

enum Tipo {
    PRINCIPIANTE, VETERANO, CAMPEON
}
