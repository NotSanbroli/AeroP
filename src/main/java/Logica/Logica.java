/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Utilitarios.Avion;
import Utilitarios.Cliente;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Darkgrey93
 */
public class Logica {
    Map<Integer,Avion> aviones=new HashMap<Integer,Avion>();
    Map<Integer,Cliente> clientes=new HashMap<Integer,Cliente>();
    Avion avionVip=new Avion("VIP");
    
    
    public void agregarClientes(){
        System.out.println("Digite la informacion para agregar el cliente");
    }
    
}
