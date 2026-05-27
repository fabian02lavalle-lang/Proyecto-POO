/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Persistencia;
import Modelo.entidades.Vehiculo;
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
public class DaoVehiculo {
    
    private String archivo="vehiculos.dat";
     
     public boolean guardar(Vehiculo ve) throws FileNotFoundException, IOException, ClassNotFoundException{
        // aqui se guarda
        List<Vehiculo> lista= listar();
        lista.add(ve);
        FileOutputStream file=new FileOutputStream(archivo);
        ObjectOutputStream fil=new ObjectOutputStream(file);
        fil.writeObject(lista);
        fil.close();
        file.close();
        return true;
     }
     
        public boolean borrar(String placa) throws IOException, ClassNotFoundException{
        List<Vehiculo> lista = listar();
        for (Vehiculo vei : lista) {
            if(vei.equals(placa)){
                lista.remove(vei);
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
        
        
         public List<Vehiculo> listar() throws IOException, ClassNotFoundException {
        List<Vehiculo> lista=new ArrayList<>();
        FileInputStream file;
        try {
            file = new FileInputStream(archivo);
            ObjectInputStream entrada=new ObjectInputStream(file);
            lista= (List<Vehiculo>) entrada.readObject();
            
        } catch (FileNotFoundException ex) {
            System.out.println(" No xiste archivo ");
        }
        return lista;
        
        
    }
    
}
