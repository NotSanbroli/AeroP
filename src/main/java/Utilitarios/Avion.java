/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.util.HashMap;

/**
 *
 * @author fetec
 */
public class Avion {
    
    private String nombre;
    HashMap<Integer,Silla> sillas;
    private boolean volando=false;

    public Avion(String nombre) {
        this.nombre = nombre;
        sillas=new HashMap();
    }
    
    
}
