package Eleicao;

public class Cadastro_Eleitor {

	int NumeroEleitor;
	String nomeEleitor;
	int secao;
	
	Cadastro_Eleitor(){
		this(0,"",0);
	}
	
	public Cadastro_Eleitor(int num, String nome, int s) {
		NumeroEleitor = num;
		nomeEleitor = nome;
		secao = s;
	}
}
