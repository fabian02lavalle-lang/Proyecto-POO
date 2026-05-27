/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Persistencia;
import Modelo.entidades.Pasajero;
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
public class DaoPasajero {
    
    private String archivo="pasajeros.dat";
     
     public boolean guardar(Pasajero pas) throws FileNotFoundException, IOException, ClassNotFoundException{
        // aqui se guarda
        List<Pasajero> lista= listar();
        lista.add(pas);
        FileOutputStream file=new FileOutputStream(archivo);
        ObjectOutputStream fil=new ObjectOutputStream(file);
        fil.writeObject(lista);
        fil.close();
        file.close();
        return true;
     }
     
        public boolean borrar(int id) throws IOException, ClassNotFoundException{
        List<Pasajero> lista = listar();
        for (Pasajero pa : lista) {
            if(pa.getId() == id){
                lista.remove(pa);
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
        
        
         public List<Pasajero> listar() throws IOException, ClassNotFoundException {
        List<Pasajero> lista=new ArrayList<>();
        FileInputStream file;
        try {
            file = new FileInputStream(archivo);
            ObjectInputStream entrada=new ObjectInputStream(file);
            lista= (List<Pasajero>) entrada.readObject();
            
        } catch (FileNotFoundException ex) {
            System.out.println(" No xiste archivo ");
        }
        return lista;
        
        
    }
    
}
