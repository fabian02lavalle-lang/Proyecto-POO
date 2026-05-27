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
public class Pago implements Serializable {
    private boolean esPago;

    public Pago() {
        this.esPago = false;
    }

    @Override
    public String toString() {
        return "Pago{" + "esPago=" + esPago + '}';
    }
    
    

    /**
     * @return the esPago
     */
    public boolean isEsPago() {
        return esPago;
    }

    /**
     * @param esPago the esPago to set
     */
    public void setEsPago(boolean esPago) {
        this.esPago = esPago;
    }
    
    
}
