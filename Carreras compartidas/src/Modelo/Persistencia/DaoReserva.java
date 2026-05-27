/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Persistencia;

import Modelo.entidades.Pago;
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
public class DaoPago {
    
     private String archivo="pagos.dat";
     
     public boolean guardar(Pago pago) throws FileNotFoundException, IOException, ClassNotFoundException{
        // aqui se guarda
        List<Pago> lista= listar();
        lista.add(pago);
        FileOutputStream file=new FileOutputStream(archivo);
        ObjectOutputStream fil=new ObjectOutputStream(file);
        fil.writeObject(lista);
        fil.close();
        file.close();
        return true;
     }
     
        public boolean borrar(Pago pagos) throws IOException, ClassNotFoundException{
        List<Pago> lista = listar();
        for (Pago pago : lista) {
            if(pago == pagos){
                lista.remove(pago);
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
        
        
         public List<Pago> listar() throws IOException, ClassNotFoundException {
        List<Pago> lista=new ArrayList<>();
        FileInputStream file;
        try {
            file = new FileInputStream(archivo);
            ObjectInputStream entrada=new ObjectInputStream(file);
            lista= (List<Pago>) entrada.readObject();
            
        } catch (FileNotFoundException ex) {
            System.out.println(" No xiste archivo ");
        }
        return lista;
        
        
    }
}