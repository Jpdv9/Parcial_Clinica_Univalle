package Colecciones;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import Modelos.Paciente;

public interface InterfacePacientesDAO {
    List<Paciente> pacientes();
    Paciente getPaciente(int identificacion);
    void save(Paciente paciente);
    void update(Paciente paciente);
    void guardarPaciente(Paciente paciente, String nombreArchivo) throws IOException;
    Paciente cargarPaciente(String nombreArchivo) throws FileNotFoundException, IOException;
}
