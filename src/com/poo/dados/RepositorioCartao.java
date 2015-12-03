package com.poo.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.beans.Cartao;

public class RepositorioCartao implements IRepositorioCartao, Serializable{
	private Cartao[] listaDeCartao;
	private int proxima;
	
	private static RepositorioCartao instance;
	
	public RepositorioCartao(int tamanho){
		this.listaDeCartao = new Cartao[tamanho];
		this.proxima = 0;
	}
	
	public static IRepositorioCartao getInstance() {
		if (instance == null) {
			instance = abrirArquivo();
		}
		return instance;
	}
	
	private static RepositorioCartao abrirArquivo() {

		RepositorioCartao instanciaLocal = null;
		File in = new File("DADOS\\CADASTRO CARTAO\\cadastrocartao.txt");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioCartao) o;
		} catch (Exception e) {
			
			instanciaLocal = new RepositorioCartao(50);
			
		} finally {

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;

	}
	
	public static void salvarArquivo(){

		if (instance == null) {
			return;
		}

		File dir = new File("DADOS\\CADASTRO CARTAO");
		dir.mkdirs();
		File out = new File(dir,"cadastrocartao.txt");
        
		if (!out.exists()){
			try{
				out.createNewFile();				
			}catch(IOException e){
				/*Silent*/
			}
        }
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);

		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {/* Silent */
				}
			}
		}
	}
	
/**
	 * Verifica se cartao existe ou não
	 * 
	 * @param cartao 
	 * @return true se existir um cartao e false caso não exista
	 */
	public boolean existe(Cartao cartao){
		boolean achou = false;
		for(int i = 0; i <= (this.listaDeCartao.length-1); i++){
			if(this.listaDeCartao[i].getNumeroCartao() == cartao.getNumeroCartao()){
				achou = true;
			}
		}
		return achou;
	}
	
	/**
	 * Adiciona um novo cartão a lista de cartões
	 * 
	 * @param cartao
	 * @throws IOException
	 * @throws CadastroCartaoExistenteException
	 */
	public void inserirCartao(Cartao cartao) throws NegocioException{
		if(!this.existe(cartao)){
			this.listaDeCartao[this.proxima] = cartao;
			this.proxima++;
			salvarArquivo();
		}else{
			throw new NegocioException("INSERIR - " + cartao.getNumeroCartao() + "JA EXISTE");
		}
		if(this.proxima == this.listaDeCartao.length){
			this.duplicaArrayCartao();
		}
		salvarArquivo();
	}
	
	public Cartao[] listarCartoes(){
		return this.listaDeCartao;
	}
	/**
	 * Duplica o array caso seja necessário mais espaço para o vetor
	 */
	private void duplicaArrayCartao() {

		if (this.listaDeCartao != null && this.listaDeCartao.length > 0) {
		    Cartao[] arrayDuplicado = new Cartao[this.listaDeCartao.length * 2];
			for (int i = 0; i < this.listaDeCartao.length; i++) {
				arrayDuplicado[i] = this.listaDeCartao[i];

			}
			this.listaDeCartao = arrayDuplicado;
		}
	}
	

	@Override
	public boolean equals(Cartao a, Cartao B) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}

