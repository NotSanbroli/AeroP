/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Utilitarios.Avion;
import Utilitarios.AvionEco;
import Utilitarios.AvionMix;
import Utilitarios.AvionVip;
import Utilitarios.Cliente;

import Utilitarios.Silla;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darkgrey93
 */
public class Logica {
    Map<Integer,Avion> aviones;
    Map<Integer,Cliente> clientes;
    public static BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
    //Avion avionVip=new Avion("VIP");
    
    AvionVip avip=new AvionVip("AvionVip");
    AvionMix amix=new AvionMix("AvionMix");
    AvionEco aeco=new AvionEco("AvionEco");
    
    int i=0;
    String puesto=" ";


    public Logica() throws IOException {
        aviones=new HashMap<Integer,Avion>();
        clientes=new HashMap<Integer,Cliente>();
        aviones.put(1, avip);
        aviones.put(2, amix);
        aviones.put(3, aeco);
        /*avip.getSillas().get("A1").setComprada(true);
        aeco.getSillas().get("C1").setComprada(true);
        amix.getSillas().get("F1").setComprada(true);
        avip.getSillas().get("A2").setComprada(true); pruebas para ocupar sillas
        amix.getSillas().get("C5").setComprada(true);
        aeco.getSillas().get("F4").setComprada(true);*/
            
        
                    
        
        menuAviones();
                
    }  
    
    public void menuAviones() {
    System.out.print("Que avion desea comprar?\n"+"Avion Vip 1.\n"
            + "Avion Mixto 2.\n"
            + "Avion Economico 3.\n"
            +"Despegar aviones 4.\n"
            + "Salir 0.\n");
    Integer cedula=0;
    String silla="";
    try{
    int opcion=Integer.parseInt(entrada.readLine());
    switch(opcion){
        case 1:
            imprimirAvionVip();
            cedula=recogerUsuario();
            silla=recogerSilla();
            comprarSillaVip(silla, cedula);
            menuAviones();
            break;
        case 2:
            imprimirAvionMixto();
            cedula=recogerUsuario();
            silla=recogerSilla();
            comprarSillaMix(silla, cedula);
            menuAviones();
            break;
        case 3:
            imprimirAvionEco();
            cedula=recogerUsuario();
            silla=recogerSilla();
            comprarSillaEco(silla, cedula);
            menuAviones();
            break;
        case 4:
            System.out.println("avion vip\n"+avip.calcularVuelo()+"\n");
            System.out.println("avion mixto\n"+amix.calcularVuelo()+"\n");
            System.out.println("avion economico\n"+aeco.calcularVuelo()+"\n");
            break;
        case 0:
            System.out.println("terminando programa...");
            System.exit(0);
             break;
        default:
            System.out.println("Opcion incorrecta intente otra vez");
            menuAviones();
    }
    }catch(Exception ex){
            System.out.println("Escriba un numero");
            menuAviones();
            }
    
    
    }
    public String recogerSilla(){
        String silla="";
        System.out.println("Digite la silla que desea ocupar el cliente\n");
        try{
           silla=entrada.readLine();
         }catch(Exception ex){
             System.out.println(ex);
         }
        return silla;
    }
    public Integer recogerUsuario(){
        Integer cedula=0;
        System.out.println("Digite la identificacion del cliente\n");
        try{
           cedula=Integer.parseInt(entrada.readLine());
         }catch(Exception ex){
             System.out.println(ex);
         }
        return cedula;
    }
    public void comprarSillaEco(String code,Integer id){
        if(!clientes.containsKey(id)){
            System.out.println("No existe el cliente con la identificacion: "+id);
            menuAviones();
        }
        Cliente comprador = clientes.get(id);
        if(!aeco.getSillas().containsKey(code)){
            System.out.println("silla no encotrada intente con otra");
        }
            
        aeco.getSillas().get(code).setPersona(comprador);
        aeco.getSillas().get(code).setComprada(true);
    }
    public void comprarSillaVip(String code,Integer id){
        if(!clientes.containsKey(id)){
            System.out.println("No existe el cliente con la identificacion: "+id);
            menuAviones();
        }
        Cliente comprador = clientes.get(id);
        if(!avip.getSillas().containsKey(code)){
            System.out.println("silla no encotrada intente con otra");
        }
            
        avip.getSillas().get(code).setPersona(comprador);
        avip.getSillas().get(code).setComprada(true);
    }
    public void comprarSillaMix(String code,Integer id){
        if(!clientes.containsKey(id)){
            System.out.println("No existe el cliente con la identificacion: "+id);
            menuAviones();
        }
        Cliente comprador = clientes.get(id);
        if(!amix.getSillas().containsKey(code)){
            System.out.println("silla no encotrada intente con otra");
        }
            
        amix.getSillas().get(code).setPersona(comprador);
        amix.getSillas().get(code).setComprada(true);
    }
    
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

