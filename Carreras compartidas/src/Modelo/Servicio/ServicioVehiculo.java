/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Servicio;
import Modelo.Persistencia.DaoViaje;
import Modelo.entidades.Conductor;
import Modelo.entidades.Viaje;
import java.io.IOException;


/**
 *
 * @author sebas
 */
public class ServicioViaje {
    
    DaoViaje dao=new DaoViaje();
    
    public boolean guardar(String origen, String destino, String fecha, double costo, Conductor conductor){
            try {
                Viaje libro=new Viaje(origen,destino,fecha,costo,conductor);
                dao.guardar(libro);
                return true;
            } catch (IOException ex) {
                System.out.println(" "+ex.getMessage()); 
            } catch (ClassNotFoundException ex) {
                System.out.println(" "+ex.getMessage());
            }
            return false;
        }
    
}
