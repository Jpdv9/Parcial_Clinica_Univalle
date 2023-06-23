package Controladores;

import Colecciones.ImplementacionPacienteDAO;
import Colecciones.InterfacePacientesDAO;
import Modelos.Paciente;
import Vistas.GestionDePacientes;

/*
 * Autor: Jean Paul Davalos
 * Codigo: 1832375
 */

public class Main {
    /**
     * @param args the command line arguments
    */
    public static void main(String[] arg){
        GestionDePacientes vistaGestionDePacientes = new GestionDePacientes();

        Paciente modeloPaciente = new Paciente(0, 0, "Nombre", "Apellido", "Direccion", 0);
        InterfacePacientesDAO interfacePacientesDAO = new ImplementacionPacienteDAO();
        Controlador controlador = new Controlador(vistaGestionDePacientes, modeloPaciente, interfacePacientesDAO);

        controlador.iniciar();

        vistaGestionDePacientes.setVisible(true);
    }
}
