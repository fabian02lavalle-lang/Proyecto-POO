/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.entidades;
import java.io.Serializable;

import java.util.ArrayList;

/**
 *
 * @author sebas
 */
public class Pasajero extends Usuario implements Serializable {
    
    private ArrayList<Reserva> reservas;

    public Pasajero(int id, String nombre) {
        super(id,nombre);
        this.reservas = new ArrayList();
    }

    @Override
    public String toString() {
        return "Pasajero{" + "reservas=" + reservas + '}';
    }

   public void reservarViaje(Viaje v){
       Reserva r = new Reserva(v,this);
       reservas.add(r);
       System.out.println("reserva hecha");
   }
    
    public void pagarReserva(int posicion){
       reservas.get(posicion).setEsPago(true);
        System.out.println("pago hecho");
    }
    
    
    
    public void verReserva(){
        for(Reserva r : reservas){
        System.out.println(r);
        }
    }
    
    @Override
    public void mostrarRol(){
        System.out.println("soy un pasajero");
    }
    
    public void reservarViaje(){
        
    }
    
    public void pagaReserva(Reserva re){
        
    }
    
}
