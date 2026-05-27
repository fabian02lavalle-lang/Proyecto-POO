/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Persistencia;

import Modelo.entidades.Pasajero;
import Modelo.entidades.Reserva;
import Modelo.entidades.Viaje;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author sebas
 */
public class DaoReserva {
   
    private String archivo="reservas.dat";
    
     public boolean guardar(Reserva reserva) throws FileNotFoundException, IOException, ClassNotFoundException{
        // aqui se guarda
        List<Reserva> lista= listar();
        lista.add(reserva);
        FileOutputStream file=new FileOutputStream(archivo);
        ObjectOutputStream fil=new ObjectOutputStream(file);
        fil.writeObject(lista);
        fil.close();
        file.close();
        return true;
    }
     
      public boolean borrar(Viaje viaje,Pasajero pasajero) throws IOException, ClassNotFoundException{
        List<Reserva> lista = listar();
        for (Reserva reserva : lista) {
            if(reserva.getViaje() == viaje && reserva.getPasajero() == pasajero){
                lista.remove(reserva);
                break;
            }
        }
        FileOutputStream file=new FileOutputStream(archivo);
        ObjectOutputStream fil=new ObjectOutputStream(file);
        fil.writeObject(lista);
        fil.close();
        file.close();
        return true;
    }
    public List<Reserva> listar() throws IOException, ClassNotFoundException {
        List<Reserva> lista=new ArrayList<>();
        FileInputStream file;
        try {
            file = new FileInputStream(archivo);
            ObjectInputStream entrada=new ObjectInputStream(file);
            lista= (List<Reserva>) entrada.readObject();
            
        } catch (FileNotFoundException ex) {
            System.out.println(" No xiste archivo ");
        }
        return lista;
        
        
    }
    
}
