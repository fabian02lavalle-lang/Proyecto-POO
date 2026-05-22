/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author sebas
 */
public class Vehiculo {
    private String placa;
    private String modelo;
    private int puestos;

    public Vehiculo(String placa, String modelo, int puestos) {
        this.placa = placa;
        this.modelo = modelo;
        this.puestos = puestos;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", modelo=" + modelo + ", puestos=" + puestos + '}';
    }
    
    

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the puestos
     */
    public int getPuestos() {
        return puestos;
    }

    /**
     * @param puestos the puestos to set
     */
    public void setPuestos(int puestos) {
        this.puestos = puestos;
    }
}
