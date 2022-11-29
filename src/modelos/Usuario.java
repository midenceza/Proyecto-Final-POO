package Modelos;

public class Usuario extends modelos.Persona {

    private int id;
    private String Usuario;
    private String Password;

    public Usuario() {

    }

    public Usuario(int id, String Usuario, String Password) {
        this.id = id;
        this.Usuario = Usuario;
        this.Password = Password;
    }

    public Usuario(int id, String Usuario, String Password, String nombres, String apellidos, String fechaNac) {
        super(nombres, apellidos, fechaNac);
        this.id = id;
        this.Usuario = Usuario;
        this.Password = Password;
    }

    public Usuario(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
