/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Servicio;
import Modelo.Persistencia.DaoPago;
import Modelo.entidades.Pago;
import java.io.IOException;

/**
 *
 * @author sebas
 */
public class ServicioPago {
    
     DaoPago dao=new DaoPago();
    
    public boolean guardar(){
            try {
                Pago libro=new Pago();
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
