package dao;

import java.sql.*;
import java.util.ArrayList;
import modelos.Persona;

public class DPersona {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void obtRegistros(){
        try{
            conn = Conexion.getConnection();
            String tSQL = "Select * from Persona";
            ps = conn.prepareStatement(tSQL, 
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                   ResultSet.CONCUR_UPDATABLE,
                   ResultSet.HOLD_CURSORS_OVER_COMMIT);
        }catch (SQLException ex){
            System.out.println("Error al obtener registros " + ex.getMessage());
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Persona> listarPersona(){
        ArrayList<Persona> lista = new ArrayList<>();
        try{
            this.obtRegistros();
            while(rs.next()){
                lista.add(new Persona(
                        rs.getString("Nombres"),
                        rs.getString("Apellidos"),
                        rs.getString("FechaNac"),
                        rs.getInt("Id")
                ));
            }
        }catch (SQLException ex){
            System.out.println("Error al listar persona " + ex.getMessage());
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
    
    /**
     *
     * @param a
     * @return
     */
    public boolean guardarPersona(Persona a){
        boolean guardado = false;
        this.obtRegistros();
        try{
            rs.moveToInsertRow();
            rs.updateString("Nombres", a.getNombres());
            rs.updateString("Apellidos", a.getApellidos());
            rs.updateString("FechaNac", a.getFechaNac());
            rs.updateInt("Id",a.getId());
            rs.insertRow();
            rs.moveToCurrentRow();
            guardado = true;
        }catch(SQLException ex){
            System.out.println("Error al guardar la persona:" + ex.getMessage());
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
    public boolean existePersona(int id){
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
            System.out.println("Error al buscar persona"+ ex.getMessage());
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
    
    /**
     *
     * @param a
     * @return
     */
    public boolean editarPersona(Persona a){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Id") == a.getId()){
                    rs.updateString("Nombres", a.getNombres());
                    rs.updateString("Apellidos", a.getApellidos());
                    rs.updateString("FechaNac", a.getFechaNac());
                    rs.updateRow();
                    resp = true;
                    break;
                }
            }
        } catch(SQLException ex){
            System.out.println("Error al editar persona"+ ex.getMessage());
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
    
    public boolean eliminarPersona(int id){
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
            System.out.println("Error al eliminar persona"+ ex.getMessage());
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
