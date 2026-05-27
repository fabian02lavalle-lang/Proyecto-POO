package Vista;

import Modelo.entidades.Conductor;
import Modelo.entidades.Pasajero;
import Modelo.entidades.Viaje;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class PasajeroFrame extends JFrame {

    private JLabel lblBienvenido;
    private JLabel lblSeccion;
    private JLabel lblInfo;
    private JLabel lblSeccion2;
    private JLabel lblMisReservas;
    private JList<String> listaViajes;
    private DefaultListModel<String> modeloViajes;
    private JScrollPane jScrollPane1;
    private JButton btnRefrescar;
    private JButton btnUnirse;
    private JButton btnCerrarSesion;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;

    private Pasajero pasajero;
    private ArrayList<Viaje> viajesDisponibles;
    private HashMap<Integer, Conductor> conductores;
    private HashMap<Integer, Pasajero> pasajeros;
    private HashMap<Viaje, ArrayList<String>> pasajerosEnEspera;
    private ArrayList<Viaje> misReservas;

    public PasajeroFrame(Pasajero pasajero, ArrayList<Viaje> viajesDisponibles,
            HashMap<Integer, Conductor> conductores, HashMap<Integer, Pasajero> pasajeros,
            HashMap<Viaje, ArrayList<String>> pasajerosEnEspera) {
        this.pasajero = pasajero;
        this.viajesDisponibles = viajesDisponibles;
        this.conductores = conductores;
        this.pasajeros = pasajeros;
        this.pasajerosEnEspera = pasajerosEnEspera;
        this.misReservas = new ArrayList<>();

        initComponents();
        refrescarViajes();
    }

    private void initComponents() {
        lblBienvenido = new JLabel();
        lblSeccion = new JLabel();
        lblInfo = new JLabel();
        lblSeccion2 = new JLabel();
        lblMisReservas = new JLabel();
        modeloViajes = new DefaultListModel<>();
        listaViajes = new JList<>(modeloViajes);
        jScrollPane1 = new JScrollPane(listaViajes);
        btnRefrescar = new JButton();
        btnUnirse = new JButton();
        btnCerrarSesion = new JButton();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carrer - Pasajero: " + pasajero.getNombre());
        setResizable(false);
        getContentPane().setLayout(null);

        lblBienvenido.setFont(new Font("Arial", Font.BOLD, 12));
        lblBienvenido.setText("Hola, " + pasajero.getNombre() + "  |  Busca un viaje disponible");
        getContentPane().add(lblBienvenido);
        lblBienvenido.setBounds(20, 10, 310, 20);

        btnCerrarSesion.setText("Cerrar sesion");
        getContentPane().add(btnCerrarSesion);
        btnCerrarSesion.setBounds(330, 8, 125, 24);

        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 40, 430, 10);

        lblSeccion.setFont(new Font("Arial", Font.BOLD, 14));
        lblSeccion.setText("Viajes Disponibles");
        getContentPane().add(lblSeccion);
        lblSeccion.setBounds(20, 50, 200, 20);

        lblInfo.setText("Selecciona un viaje y presiona 'Unirse':");
        getContentPane().add(lblInfo);
        lblInfo.setBounds(20, 75, 300, 20);

        listaViajes.setFont(new Font("Arial", Font.PLAIN, 12));
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 430, 180);

        btnRefrescar.setText("Refrescar viajes");
        getContentPane().add(btnRefrescar);
        btnRefrescar.setBounds(20, 295, 150, 28);

        btnUnirse.setText("Unirse al viaje");
        btnUnirse.setBackground(new Color(100, 180, 100));
        getContentPane().add(btnUnirse);
        btnUnirse.setBounds(290, 295, 160, 28);

        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(20, 335, 430, 10);

        lblSeccion2.setFont(new Font("Arial", Font.BOLD, 14));
        lblSeccion2.setText("Mis Reservas:");
        getContentPane().add(lblSeccion2);
        lblSeccion2.setBounds(20, 345, 150, 20);

        lblMisReservas.setText("No tienes reservas aun.");
        lblMisReservas.setVerticalAlignment(SwingConstants.TOP);
        getContentPane().add(lblMisReservas);
        lblMisReservas.setBounds(20, 370, 430, 80);

        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        btnUnirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnirseActionPerformed(evt);
            }
        });

        setSize(480, 490);
        setLocationRelativeTo(null);
    }

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        LoginFrame lf = new LoginFrame();
        lf.setVisible(true);
    }

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {
        refrescarViajes();
    }

    private void btnUnirseActionPerformed(java.awt.event.ActionEvent evt) {
        int seleccion = listaViajes.getSelectedIndex();

        if (seleccion < 0) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona un viaje de la lista.");
            return;
        }

        if (viajesDisponibles.isEmpty()) {
            return;
        }

        Viaje viajeSeleccionado = viajesDisponibles.get(seleccion);

        ArrayList<String> enEspera = pasajerosEnEspera.get(viajeSeleccionado);
        if (enEspera == null) {
            enEspera = new ArrayList<>();
            pasajerosEnEspera.put(viajeSeleccionado, enEspera);
        }

        if (enEspera.contains(pasajero.getNombre())) {
            JOptionPane.showMessageDialog(this, "Ya te uniste a este viaje. Espera la confirmacion del conductor.");
            return;
        }

        pasajero.reservarViaje(viajeSeleccionado);
        enEspera.add(pasajero.getNombre());
        misReservas.add(viajeSeleccionado);

        JOptionPane.showMessageDialog(this,
                "Te uniste al viaje!\n"
                + "Origen: " + viajeSeleccionado.getOrigen() + "\n"
                + "Destino: " + viajeSeleccionado.getDestino() + "\n"
                + "Espera la confirmacion del conductor.");

        actualizarMisReservas();
    }

    private void refrescarViajes() {
        modeloViajes.clear();

        if (viajesDisponibles.isEmpty()) {
            modeloViajes.addElement("No hay viajes disponibles aun. Intenta mas tarde.");
            return;
        }

        for (int i = 0; i < viajesDisponibles.size(); i++) {
            Viaje v = viajesDisponibles.get(i);
            modeloViajes.addElement((i + 1) + ".  "
                    + v.getOrigen() + "  -->  " + v.getDestino()
                    + "    Fecha: " + v.getFecha()
                    + "    Costo: $" + v.getCosto()
                    + "    Conductor: " + v.getConductor().getNombre());
        }
    }

    private void actualizarMisReservas() {
        if (misReservas.isEmpty()) {
            lblMisReservas.setText("No tienes reservas aun.");
            return;
        }

        String texto = "<html>";
        for (int i = 0; i < misReservas.size(); i++) {
            Viaje v = misReservas.get(i);
            texto += (i + 1) + ". " + v.getOrigen() + " -> " + v.getDestino()
                    + "  |  Fecha: " + v.getFecha()
                    + "  |  Costo: $" + v.getCosto() + "<br>";
        }
        texto += "</html>";
        lblMisReservas.setText(texto);
    }
}
