package Vista;

import Control.ControlViaje;
import Modelo.entidades.Conductor;
import Modelo.entidades.Pasajero;
import Modelo.entidades.Viaje;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.DefaultListModel;
import java.awt.Font;
import java.awt.Color;

public class ConductorFrame extends JFrame {

    private JLabel lblBienvenido;
    private JLabel lblSeccion1;
    private JLabel lblOrigen;
    private JLabel lblDestino;
    private JLabel lblFecha;
    private JLabel lblCosto;
    private JLabel lblSeccion2;
    private JLabel lblListaInfo;
    private JTextField txtOrigen;
    private JTextField txtDestino;
    private JTextField txtFecha;
    private JTextField txtCosto;
    private JButton btnCrearViaje;
    private JButton btnRefrescar;
    private JButton btnConfirmar;
    private JButton btnRechazar;
    private JButton btnCerrarSesion;
    private JList<String> listaPasajeros;
    private DefaultListModel<String> modeloPasajeros;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;

    private Conductor conductor;
    private Viaje viajeActual;
    private ArrayList<Viaje> viajesDisponibles;
    private HashMap<Integer, Conductor> conductores;
    private HashMap<Integer, Pasajero> pasajeros;
    private HashMap<Viaje, ArrayList<String>> pasajerosEnEspera;

    public ConductorFrame(Conductor conductor, ArrayList<Viaje> viajesDisponibles,
            HashMap<Integer, Conductor> conductores, HashMap<Integer, Pasajero> pasajeros,
            HashMap<Viaje, ArrayList<String>> pasajerosEnEspera) {
        this.conductor = conductor;
        this.viajesDisponibles = viajesDisponibles;
        this.conductores = conductores;
        this.pasajeros = pasajeros;
        this.pasajerosEnEspera = pasajerosEnEspera;

        // si el conductor ya tenia un viaje publicado lo recuperamos
        if (!conductor.getViajes().isEmpty()) {
            viajeActual = conductor.getViajes().get(conductor.getViajes().size() - 1);
        }

        initComponents();
    }

    private void initComponents() {
        lblBienvenido = new JLabel();
        lblSeccion1 = new JLabel();
        lblOrigen = new JLabel();
        lblDestino = new JLabel();
        lblFecha = new JLabel();
        lblCosto = new JLabel();
        lblSeccion2 = new JLabel();
        lblListaInfo = new JLabel();
        txtOrigen = new JTextField();
        txtDestino = new JTextField();
        txtFecha = new JTextField();
        txtCosto = new JTextField();
        btnCrearViaje = new JButton();
        btnRefrescar = new JButton();
        btnConfirmar = new JButton();
        btnRechazar = new JButton();
        btnCerrarSesion = new JButton();
        modeloPasajeros = new DefaultListModel<>();
        listaPasajeros = new JList<>(modeloPasajeros);
        jScrollPane1 = new JScrollPane(listaPasajeros);
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carrer - Conductor: " + conductor.getNombre());
        setResizable(false);
        getContentPane().setLayout(null);

        lblBienvenido.setFont(new Font("Arial", Font.BOLD, 12));
        lblBienvenido.setText("Hola, " + conductor.getNombre() + "  |  Vehiculo: " + conductor.getVehiculo().getModelo());
        getContentPane().add(lblBienvenido);
        lblBienvenido.setBounds(20, 10, 340, 20);

        btnCerrarSesion.setText("Cerrar sesion");
        getContentPane().add(btnCerrarSesion);
        btnCerrarSesion.setBounds(355, 8, 125, 24);

        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 40, 450, 10);

        lblSeccion1.setFont(new Font("Arial", Font.BOLD, 14));
        lblSeccion1.setText("Crear Viaje");
        getContentPane().add(lblSeccion1);
        lblSeccion1.setBounds(20, 50, 200, 20);

        lblOrigen.setText("Origen:");
        getContentPane().add(lblOrigen);
        lblOrigen.setBounds(20, 80, 100, 20);

        getContentPane().add(txtOrigen);
        txtOrigen.setBounds(130, 80, 180, 25);

        lblDestino.setText("Destino:");
        getContentPane().add(lblDestino);
        lblDestino.setBounds(20, 115, 100, 20);

        getContentPane().add(txtDestino);
        txtDestino.setBounds(130, 115, 180, 25);

        lblFecha.setText("Fecha (dd/mm/aa):");
        getContentPane().add(lblFecha);
        lblFecha.setBounds(20, 150, 130, 20);

        getContentPane().add(txtFecha);
        txtFecha.setBounds(160, 150, 150, 25);

        lblCosto.setText("Costo ($):");
        getContentPane().add(lblCosto);
        lblCosto.setBounds(20, 185, 100, 20);

