/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import excecoes.CellPhoneException;
import excecoes.EmailException;
import excecoes.HomePhoneException;
import excecoes.LetrasDobradasException;
import excecoes.SobrenomeException;
import model.Contato;
import model.SplitString;

/**
 *
 * @author Jefferson
 */
public class ValidarContatoAntigo {
    
    private static ValidarContatoAntigo validarContato;
    private Contato contato;
    
    private ValidarContatoAntigo(Contato contato){
        this.contato = contato;
    }
    
    public void validarCampos() throws SobrenomeException, LetrasDobradasException, HomePhoneException, CellPhoneException, EmailException{
        validarNomes();
        validarLetras();
        validarFone();
        validarCelular();
        validarEmail();
    }
    
    public static synchronized ValidarContatoAntigo getInstance(Contato c){
        if(validarContato==null){
            validarContato = new ValidarContatoAntigo(c);
        }
        return validarContato;
    }
    
    // jefferson Rodrigues -> valido
    // jefferson -> invalido.
    public void validarNomes()throws SobrenomeException {
        
        String[] nomes =  SplitString.getInstance().split(this.contato.getNome()," ");
        if(!(nomes.length >=2)){
            throw new SobrenomeException(this.contato);
        }              
    }
    
    // barrreto -> invalido
    // barreto -> valido
    public void validarLetras() throws LetrasDobradasException{
        String nome = this.contato.getNome();
        char[] caracteres = nome.toCharArray();
        char c; int count = 0 ;
        int i = 0 ; 
        while((i<caracteres.length)&&(count!=2)){
             c = caracteres[i];
            if(c==caracteres[i++]){
                count++;
            }   
            i++;
        }
        if(count>=2){
            throw  new LetrasDobradasException(this.contato);
        }
    }
    
    public void validarFone()throws  HomePhoneException{
        String fone = this.contato.getFone();
        if(fone.length() != 8){
            throw new HomePhoneException(this.contato);
        }
    }
    
    public void validarCelular() throws CellPhoneException{
        String celular = this.contato.getCelular();
        if(celular.length() != 8){
            throw new CellPhoneException(this.contato);
        }
    }
    
    // jefferson@comp.ufu.br    
    // jefferson   comp.com
    public void validarEmail() throws EmailException{
        String email = this.contato.getEmail();        
        String[] palavras = SplitString.getInstance().split(email,"@");
        String[] dominio =  SplitString.getInstance().split(palavras[1],".");        
        if(!((palavras.length==2)&&(dominio.length>=2))){
            throw new EmailException(this.contato);
        }        
    }
            
    
}
