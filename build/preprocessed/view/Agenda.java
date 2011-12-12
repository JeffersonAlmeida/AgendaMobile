/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import model.Contato;
import persistence.ContatoDaoImpl;
import persistence.ValidarContato;

/**
 * @author Jefferson
 */
public class Agenda extends MIDlet implements CommandListener{
    
    private boolean midletPaused = false;
    
        
    private int contadorContatos =0;
    private Display display;
    private Form inserirContatoForm, apresentaContatoForm, buscarContatoForm;
    private Command exitCommand, salvarCommand, cancelCommand;
    
    private TextField nome;
    private TextField fone;
    private TextField celular;
    private TextField email;
    
    private Image incluirImage;
    private Image alterarImage;   
    private Image excluirImage;    
    private Image pesquisarImage;    
    private StringItem apresentaContato;

    private List menu;   
    
     TextField nomeContatoTela;
     TextField foneContatoTela;
     TextField celularContatoTela;
     TextField emailContatoTela;
     
    TextField nomeContatoExclusao;
    TextField foneContatoExclusao;
    TextField celularContatoExclusao;
    TextField emailContatoExclusao;
  
    
    // FORMULARIO DO MENU PRINCIPAL
    public List getFormPrincipal() throws IOException{                
       if(menu==null){
               this.incluirImage = Image.createImage("/imagem/incluir.png");       
               this.alterarImage = Image.createImage("/imagem/alterar.png");       
               this.excluirImage =  Image.createImage("/imagem/excluir.png");       
               this.pesquisarImage = Image.createImage("/imagem/pesquisar.png");    
               this.exitCommand = new Command("exit", Command.EXIT, 0);  
               this.menu = new List("Agenda Menu", Choice.IMPLICIT);
               menu.append("INCLUIR", incluirImage);
               menu.append("ALTERAR", alterarImage);
               menu.append("EXCLUIR", excluirImage);
               menu.append("PESQUISAR", pesquisarImage);
               menu.addCommand(exitCommand);
               menu.setCommandListener(this);
       }       
       return menu;       
    }
    
      // FORMULARIO DO CONTATO     NOME, TEL, EMAIL, TWITTER      

      public void formularioContato(){

            this.nome = new TextField("Nome", null, 50, TextField.ANY);
            this.fone = new TextField("Fone", null, 15, TextField.ANY);
            this.celular = new TextField("Celular", null, 15, TextField.ANY);
            this.email = new TextField("Email", null, 50, TextField.EMAILADDR);
            
            // Comandos
            
            final Command comandoVoltar = new Command("Back", Command.BACK, 0);
            final Command salvarCommand = new Command("Salvar", Command.OK,1);
            
            inserirContatoForm = new Form("Inclusão de Contatos", new Item[]{nome, fone,celular, email});
            
            this.inserirContatoForm.addCommand(comandoVoltar);   
            this.inserirContatoForm.addCommand(salvarCommand);
            
            this.inserirContatoForm.setCommandListener(new CommandListener() { 
            public void commandAction(Command c, Displayable d) {
               if(c==comandoVoltar){
                    Display.getDisplay(getThis()).setCurrent(menu);  
               }else if(c==salvarCommand){
                    Contato contato = new Contato(nome.getString().trim(),fone.getString().trim(),celular.getString().trim(),email.getString().trim());
                    try {
                        salvarContato(contato);
                    } catch (Exception ex) {
                        System.out.println(ex.toString());
                    }
               }
            }
        });
               
    } 
    
    public MIDlet getThis(){
        return this;
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The Agenda constructor.
     */
   

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }



    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
    
    
    
    // FORMULARIO PARA BUSCAR POR NOME
    
