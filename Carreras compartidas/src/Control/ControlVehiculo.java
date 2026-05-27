/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.entidades.Conductor;
import Modelo.entidades.Vehiculo;

/**
 *
 * @author fabian lavalle
 */
public class ControlConductor {
    
     public Conductor crearConductor(int id, String nombre, Vehiculo v){
      
      Conductor c = new Conductor(id, nombre, v);
      return c;
    }
}
