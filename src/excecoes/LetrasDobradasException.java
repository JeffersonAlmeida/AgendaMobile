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
public class LetrasDobradasException extends Exception {
    
    private Contato contato;

    public LetrasDobradasException(Contato contato) {
        super("Nome com 3 letras consecutivas");
        this.contato = contato;
    }
   
     
     public String toString() {
        return "Erro: Nome possui 3 letras consecutivas";
    }
    
}
