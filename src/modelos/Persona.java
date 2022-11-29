package modelos;

public class Persona {

    private String nombres;
    private String apellidos;
    private String fechaNac;

    public Persona() {

    }

    public Persona(String nombres, String apellidos, String fechaNac) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
    }

    public Persona(String string, String string0, String string1, int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); 
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

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

}//end Persona

