package Modelos;

import java.util.Date;

/**
 * @author MARIO
 * @version 1.0
 * @created 20-nov.-2022 11:38:45 p. m.
 */
public class Estudiante {

    private String apellido;
    private String direccion;
    private Date edad;
    private String nombre;
   /* public listEstudiante m_listEstudiante;*/
    private Clase m_Clase;

    public Estudiante() {  

    }

    public Estudiante(String apellido, String direccion, Date edad, String nombre, Clase m_Clase) {
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.nombre = nombre;
        /*this.m_listEstudiante = m_listEstudiante;*/
        this.m_Clase = m_Clase;
    }

    public Clase getM_Clase() {
        return m_Clase;
    }

    public void setM_Clase(Clase m_Clase) {
        this.m_Clase = m_Clase;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getEdad() {
        return edad;
    }

    public void setEdad(Date edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}//end Estudiante
