package Controladores;

import Vistas.GestionDePacientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Colecciones.AlergiaDAO;
import Colecciones.ImplementacionPacienteDAO;
import Colecciones.InterfacePacientesDAO;
import Modelos.Paciente;

public class Controlador implements ActionListener{
    private Paciente paciente;
    private InterfacePacientesDAO interfacePacientesDAO;
    private AlergiaDAO alergiaDAO;
    private GestionDePacientes gestionDePacientes;

    public Controlador(GestionDePacientes gestionDePacientes, Paciente paciente, InterfacePacientesDAO interfacePacientesDAO){
        this.gestionDePacientes = gestionDePacientes;
        this.paciente = paciente;
        this.interfacePacientesDAO = new ImplementacionPacienteDAO();
        this.alergiaDAO = new AlergiaDAO();

        this.gestionDePacientes.btnBuscar.addActionListener(this);
        this.gestionDePacientes.btnActualizar.addActionListener(this);
        this.gestionDePacientes.btnAgregar.addActionListener(this);
    }

    public void iniciar(){
        gestionDePacientes.setTitle("Gestion De Paciente");
        gestionDePacientes.setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == gestionDePacientes.btnBuscar){
            
            String textoIdentificacion = gestionDePacientes.txtIdentidicacion.getText();

            if(!textoIdentificacion.isEmpty()){
                int identificacion = Integer.parseInt(textoIdentificacion);

                Paciente pacienteEncontrado = interfacePacientesDAO.getPaciente(identificacion);

                gestionDePacientes.txtIdentidicacion.setText("");

                if(pacienteEncontrado != null){

                    String archivo = "../ClinicaUnivalle/src/Archivos/pacientes.txt";

                    try {
                        Paciente pacienteArchivo = interfacePacientesDAO.cargarPaciente(archivo);

                        if (pacienteArchivo != null) {
                            gestionDePacientes.txtApellidos.setText(pacienteArchivo.getApellidos());
                            gestionDePacientes.txtNombres.setText(pacienteArchivo.getNombres());
                            gestionDePacientes.txtTelefono.setText(Integer.toString(pacienteArchivo.getTelefono()));
                            gestionDePacientes.txtDireccion.setText(pacienteArchivo.getDireccion());
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al cargar los datos del paciente desde el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al cargar los datos del paciente desde el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }

                }else{
                    JOptionPane.showMessageDialog(null, "El paciente no se ha encontrado", "Advertencia", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Llene la casilla de identificacion para buscar al paciente", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }

            
        }

        if(e.getSource() == gestionDePacientes.btnActualizar){
            
            String textoIdentificacion = gestionDePacientes.txtIdentidicacion.getText();

            if(!textoIdentificacion.isEmpty() && !gestionDePacientes.txtNombres.getText().isEmpty() && !gestionDePacientes.txtApellidos.getText().isEmpty()
            && !gestionDePacientes.txtTelefono.getText().isEmpty() && !gestionDePacientes.txtDireccion.getText().isEmpty()){
                int identificacion = Integer.parseInt(textoIdentificacion);
                String apellidos = gestionDePacientes.txtApellidos.getText();
                String nombres = gestionDePacientes.txtNombres.getText();
                int telefono = Integer.parseInt(gestionDePacientes.txtTelefono.getText());
                String direccion = gestionDePacientes.txtDireccion.getText();
                int idAlergia = Integer.parseInt(gestionDePacientes.jComboBoxAlergias.getSelectedItem().toString());

                Paciente pacienteActualizado = new Paciente(identificacion,telefono, nombres, apellidos, direccion, idAlergia);

                Paciente pacienteExiste = interfacePacientesDAO.getPaciente(identificacion);

                if(pacienteExiste != null){

                    interfacePacientesDAO.update(pacienteActualizado);

                    JOptionPane.showMessageDialog(null, "¡El Paciente se ha actualizado!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }else{

                    interfacePacientesDAO.save(pacienteActualizado);

                    JOptionPane.showMessageDialog(null, "¡El paciente ha sido guardado!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }

                String archivo = "..//ClinicaUnivalle/src/Archivos/pacientes.txt"; 
                
                try {
                    interfacePacientesDAO.guardarPaciente(pacienteActualizado, archivo);
                    JOptionPane.showMessageDialog(null, "¡El paciente se ha actualizado y guardado en el archivo!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el paciente en el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        }

        if(e.getSource() == gestionDePacientes.btnAgregar){
            String textoIdentificacion = gestionDePacientes.txtIdentidicacion.getText();
            String alergiaSelecionada = (String) gestionDePacientes.jComboBoxAlergias.getSelectedItem();

            int identificacion = Integer.parseInt(textoIdentificacion);
            int idAlergia = Integer.parseInt(gestionDePacientes.jComboBoxAlergias.getSelectedItem().toString());

            Paciente pacienteActualizado = new Paciente(identificacion, 0, "nombres", "apellidos", "direccion", idAlergia);

            int id = Integer.parseInt(alergiaSelecionada);
            String nombre = alergiaDAO.getAlergias().get(id);

            gestionDePacientes.jTextArea1.append(id + " -- " + nombre + "\n");
        }

        if (e.getSource() == gestionDePacientes.btnCancelar) {

            gestionDePacientes.txtIdentidicacion.setText("");
            gestionDePacientes.txtApellidos.setText("");
            gestionDePacientes.txtNombres.setText("");
            gestionDePacientes.txtTelefono.setText("");
            gestionDePacientes.txtDireccion.setText("");
            gestionDePacientes.jComboBoxAlergias.setSelectedIndex(0);
            gestionDePacientes.jTextArea1.setText("");
            
        }
    }
}

