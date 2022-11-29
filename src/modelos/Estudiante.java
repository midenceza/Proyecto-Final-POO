package Modelos;

public class Estudiante extends modelos.Persona{
    private String clase;
    private int id;
    
    public Estudiante(){ 
    }
    
    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }

    /**
     * @return the id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    public Estudiante(String clase, int id) {
        this.clase = clase;
        this.id = id;
    }

    public Estudiante(String clase, int id, String nombres, String apellidos, String fechaNac) {
        super(nombres, apellidos, fechaNac);
        this.clase = clase;
        this.id = id;
    }

    public Estudiante(String clase, int id, String string, String string0, String string1, int aInt) {
        super(string, string0, string1, aInt);
        this.clase = clase;
        this.id = id;
    }
    
    
    
}//end Estudiante
