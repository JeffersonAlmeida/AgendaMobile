/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.Vector;
import model.Contato;

/**
 *
 * @author 
 * 
•	Incluir Contato
•	Alterar Contato
•	Excluir Contato
•	Pesquisar Contatos

 */
public interface ContatoDao {
    
    public void incluirContato(Contato c);
    public Contato pesquisarContato(Contato c);
    public void alterarContato(Contato c);
    public void excluirContato(Contato c);
    
    public Vector listarTodos();
    
}
