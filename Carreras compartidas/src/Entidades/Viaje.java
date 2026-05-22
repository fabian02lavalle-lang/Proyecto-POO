/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author sebas
 */
public class Viaje {
    private String origen;
    private String destino;
    private String fecha;
    private double costo;
    private Conductor conductor;

    public Viaje(String origen, String destino, String fecha, double costo, Conductor conductor) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.costo = costo;
        this.conductor = conductor;
    }

    @Override
    public String toString() {
        return "Viaje{" + "origen=" + origen + ", destino=" + destino + ", fecha=" + fecha + ", costo=" + costo + ", conductor=" + conductor + '}';
    }
    
    

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * @return the conductor
     */
    public Conductor getConductor() {
        return conductor;
    }

    /**
     * @param conductor the conductor to set
     */
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}
