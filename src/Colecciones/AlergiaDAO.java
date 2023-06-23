package Colecciones;

import java.util.HashMap;
import java.util.Map;

public class AlergiaDAO {
    
    private Map<Integer, String> alergias;

    public AlergiaDAO(){
        alergias = new HashMap<>();

        alergias.put(1, "Alergia al polen");
        alergias.put(2, "Alergia al latex");
        alergias.put(3, "Alergia a fragancias");
        alergias.put(4, "Alergia al sol");
    }

    public Map<Integer, String> getAlergias(){
        return alergias;
    }
}
