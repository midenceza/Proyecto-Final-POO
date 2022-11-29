package modelos;

public class Persona {
    
    private int personaID;
    private String nombres;
    private String apellidos;
    private String fechaNac;

    public Persona() {

    }

    public Persona(int personaID, String nombres, String apellidos, String fechaNac) {
        this.personaID = personaID;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
    }

    public Persona(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getPersonaID() {
        return personaID;
    }

    public void setPersonaID(int personaID) {
        this.personaID = personaID;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    
}//end Persona

