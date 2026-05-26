/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.entidades.Vehiculo;
/**
 *
 * @author fabian lavalle
 */
public class ControlVehiculo {
    
    public Vehiculo crearVehiculo(String placa, String modelo, int puestos){
      
        
       Vehiculo v = new Vehiculo(placa, modelo, puestos);
               return v;
    }
}
