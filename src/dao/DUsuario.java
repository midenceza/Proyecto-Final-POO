package dao;

import Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DUsuario {
    //Atributos
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    //Metodos
    public void obtRegistros(){
        try{
            conn = Conexion.getConnection();
            String tSQL = "Select * from Usario";
            ps = conn.prepareStatement(tSQL, 
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                   ResultSet.CONCUR_UPDATABLE,
                   ResultSet.HOLD_CURSORS_OVER_COMMIT);
        }catch (SQLException ex){
            System.out.println("Error al obtener registros " + ex.getMessage());
        }
    }
    public ArrayList<Usuario> listarUsuario(){
        ArrayList<Usuario> lista = new ArrayList<>();
        try{
            this.obtRegistros();
            while(rs.next()){
                lista.add(new Usuario(
                        rs.getInt("Id"),
                        rs.getString("Password")
                        
                ));
            }
        }catch (SQLException ex){
            System.out.println("Error al listar usuario " + ex.getMessage());
        }finally{
            try{
                if (rs !=null){
                      rs.close();
                }
                if (ps !=null){
                      ps.close();
                }
                if (conn !=null){
                      Conexion.closeConexion(conn);
                }
             
            }catch (SQLException ex){
            System.out.println(ex.getMessage());
            }
        }
        return lista;
    }
    
    public boolean guardarUsuario(Usuario a){
        boolean guardado = false;
        this.obtRegistros();
        try{
            rs.moveToInsertRow();
            rs.updateInt("Id", a.getId());
            rs.updateString("Password", a.getPassword());
            rs.insertRow();
            rs.moveToCurrentRow();
            guardado = true;
        }catch(SQLException ex){
            System.out.println("Error al guardar la usuario:" + ex.getMessage());
        }finally{
            try{
                if (rs !=null){
                      rs.close();
                }
                if (ps !=null){
                      ps.close();
                }
                if (conn !=null){
                      Conexion.closeConexion(conn);
                }
             
            }catch (SQLException ex){
            System.out.println(ex.getMessage());
            }
        }
        return guardado;
}
    public boolean existeUsuario(int id){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while (rs.next()){
                if (rs.getInt("Id") == id){
                    resp = true;
                    break;
                }
            }
        }catch(SQLException ex){
            System.out.println("Error al buscar usuario"+ ex.getMessage());
        }
        finally{
            try{
                if (rs != null){
                    rs.close();
                }
                
                if (ps != null){
                    rs.close();
                }
                
                if(conn != null) {
                    Conexion.closeConexion(conn);
                }
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return resp;
    }
    
    public boolean editarUsuario(Usuario a){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Id") == a.getId()){
                    rs.updateString("Password", a.getPassword());
                    rs.updateRow();
                    resp = true;
                    break;
                }
            }
        } catch(SQLException ex){
            System.out.println("Error al editar usuario"+ ex.getMessage());
        }
        
        finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (ps != null) {
                    rs.close();
                }
                
                if (conn != null) {
                    Conexion.closeConexion(conn);
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return resp;
    }
    
    public boolean eliminarUsuario(int id){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Id") == id){
                    rs.deleteRow();
                    resp = true;
                    break;
                }
            }
        } catch (SQLException ex){
            System.out.println("Error al eliminar usuario"+ ex.getMessage());
        }
        finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (ps != null) {
                    rs.close();
                }
                
                if (conn != null) {
                    Conexion.closeConexion(conn);
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return resp;
    }
}
