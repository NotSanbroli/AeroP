/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.util.Date;

/**
 *
 * @author Darkgrey93
 */
public class Cliente {
    private String nombre;
    private int cedula;
    private Date fechaNacimiento;

    public Cliente(String nombre, int cedula, Date fechaNacimiento) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

}
