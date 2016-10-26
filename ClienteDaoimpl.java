/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mecapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.edu.facitec.mecapp.model.Cliente;
import py.edu.facitec.mecapp.util.ConexionManeger;

/**
 *
 * @author Usuario
 */
public class ClienteDaoimpl implements ClienteDao{
//String='"++"'
//numerico= "++"    
    @Override
    public void guardarCliente(Cliente cliente) {
        String sql = "insert into cliente(nombres, apellidos direccion) valuos"
                + "('"+cliente.getNombre()+"', '"+cliente.getApellidos()+"', '"+cliente.getDireccion()+"' ) ";
        System.out.println(sql);
        //conectar a la Base de Datos
        ConexionManeger.conectar();
        
        try {
            //ejecutar el SQL
            ConexionManeger.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //cerrar la conexion con la base de dato
        ConexionManeger.desconectar();
    }
//para string '"++"'
//para numerico "++"    
    @Override
    public void modificarCliente(Cliente cliente) {
        String sql = "update clientes set nombres'"+cliente.getNombre()+"',"
                + "apellidos='"+cliente.getApellidos()+"', direccion='"+cliente.getDireccion()+"' "
                + "where codigo="+cliente.getCodigo()+"  ";
        
        //Conectar
        ConexionManeger.conectar();
        try {
            //ejecutar al SQL
            ConexionManeger.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //desconectar
        ConexionManeger.desconectar();
    
    }

    @Override
    public void eliminarCliente(int codigo) {
        String sql = "delete from clientes where codigo= "+codigo+"";
        //conectar a la Base de Datos
        ConexionManeger.conectar();
        
        try {
            //ejecutar el SQL
            ConexionManeger.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //cerrar la conexion con la base de dato
        ConexionManeger.desconectar();
    }
 
    @Override
    public Cliente buscarClientePorCodigo(int codigo) {
        String sql = "selec nombre.apellidos, direccion from clientes "
                + "where codigo="+codigo+" ";
        
        Cliente cliente = null;
        ConexionManeger.conectar();
        
        try {
            ResultSet rs=  ConexionManeger.stm.executeQuery(sql);
            if (rs.next())
                cliente= new Cliente();
                cliente.setNombre(rs.getString("nombres")); 
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setDireccion(rs.getString("direccion"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        ConexionManeger.desconectar();
        return cliente;
    }

    @Override
    public List<Cliente> buscarClientePorFiltro(String filtro) {
        String sql= "select nombres, apellidos, direccion from clientes "
                + "where nombres LIKE '"+filtro+"' or apellidos LIKE '"+filtro+"' or direccion Like '"+filtro+"' ";
                
                List<Cliente> lista = new ArrayList<>();
                Cliente cliente;
        try {
                ResultSet rs=  ConexionManeger.stm.executeQuery(sql);
                while (rs.next()){//mientras tengas resultado
                cliente=new Cliente();
                cliente.setNombre(rs.getString("Nombres"));
                cliente.setApellidos(rs.getString("Apellidos"));
                cliente.setDireccion(rs.getString("Direccion"));
                 lista.add(cliente);
                }
        }catch (SQLException ex) {
            Logger.getLogger(ClienteDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        ConexionManeger.desconectar();
    return  lista;
 }
    
}
   
    
