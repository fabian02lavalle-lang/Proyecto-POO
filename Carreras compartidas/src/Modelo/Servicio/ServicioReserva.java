/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Servicio;
import Modelo.Persistencia.DaoConductor;
import Modelo.entidades.Conductor;
import Modelo.entidades.Vehiculo;
import java.io.IOException;

/**
 *
 * @author sebas
 */
public class ServicioConductor {
    
     DaoConductor dao=new DaoConductor();
    
    public boolean guardar(int id,String nombre,Vehiculo v){
            try {
                Conductor libro=new Conductor(id,nombre,v);
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
    

