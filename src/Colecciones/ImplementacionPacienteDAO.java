package Colecciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Modelos.Paciente;

public class ImplementacionPacienteDAO implements InterfacePacientesDAO{

    private List<Paciente> todosLosPacientes;

    public ImplementacionPacienteDAO(){
        todosLosPacientes = new ArrayList<>();
    }

    @Override
    public List<Paciente> pacientes() {
        return todosLosPacientes;
    }

    @Override
    public Paciente getPaciente(int identificacion) {
        for(Paciente paciente : todosLosPacientes){
            if(paciente.getIdentificacion() == identificacion){
                return paciente;
            }
        }

        return null;
    }

    @Override
    public void save(Paciente paciente) {
        todosLosPacientes.add(paciente);
    }

    @Override
    public void update(Paciente paciente) {
        for(int i = 0; i < todosLosPacientes.size(); i++){
            if(todosLosPacientes.get(i).getIdentificacion() == paciente.getIdentificacion()){
                todosLosPacientes.set(i, paciente);
                break;
            }
        }
    }


    public void guardarPaciente(Paciente paciente, String nombreArchivo) throws IOException{
        try(BufferedWriter escribir = new BufferedWriter(new FileWriter(nombreArchivo))){
            
            String line = paciente.getIdentificacion() + ", " + paciente.getTelefono() + ", "
            + paciente.getNombres() + ", " +  paciente.getApellidos() + ", " + paciente.getDireccion()
            + ", " + paciente.getAlergias();

            escribir.write(line);
            escribir.newLine();

        } catch(IOException e){

            e.printStackTrace();

        }
    }

    public Paciente cargarPaciente(String nombreArchivo) throws FileNotFoundException, IOException{
        try(BufferedReader leer = new BufferedReader(new FileReader(nombreArchivo))){

            String line = leer.readLine();
            String [] fields = line.split(",");
            int identificacion = Integer.parseInt(fields[0]);
            int telefono = Integer.parseInt(fields[1]);
            String nombres = fields[2];
            String apellidos = fields[3];
            String direccion = fields[4];
            int idAlergia = Integer.parseInt(fields[5]);

            return new Paciente(identificacion, telefono, nombres, apellidos, direccion, idAlergia);
            
        } catch(IOException e){

            e.printStackTrace();
        }

        return null;
    }

    
    
}
