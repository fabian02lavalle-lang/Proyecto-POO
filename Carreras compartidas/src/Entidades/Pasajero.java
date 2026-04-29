/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author sebas
 */
public class Pasajero extends Usuario {
    
    ArrayList<Reserva> reservas;

    public Pasajero(ArrayList<Reserva> reservas, String nombre) {
        super(nombre);
        this.reservas = new ArrayList();
    }

    @Override
    public String toString() {
        return "Pasajero{" + "reservas=" + reservas + '}';
    }
    
    
    
    public void verViajes(){
        System.out.println("{" +"}");
    }
    
    public void reservarViaje(){
        
    }
    
    public void pagaReserva(Reserva re){
        
    }
    
}
