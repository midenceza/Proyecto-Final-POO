package dao;
   
import java.sql.*;

public class Conexion {
    //única instancia que existe de esta clase
     private static Conexion conx = null;
    //atributos
    public Conexion cn = null;
    public Statement st = null;
    private static Connection con = null;
    private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=BDSistemaIglesia;Persist Security Info=True;";
    private static final String USER = "sa";
    private static final String PASSWORD = "evanelly04";
    
    public Conexion(){
        
    }
    
public static Conexion getInstance(){
        //instanciamos la unica instancia de Conexion
        if(conx==null){
            conx = new Conexion();
        }
        return conx;
    }
    
    //metodos
    public static Connection getConnection() {	
        if (estaConectado()==false) {
            Conexion.crearConexion();
            
        }
        return con; 
    }
   
    @SuppressWarnings("UseSpecificCatch")
    public static boolean estaConectado()
    {
        boolean resp = false;
        try{
            resp = !((con==null) || (con.isClosed()));                 
        }
        catch(Exception e){
            System.out.println("Error al consultar el estado de la conexion: "
                    +e.getMessage());
        }
        return resp;
    }
   
    public static void crearConexion()
    {
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con= DriverManager.getConnection(URL, USER, PASSWORD);
           System.out.println("Se conectó a la BD hr");
        } 
        catch (ClassNotFoundException e) {
           con=null;
           System.out.println("Error al cargar el driver:" +e.getMessage());
        } 
        catch (SQLException e) {
           con=null;
           System.out.println("Error al establecer la conexion:" +e.getMessage());
       }
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public static void closeConexion(Connection con){
        if(estaConectado()!=false){
            try{
                con.close();
                System.out.println("Cerrando la conexion");
            }catch(SQLException e){
                e.printStackTrace();
                System.out.println("Error al cerrar la conexion: "+e.getMessage());
            }
        }
    }

}
