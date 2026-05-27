/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.entidades;
import java.io.Serializable;

/**
 *
 * @author sebas
 */
public class Reserva implements Serializable {
    
    private Viaje viaje;
    private Pago pago;
    private Pasajero pasajero;
    

    public Reserva(Viaje viaje,Pasajero pas) {
        this.viaje = viaje;
        this.pago = new Pago();
        this.pasajero = pas;
    }

    @Override
    public String toString() {
        return "Reserva{" + "viaje=" + viaje + ", pago=" + pago + ", pasajero=" + pasajero + '}';
    }

  


   
    
    public void generarPago(){
        pago.setEsPago(true);
    }

    /**
     * @return the esPago
     */
    public boolean estaPago() {
        return pago.isEsPago();
    }

    /**
     * @param esPago the esPago to set
     */
    public void setEsPago(boolean esPago) {
        this.pago.setEsPago(esPago); 
    }

    /**
     * @return the viaje
     */
    public Viaje getViaje() {
        return viaje;
    }

    /**
     * @param viaje the viaje to set
     */
    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    /**
     * @return the pasajero
     */
    public Pasajero getPasajero() {
        return pasajero;
    }
    
    
}
