/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author sebas
 */
public class Reserva {
    
    private Viaje viaje;
    private Pago pago;
    

    public Reserva(Viaje viaje) {
        this.viaje = viaje;
        this.pago = new Pago();
    }

    @Override
    public String toString() {
        return "Reserva{" + "viaje=" + getViaje() + ", pago=" + pago + '}';
    }


   
    
    public void generarPago(){
        
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
    
    
}
