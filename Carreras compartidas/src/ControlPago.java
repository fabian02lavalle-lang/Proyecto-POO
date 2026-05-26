/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.entidades.Conductor;
import Modelo.entidades.Viaje;
/**
 *
 * @author fabian lavalle
 */
public class ControlViaje {
    
    public Viaje crearViaje(String origen, String destino, String fecha, double costo, Conductor conductor){
     Viaje v =new Viaje(origen, destino, fecha, costo, conductor);
     return v;
    }
}
