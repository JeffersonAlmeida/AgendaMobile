/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

import model.Contato;

/**
 *
 * @author Jefferson
 */
public class CellPhoneException extends Exception{
   
    private Contato contato;

    public CellPhoneException(Contato contato) {
        super("CellPhone Exception!");
        this.contato = contato;
    }

    public String toString() {
        return "Numero de telefone deve ter apenas 8 digitos!";
    }
    
    
    
}