    public void formListarTodos(){      
        
        // Comandos
        
        final Command comandoRemover = new Command("Remover", Command.ITEM, 1);
        final Command commandoBuscar = new Command("Buscar", Command.OK, 1);    
        final Command comandoVoltar = new Command("Back", Command.BACK, 2);
        final Command comandoAlterarContato = new Command("Alterar", Command.ITEM, 3); 
       
        
        // campo usado para o usuario digitar a busca
        final TextField nomeBusca = new TextField("NOME: ", "", 15, TextField.ANY);
        
        ContatoDaoImpl contatoDaoImpl = new ContatoDaoImpl();
        final Vector contatos = contatoDaoImpl.listarTodos(); // vetor de contatos (Contato)
        
        // Lista - de contatos
        List contatosList = new List("Contatos", Choice.IMPLICIT);
        
        // adiciona os contatos na lista.
        int i=0;
        while(i<contatos.size()){
            Contato contato = (Contato) contatos.elementAt(i);
            contatosList.append(contato.getNome(), null);
            i++;
        }
        
        contatosList.addCommand(comandoVoltar);
        contatosList.addCommand(comandoRemover);
        contatosList.addCommand(commandoBuscar);
      
        contatosList.addCommand(comandoAlterarContato);     
        
        Display.getDisplay(this).setCurrent(contatosList); 
                
        contatosList.setCommandListener(new CommandListener() {
        public void commandAction(Command c, Displayable d) {
                if(c==commandoBuscar){
                    String nome = nomeBusca.getString().trim();
                    ContatoDaoImpl contatoDaoImpl = new ContatoDaoImpl();
                    Contato contato = new Contato();
                    contato.setNome(nome);
                    System.out.println("Pesquisar Por " + contato.getNome());
                    contatoDaoImpl.pesquisarContato(contato);
                }else if(c==comandoVoltar){
                     Display.getDisplay(getThis()).setCurrent(menu);  
                }else if(c==exitCommand){
                    destroyApp(false);
                    notifyDestroyed();
                }else{
                     List down = (List)display.getCurrent();   
                     mostraContatoNaTela((Contato)contatos.elementAt(down.getSelectedIndex()));
                }
            }
        });
    }
    
  
    public void updateContato(Contato c)throws Exception {
         ContatoDaoImpl  contatoDaoImpl = new ContatoDaoImpl();
         try {
            ValidarContato validarContato = new ValidarContato(c);
            validarContato.validarContatoInteiro();    
            contatoDaoImpl.alterarContato(c);
            formListarTodos();
        } catch (Exception e) {
           System.out.println(e.toString());   
           Alert alert = new Alert("Aviso:",e.toString(),null, AlertType.INFO);
           alert.setTimeout(Alert.FOREVER);
           trocaDisplayable(alert,getFormPrincipal());          
        }
    }
        
