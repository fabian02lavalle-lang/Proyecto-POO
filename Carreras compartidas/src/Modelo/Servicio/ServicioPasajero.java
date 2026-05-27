/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Servicio;
import Modelo.Persistencia.DaoReserva;
import Modelo.entidades.Pasajero;
import Modelo.entidades.Reserva;
import Modelo.entidades.Viaje;
import java.io.IOException;



/**
 *
 * @author sebas
 */
public class ServicioReserva {
    
    DaoReserva dao=new DaoReserva();
    
    public boolean guardar(Viaje v,Pasajero pas){
            try {
                Reserva libro=new Reserva(v,pas);
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
