package Eleicao;

public class Votacao {

	int Secao;
	int CodCandidato;
	int NumEleitor;
	
	Votacao(){
		this(0,0,0);
	}

	public Votacao(int i, int j, int k) {
		Secao = i;
		CodCandidato = j;
		NumEleitor = k;
	}
}
