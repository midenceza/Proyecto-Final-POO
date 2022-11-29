package modelos;

/**
 * @author MARIO
 * @version 1.0
 * @created 27-nov.-2022 02:30:54 p. m.
 */
public class Clase {

    private String clase;
    private String horario;

    public Clase() {

    }

    public Clase(String clase, String horario) {
        this.clase = clase;
        this.horario = horario;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return clase + " | " + horario;
    }

}//end Clase

