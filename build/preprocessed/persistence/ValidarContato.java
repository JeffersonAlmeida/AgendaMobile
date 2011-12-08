package persistence;

import excecoes.CellPhoneException;
import excecoes.EmailException;
import excecoes.HomePhoneException;
import excecoes.LetrasDobradasException;
import excecoes.SobrenomeException;
import model.Contato;
import model.SplitString;

public class ValidarContato {

	private Contato contato;
	
        public void validarContatoInteiro() throws LetrasDobradasException, SobrenomeException, CellPhoneException, HomePhoneException, EmailException{
            if(!this.validarNomeCompleto()){
                throw new LetrasDobradasException(contato);
            }if(!this.validarSobreNome()){
                throw  new SobrenomeException(contato);
            }if(!this.validarCelular()){
                throw new CellPhoneException(contato);
            }if(!this.validarFone()){
                throw new HomePhoneException(contato);
            }if(!this.validarEmail()){
                throw new EmailException(contato);
            }
        }
        public boolean validarSobreNome(){
		String nome = this.contato.getNome().trim();
		String nomes[] =  SplitString.split(nome, " ");
		if(nomes.length<2){
			return false;
		}
		return true;
	}
	public boolean validarNome(){
		String nome = this.contato.getNome().trim();
		String[] nomes = SplitString.split(nome, " ");
		int i = 0 ;
		while(i<nomes.length){
			System.out.println("nome: " + nomes[i]);
			i++;
		}
		if(nomes.length >= 2){
			return true;
		}
		return false;
	}
	// barrreto
	
	public boolean validarNomeCompleto(){
		
                String nomes[] = SplitString.split(this.contato.getNome().trim(), " ");
		boolean r = true;
		int i = 0 ;
		while(i<nomes.length && r==true){
			 r = validarLetras(nomes[i]);
			i++;
		}
		return r;
	}
	
	public boolean validarLetras(String nome){
		
		char caracteres[] = nome.toCharArray();
		for(int i = 0 ; i< caracteres.length; i++){
			System.out.println("char : " + caracteres[i]);
		}
		int i = 0 ; 
		char atual;
		char proximo;
		boolean valido = true;
		while((i<(caracteres.length-1))&&(valido==true)){
			atual = caracteres[i];
			proximo = caracteres[i+1];
			System.out.println(" comparando atual = " + atual + " com proximo = " + proximo);
			if(atual==proximo){
				int posicao = i+=2;
				if(posicao<caracteres.length){
					char proximoTerceiro = caracteres[posicao];
					System.out.println(" -> comparando atual = " + proximo + " com proximo = " + proximoTerceiro);
					if(proximo==proximoTerceiro){					
						valido = false;
						System.out.println("3 letras iguais");
					}
				}
				
			}
			i++;
		}
		System.out.println("boolean valido = " + valido);
		return valido;
	}
	
	public boolean validarCelular(){
		String cel = this.contato.getCelular().trim();
		if(cel.length() != 8){
			return false;
		}
		return true;
	}
        public boolean validarFone(){
		String fone = this.contato.getFone().trim();
		if(fone.length() != 8){
			return false;
		}
		return true;
	}
	
	public boolean validarEmail(){
		String email =  this.contato.getEmail().trim();
		String[] nomes = SplitString.split(email, "@");
		for(int i = 0; i< nomes.length; i++){
			System.out.println("n = " + nomes[i]);			
		}
		if(nomes.length > 2){
			return false;
		}
		if ( email == null ){
		      return false;
		}if ( email.indexOf(".") < 0 ){
		      return false;
		}
		if ( email.indexOf("@") < 0){
		      return false;
		}	

		return true;
	}
	
	
	
	public ValidarContato(Contato contato) {
		super();
		this.contato = contato;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
