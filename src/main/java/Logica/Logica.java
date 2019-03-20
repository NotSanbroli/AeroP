/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Utilitarios.Avion;
import Utilitarios.Cliente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darkgrey93
 */
public class Logica {
    Map<Integer,Avion> aviones=new HashMap<Integer,Avion>();
    Map<Integer,Cliente> clientes=new HashMap<Integer,Cliente>();
    public static BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
    Avion avionVip=new Avion("VIP");
    
    
    public void agregarClientes(){
        System.out.println("Digite la informacion para agregar el cliente");
        System.out.println("Digite el nombre del cliente");
        String nombre="";
        int cedula=0;
        String fecha="";
        
        System.out.println("digite nombre");
        try {
            nombre = (entrada.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Digite la cedula del cliente");
        try {
            cedula = (Integer.parseInt(entrada.readLine()));
        } catch (IOException ex) {
            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("digite fecha de nacimiento");
        try {
            fecha = ((entrada.readLine()));
        } catch (IOException ex) {
            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        SimpleDateFormat fecha1=new SimpleDateFormat(fecha);
        Cliente nuevo=new Cliente(nombre,cedula,fecha1);
        clientes.put(cedula, nuevo);
    }
    
}
