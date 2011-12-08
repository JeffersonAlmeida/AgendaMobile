/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jefferson
 */

/*
 * •	Nome		:  50 caracteres
•	Fone		:  8 caracteres
•	Celular		:  8 caracteres
•	Email		:  50 caracteres

 */
public class Contato {
    
    private int id;
    private String nome;
    private String fone;
    private String celular;
    private String email;

    public Contato() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void imprimeContato() {
        System.out.println(this.toString());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contato(String nome, String fone, String celular, String email) {
        this.nome = nome;
        this.fone = fone;
        this.celular = celular;
        this.email = email;
    }

    

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String toString() {
        return "Contato{" + "id=" + id + ", nome=" + nome + ", fone=" + fone + ", celular=" + celular + ", email=" + email + '}';
    }
    
    
}
