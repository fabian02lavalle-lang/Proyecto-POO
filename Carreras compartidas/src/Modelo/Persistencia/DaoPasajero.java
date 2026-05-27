/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Persistencia;

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
public class DaoViaje {
    
    private String archivo="viajes.dat";
     
     public boolean guardar(Viaje ve) throws FileNotFoundException, IOException, ClassNotFoundException{
        // aqui se guarda
        List<Viaje> lista= listar();
        lista.add(ve);
        FileOutputStream file=new FileOutputStream(archivo);
        ObjectOutputStream fil=new ObjectOutputStream(file);
        fil.writeObject(lista);
        fil.close();
        file.close();
        return true;
     }
     
        public boolean borrar(Viaje ve) throws IOException, ClassNotFoundException{
        List<Viaje> lista = listar();
        for (Viaje vei : lista) {
            if(vei == ve){
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
        
        
         public List<Viaje> listar() throws IOException, ClassNotFoundException {
        List<Viaje> lista=new ArrayList<>();
        FileInputStream file;
        try {
            file = new FileInputStream(archivo);
            ObjectInputStream entrada=new ObjectInputStream(file);
            lista= (List<Viaje>) entrada.readObject();
            
        } catch (FileNotFoundException ex) {
            System.out.println(" No xiste archivo ");
        }
        return lista;
        
        
    }
    
    
}
