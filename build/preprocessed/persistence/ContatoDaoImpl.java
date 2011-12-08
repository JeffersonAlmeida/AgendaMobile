/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.Vector;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import model.Contato;
import model.SplitString;

/**
 *
 * @author Jefferson
 */
public class ContatoDaoImpl implements ContatoDao {

     
    public void incluirContato(Contato c) {
        Banco banco = Banco.getInstance();
        try {
            banco.openRecStore();
            banco.writeRecord(c.getNome()+";"+c.getFone()+";"+c.getCelular()+";"+c.getEmail()+";"+c.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            System.out.println("Contato Inserido: ");
            c.imprimeContato();
            banco.closeRecStore();
        }        
    }

    public Contato pesquisarContato(Contato contatoPesquisado) {
        Banco banco = Banco.getInstance();
        Contato contatoRetorno = null;
        try {
            banco.openRecStore();           
            RecordStore recordStore = banco.getRecordStore();
            RecordEnumeration enum = recordStore.enumerateRecords(null, null, false);
            while ( enum.hasNextElement()) {
                //armazena o próximo registro em um String
                String contatoString = new String(enum.nextRecord());
                System.out.println("Contato:: " + contatoString);
                
                String[] contatoQuebrado = SplitString.getInstance().split(contatoString, ";");                
                Contato contato = new Contato(contatoQuebrado[0], contatoQuebrado[1],contatoQuebrado[2],contatoQuebrado[3]);    
                contato.setId(Integer.parseInt(contatoQuebrado[4]));
                
                System.out.println(": Comparar Contatos :: \n");
                
                System.out.println("\n Contato pesquisado : \n");
                contatoPesquisado.imprimeContato();
                System.out.println("\n Contato 2: \n");
                contato.imprimeContato();                
                if(contatoPesquisado.getNome().equals(contato.getNome())){
                    contatoRetorno = contato;
                }          
            }     
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            banco.closeRecStore();
            return contatoRetorno;
        }    
    }

    public void alterarContato(Contato c) {
        Banco banco = Banco.getInstance();
        try {
            
            banco.openRecStore();
            // do something
            RecordStore recordStore = banco.getRecordStore();            
            String contato = c.getNome()+";"+c.getFone()+";"+c.getCelular()+";"+c.getEmail()+";"+c.getId();
            byte[] contatoByte = contato.getBytes();
            recordStore.setRecord(c.getId(), contatoByte, 0, contatoByte.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            banco.closeRecStore();
        }    
    }

    public void excluirContato(Contato c) {
        c.imprimeContato();
        Banco banco = Banco.getInstance();
        try {
            banco.openRecStore();
            // do something            
            RecordStore recordStore = banco.getRecordStore();
            recordStore.deleteRecord(c.getId());            
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            banco.closeRecStore();
        }    
    }

    public Vector listarTodos() {
        Banco banco = Banco.getInstance();
        Vector contatosVector = new Vector(); // Vetor de Strings por enquanto
        
        try {
            banco.openRecStore();
            RecordStore recordStore = banco.getRecordStore();
            RecordEnumeration enum = recordStore.enumerateRecords(null, null, false);
            System.out.println("\nListar Todos os Contatos :: \n");
            while ( enum.hasNextElement()){
                //armazena o próximo registro em um String
                String contatoInteiro = new String(enum.nextRecord());
                String[] contatoQuebrado = SplitString.getInstance().split(contatoInteiro,";");      
                Contato contato = new Contato(contatoQuebrado[0], contatoQuebrado[1],contatoQuebrado[2],contatoQuebrado[3]);    
                contato.setId(Integer.parseInt(contatoQuebrado[4]));
                contato.imprimeContato();               
                contatosVector.addElement(contato); 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            banco.closeRecStore();
            return contatosVector;
        }  
    }
    
    
  
    
}
