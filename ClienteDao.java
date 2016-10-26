/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mecapp.dao;

import java.util.List;
import py.edu.facitec.mecapp.model.Cliente;

/**
 *
 * @author Usuario
 */
public interface ClienteDao {
  
    void guardarCliente(Cliente cliente);
    void modificarCliente(Cliente cliente);
    void eliminarCliente(int codigo);
    Cliente buscarClientePorCodigo(int codigo);
    List<Cliente>buscarClientePorFiltro(String filtro);
}
