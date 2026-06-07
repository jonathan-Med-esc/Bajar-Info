/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJ2;

import java.io.Serializable;

/**
 *
 * @author jonathan.medesc
 */
public class Vago extends Pokemon implements Serializable {

    public Vago() {
        super();
    }

  

    @Override
    public String hablar() {
        return "Duerme zzz";
    }

}