        getContentPane().add(txtCosto);
        txtCosto.setBounds(130, 185, 180, 25);

        btnCrearViaje.setText("Publicar Viaje");
        getContentPane().add(btnCrearViaje);
        btnCrearViaje.setBounds(130, 220, 150, 30);

        // si ya tenia viaje publicado deshabilitamos el boton
        if (viajeActual != null) {
            btnCrearViaje.setEnabled(false);
            btnCrearViaje.setText("Viaje publicado");
        }

        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(20, 265, 450, 10);

        lblSeccion2.setFont(new Font("Arial", Font.BOLD, 14));
        lblSeccion2.setText("Confirmar Pasajeros");
        getContentPane().add(lblSeccion2);
        lblSeccion2.setBounds(20, 275, 250, 20);

        lblListaInfo.setText("Pasajeros que se unieron a tu viaje:");
        getContentPane().add(lblListaInfo);
        lblListaInfo.setBounds(20, 300, 280, 20);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 325, 440, 120);

        btnRefrescar.setText("Refrescar");
        getContentPane().add(btnRefrescar);
        btnRefrescar.setBounds(20, 460, 120, 28);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.setBackground(new Color(100, 180, 100));
        getContentPane().add(btnConfirmar);
        btnConfirmar.setBounds(160, 460, 120, 28);

        btnRechazar.setText("Rechazar");
        btnRechazar.setBackground(new Color(220, 100, 100));
        getContentPane().add(btnRechazar);
        btnRechazar.setBounds(295, 460, 120, 28);

        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnCrearViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearViajeActionPerformed(evt);
            }
        });

        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarActionPerformed(evt);
            }
        });

        setSize(500, 530);
        setLocationRelativeTo(null);
    }

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        LoginFrame lf = new LoginFrame();
        lf.setVisible(true);
    }

    private void btnCrearViajeActionPerformed(java.awt.event.ActionEvent evt) {
        String origen = txtOrigen.getText().trim();
        String destino = txtDestino.getText().trim();
        String fecha = txtFecha.getText().trim();
        String costoTexto = txtCosto.getText().trim();

        if (origen.isEmpty() || destino.isEmpty() || fecha.isEmpty() || costoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llena todos los campos del viaje.");
            return;
        }

        double costo;
        try {
            costo = Double.parseDouble(costoTexto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El costo debe ser un numero.");
            return;
        }

        ControlViaje controlViaje = new ControlViaje();
        viajeActual = controlViaje.crearViaje(origen, destino, fecha, costo, conductor);

        conductor.PublicarViaje(viajeActual);
        viajesDisponibles.add(viajeActual);
        pasajerosEnEspera.put(viajeActual, new ArrayList<>());

        JOptionPane.showMessageDialog(this, "Viaje publicado!\nOrigen: " + origen + "\nDestino: " + destino);

        txtOrigen.setText("");
        txtDestino.setText("");
        txtFecha.setText("");
        txtCosto.setText("");

        btnCrearViaje.setEnabled(false);
        btnCrearViaje.setText("Viaje publicado");
    }

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {
        if (viajeActual == null) {
            JOptionPane.showMessageDialog(this, "Primero debes publicar un viaje.");
            return;
        }

        modeloPasajeros.clear();

        ArrayList<String> enEspera = pasajerosEnEspera.get(viajeActual);

        if (enEspera == null || enEspera.isEmpty()) {
            modeloPasajeros.addElement("No hay pasajeros esperando aun.");
        } else {
            for (String nombre : enEspera) {
                modeloPasajeros.addElement(nombre);
            }
        }
    }

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        confirmarOrechazar(true);
    }

    private void btnRechazarActionPerformed(java.awt.event.ActionEvent evt) {
        confirmarOrechazar(false);
    }

    private void confirmarOrechazar(boolean confirmar) {
        if (viajeActual == null) {
            JOptionPane.showMessageDialog(this, "No tienes un viaje publicado.");
            return;
        }

        int seleccion = listaPasajeros.getSelectedIndex();
        if (seleccion < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un pasajero de la lista.");
            return;
        }

        String nombrePasajero = modeloPasajeros.getElementAt(seleccion);

        if (nombrePasajero.equals("No hay pasajeros esperando aun.")) {
            return;
        }

        modeloPasajeros.remove(seleccion);
        pasajerosEnEspera.get(viajeActual).remove(seleccion);

        if (confirmar) {
            JOptionPane.showMessageDialog(this, "Pasajero " + nombrePasajero + " CONFIRMADO.");
        } else {
            JOptionPane.showMessageDialog(this, "Pasajero " + nombrePasajero + " RECHAZADO.");
        }
    }
}
