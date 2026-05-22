/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author ESTUDIANTES
 */
public class Conductor extends Usuario {
    
    private Vehiculo vehiculo;
    private ArrayList<Viaje> viajes;
    
    public Conductor(int id,String nombre,Vehiculo v) {
        super(id,nombre);
        this.vehiculo = v;
        this.viajes = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Conductor{" + "vehiculo=" + vehiculo + ", viajes=" + viajes + '}';
    }
    
    public void PublicarViaje(Viaje v){
        viajes.add(v);
        System.out.println("viaje pullcado");
    }
    
    @Override
    public void mostrarRol(){
        System.out.println("soy un conductor");
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }
    
   

}