    private void imprimirAvionMixto() {
        
        Map<String, Silla> treeMap = new TreeMap<String, Silla>(amix.getSillas());
        Set<String> llaves = treeMap.keySet();
        System.out.println("      /\\");
        System.out.println("     /  \\");
        System.out.println("    /    \\");
        System.out.println("   /      \\");
        System.out.println("  /        \\");
        System.out.println(" /          \\");
        System.out.println("/____________\\");
        System.out.println("|             |");
        
        for(String llav : llaves){
        if(treeMap.get(llav).isComprada()){
            treeMap.get(llav).setNombre("XX");
            }
        }
        
        for(String llav : llaves){
            if(treeMap.get(llav).isVip()){
                puesto+=treeMap.get(llav).getNombre()+"       ";
                System.out.print(puesto);
                i++;
                if(i==1){
                puesto=" ";
                }
                if(i>1){
                    System.out.println();
                    i=0;
                    puesto=" ";
            }
            }
           
        }
        
        System.out.println("|              |___________");
        System.out.println("|              |           \\");
        System.out.println("|              |___________/");
        for(String llav : llaves){
            if(treeMap.get(llav).isVip()){
                
            }
            else{
            puesto+=treeMap.get(llav).getNombre();
                System.out.print(puesto);
                i++;
                puesto="";
                if(i==3){
                puesto=" ";
                }
                if(i>5){
                    System.out.println();
                    i=0;
                    puesto=" ";
            }
            }
           
        }
        System.out.println("\n|              |");
        System.out.println("|              |");
    }

    private void imprimirAvionVip() {
         Map<String, Silla> treeMap = new TreeMap<String, Silla>(avip.getSillas());
        Set<String> llaves = treeMap.keySet();
        System.out.println("      /\\");
        System.out.println("     /  \\");
        System.out.println("    /    \\");
        System.out.println("   /      \\");
        System.out.println("  /        \\");
        System.out.println(" /          \\");
        System.out.println("/____________\\");
        System.out.println("|             |");
        System.out.println("|              |___________");
        System.out.println("|              |           \\");
        System.out.println("|              |___________/");
        for(String llav : llaves){
        if(treeMap.get(llav).isComprada()){
            treeMap.get(llav).setNombre("XX");
            }
        }
        
        for(String llav : llaves){
            if(treeMap.get(llav).isVip()){
                puesto+=treeMap.get(llav).getNombre()+"       ";
                System.out.print(puesto);
                i++;
                if(i==1){
                puesto=" ";
                }
                if(i>1){
                    System.out.println();
                    i=0;
                    puesto=" ";
            }
            }
           
        }
        System.out.println("\n|              |");
        System.out.println("|              |");
    }

    private void imprimirAvionEco() {
      Map<String, Silla> treeMap = new TreeMap<String, Silla>(aeco.getSillas());
        Set<String> llaves = treeMap.keySet();
        System.out.println("      /\\");
        System.out.println("     /  \\");
        System.out.println("    /    \\");
        System.out.println("   /      \\");
        System.out.println("  /        \\");
        System.out.println(" /          \\");
        System.out.println("/____________\\");
        System.out.println("|             |");
        System.out.println("|              |___________");
        System.out.println("|              |           \\");
        System.out.println("|              |___________/");
        for(String llav : llaves){
        if(treeMap.get(llav).isComprada()){
            treeMap.get(llav).setNombre("XX");
            }
        }
        for(String llav : llaves){
            if(treeMap.get(llav).isVip()){
                
            }
            else{
            puesto+=treeMap.get(llav).getNombre();
                System.out.print(puesto);
                i++;
                puesto="";
                if(i==3){
                puesto=" ";
                }
                if(i>5){
                    System.out.println();
                    i=0;
                    puesto=" ";
            }
            }
        }
        System.out.println("\n|              |");
        System.out.println("|              |");
    }
}
