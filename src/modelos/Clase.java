package Modelos;

/**
 * @author MARIO
 * @version 1.0
 * @created 20-nov.-2022 11:38:48 p. m.
 */
public class Clase {

    private String grupo;
    private String horario;
    /*public asignarClase m_asignarClase;*/

    public Clase() {

    }

    public Clase(String grupo, String horario) {
        this.grupo = grupo;
        this.horario = horario;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
}//end Clase