    public void startApp() {    
        
        setDisplay(Display.getDisplay(this));
        try {
            trocaDisplayable(null, new SplashScreen(getDisplay(), getFormPrincipal()));
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
   }

    public void commandAction(Command c, Displayable d) {
          if (c == exitCommand) {
                destroyApp(false);
                notifyDestroyed();
          }else if (c == salvarCommand){
             
          }else if(c==cancelCommand){
              
          }else{
                 List down = (List)display.getCurrent();
                 switch(down.getSelectedIndex()) {
                       case 0: incluirContato();break;
                       case 1: alterarContato();break;
                       case 2: excluirContato();break;
                       case 3: pesquisarContato();break;
                 }
         }
    }

    public void salvarContato(Contato contato) throws Exception {
        setContadorContatos(getContadorContatos()+1);   
        contato.setId(getContadorContatos());
        ContatoDaoImpl contatoDaoImpl = new ContatoDaoImpl();
        
        try {
            ValidarContato validarContato = new ValidarContato(contato);
            validarContato.validarContatoInteiro();
            contatoDaoImpl.incluirContato(contato);
            formListarTodos();
        } catch (Exception e) {
           System.out.println(e.toString());   
           Alert alert = new Alert("Aviso:",e.toString(),null, AlertType.INFO);
           alert.setTimeout(Alert.FOREVER);
           trocaDisplayable(alert,menu);          
        }
        
    }

    public Form getInserirContatoForm(){
        return inserirContatoForm;
    }
    // opcoes do menu
    
    private void incluirContato() {   
        this.formularioContato();
        Display.getDisplay(this).setCurrent(inserirContatoForm);
    }

    private void alterarContato() {
        this.formListarTodos();
    }

    private void excluirContato() {
        this.formularioDeExclsao();
    }

    private void pesquisarContato() {
      this.formularioBuscarContato();      
    }
    
    
    public void mostraContatoNaTela(final Contato contato){
        
        Form mostraContatoNaTela = new Form("# Contato # ");        
        //Comandos

        final Command exitCommand = new Command("exit", Command.EXIT, 0); 
        final Command comandoVoltar = new Command("Back", Command.BACK, 1);
        final Command comandoAlterarContato = new Command("Alterar", Command.ITEM,2); 

        mostraContatoNaTela.addCommand(comandoVoltar);
        mostraContatoNaTela.addCommand(comandoAlterarContato);
        mostraContatoNaTela.addCommand(exitCommand);
        contato.imprimeContato();
        
        this.nomeContatoTela = new TextField("Nome", "",50, TextField.ANY);
        this.foneContatoTela = new TextField("Fone", "",15, TextField.ANY);
        this.celularContatoTela = new TextField("Celular", "", 15, TextField.ANY);
        this.emailContatoTela = new TextField("Email", "",50, TextField.EMAILADDR);
        
        nomeContatoTela.setString(contato.getNome());
        foneContatoTela.setString(contato.getFone());
        celularContatoTela.setString(contato.getCelular());
        emailContatoTela.setString(contato.getEmail());
        
        mostraContatoNaTela.append(nomeContatoTela);
        mostraContatoNaTela.append(foneContatoTela);
        mostraContatoNaTela.append(celularContatoTela);
        mostraContatoNaTela.append(emailContatoTela);
        
        Display.getDisplay(this).setCurrent(mostraContatoNaTela);
         
        mostraContatoNaTela.setCommandListener(new CommandListener() {

            public void commandAction(Command c, Displayable d) {
                 if(c==comandoVoltar){
                        formListarTodos();                  
                 }else if(c==comandoAlterarContato){
                       contato.setNome(nomeContatoTela.getString().trim());
                       contato.setFone(foneContatoTela.getString().trim());
                       contato.setCelular(celularContatoTela.getString().trim());
                       contato.setEmail(emailContatoTela.getString().trim());
                        try {
                            updateContato(contato);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                 }else if(c==exitCommand){
                      destroyApp(false);
                      notifyDestroyed();
                 }
            }
        });
      
    }
    
    
    public void formularioBuscarContato(){
        
        final TextField buscar = new TextField("Buscar", null, 20, TextField.ANY);
        final Command comandoVoltar = new Command("Back", Command.BACK, 0);
        final Command comandoBuscar = new Command("Buscar", Command.OK, 1);
        
        Form formBuscar = new Form("Buscar Contato");
        formBuscar.addCommand(comandoVoltar);
        formBuscar.addCommand(comandoBuscar);
        
        formBuscar.append(buscar);
        
        Display.getDisplay(this).setCurrent(formBuscar);
        
        formBuscar.setCommandListener(new CommandListener() {

            public void commandAction(Command c, Displayable d) {
                if(c==comandoVoltar){
                    try {
                        getFormPrincipal();
                        Display.getDisplay(getThis()).setCurrent(menu);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }else if(c==comandoBuscar){
                    ContatoDaoImpl contatoDaoImpl = new ContatoDaoImpl();
                    Contato contato = new Contato();
                    contato.setNome(buscar.getString().toLowerCase().trim());
                    Contato contatoRetorno = contatoDaoImpl.pesquisarContato(contato);
                    verificaContato(contatoRetorno);
                }               
            }
        });   
    }
            
    public void verificaContato(Contato contatoRetorno) {
           if(contatoRetorno!=null){
               mostraContatoNaTela(contatoRetorno);
           }else{
               System.out.println("Contato Não existe, mostrar alert na Tela !!");
               Alert alert = new Alert("Aviso:", "Contato não encontrado.",null, AlertType.INFO);
               alert.setTimeout(Alert.FOREVER);
               trocaDisplayable(alert,menu);
                
           }
    }
    public void formularioDeExclsao(){
        
        System.out.println("Formulario de Exclusao");
        
        final Command comandoVoltar = new Command("Back", Command.BACK, 0);

        
        ContatoDaoImpl contatoDaoImpl = new ContatoDaoImpl();
        final Vector contatos = contatoDaoImpl.listarTodos(); // vetor de contatos (Contato)
        
        // Lista - de contatos
        List contatosList = new List("Contatos", Choice.IMPLICIT);
        
        // adiciona os contatos na lista.
        int i=0;
        System.out.println("\nTodos os Contatos ::\n");
        while(i<contatos.size()){
            Contato contato = (Contato) contatos.elementAt(i);
            contato.imprimeContato();
            contatosList.append(contato.getNome(), null);
            i++;
        }
        
        contatosList.addCommand(comandoVoltar);
        Display.getDisplay(this).setCurrent(contatosList); 
                
        contatosList.setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable d) {
                if(c==comandoVoltar){
                    try {
                        getFormPrincipal();
                        Display.getDisplay(getThis()).setCurrent(menu);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }else{
                     List down = (List)display.getCurrent();   
                     ContatoDaoImpl contatoDaoImpl = new ContatoDaoImpl();
                     Contato contato = (Contato) contatos.elementAt(down.getSelectedIndex());
                     desejaExcluirContato(contato);
                   }                   
           }
        });        
    }

    public void desejaExcluirContato(final Contato contato){
        Form formDeExclusao = new Form("Excluir Contato");
        
        final Command back = new Command("Back", Command.BACK, 0);
        final Command sim = new Command("Sim", Command.ITEM, 1);
        final Command nao = new Command("Nao", contadorContatos, 2);
        
        nomeContatoExclusao = new TextField("Nome","",50, TextField.UNEDITABLE);
        foneContatoExclusao = new TextField("Fone","",15, TextField.UNEDITABLE);
        celularContatoExclusao = new TextField("Celular","", 15, TextField.UNEDITABLE);
        emailContatoExclusao = new TextField("Email","",50, TextField.UNEDITABLE);
        
        nomeContatoExclusao.setString(contato.getNome());
        foneContatoExclusao.setString(contato.getFone());
        celularContatoExclusao.setString(contato.getCelular());
        emailContatoExclusao.setString(contato.getEmail());
        
        
        
        formDeExclusao.append(nomeContatoExclusao);
        formDeExclusao.append(foneContatoExclusao);
        formDeExclusao.append(celularContatoExclusao);
        formDeExclusao.append(emailContatoExclusao);
    
        formDeExclusao.addCommand(back);
        formDeExclusao.addCommand(sim);
        formDeExclusao.addCommand(nao);
        Display.getDisplay(getThis()).setCurrent(formDeExclusao);
        formDeExclusao.setCommandListener(new CommandListener() {

            public void commandAction(Command c, Displayable d) {
               if(c==back){
                     formularioDeExclsao();
               }else if(c==sim){
                     ContatoDaoImpl contatoDaoImpl = new ContatoDaoImpl();
                     contatoDaoImpl.excluirContato(contato);
                     formularioDeExclsao();
               }else if(c==nao){
                     formularioDeExclsao();
               }
            }
        });
    }
    
    public int getContadorContatos() {
        return contadorContatos;
    }

    public void setContadorContatos(int contadorContatos) {
        this.contadorContatos = contadorContatos;
    }
    
    public void trocaDisplayable(Alert alert, Displayable nextDisplayable) {
        if (alert == null) {
            getDisplay().setCurrent(nextDisplayable);
        } else {
            getDisplay().setCurrent(alert, nextDisplayable);
        }
    }
   
    
    public void setDisplay(Display display) {
        this.display = display;
    }
    
}



