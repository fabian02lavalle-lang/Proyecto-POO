/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Servicio;
import Modelo.Persistencia.DaoVehiculo;
import Modelo.entidades.Vehiculo;
import java.io.IOException;


/**
 *
 * @author sebas
 */
public class ServicioVehiculo {
    
    DaoVehiculo dao=new DaoVehiculo();
    
    public boolean guardar(String placa, String modelo, int puestos){
            try {
                Vehiculo libro=new Vehiculo(placa,modelo,puestos);
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
