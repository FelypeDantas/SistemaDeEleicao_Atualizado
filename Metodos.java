package Eleicao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Metodos {
	
	Cadastro_Eleitor[] eleitor = new Cadastro_Eleitor[10];
	Votacao[] votacao1 = new Votacao[5];
	Votacao[] votacao2 = new Votacao[5];
	Votacao[] apuracao = new Votacao[10];

	public Cadastro_Eleitor[] CadastraEleitor(Cadastro_Eleitor[] eleitor) throws IOException {
		int i;
		String fileName = "ArquivoCadastroEleitor.txt";
		BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
		for(i=0; i<10; i++) {
			eleitor[i].nomeEleitor = JOptionPane.showInputDialog("Informe o nome do Eleitor: ");
			gravar.write(eleitor[i].nomeEleitor);
			gravar.newLine();
			eleitor[i].NumeroEleitor = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de Eleitor: "));
			gravar.write(eleitor[i].NumeroEleitor);
			gravar.newLine();
			eleitor[i].secao = secao(votacao1, votacao2 , eleitor);
		}
		gravar.close();
		return eleitor;
	}

	private int secao(Votacao[] votacao1, Votacao[] votacao2, Cadastro_Eleitor[] eleitor) {
		int c, opc = 0;
			
			 opc = Integer.parseInt(JOptionPane.showInputDialog("Digite entre: \n 1 , 3 , 4 \n 5 , 9 , 10 \n 2 - Finaliza"));
			 
			switch(opc) {
			case 1: c = 1;
			        break;
			case 3: c = 3;
			        break;
			case 4: c = 4;
			        break;
			case 5: c = 5;
			        break;
			case 9: c = 9;
			        break;
			case 10: c = 10;
			        break;
			case 2: JOptionPane.showMessageDialog(null, "Finaliza Programa");
			        break;
			default: JOptionPane.showMessageDialog(null, "Opção Inválida");
		}
		return c;
	}

	public void CadastraVotacao() {
		int opc = 0;
		
		while(opc != 9) {
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha: \n 1 - Cadastro Votação 1 \n 2 - Cadastro Votação 2 \n 9 - Finaliza"));
			
			switch(opc) {
			case 1: CadastraVotacao1(votacao1, eleitor);
			        break;
			case 2: CadastraVotacao2(votacao2, eleitor);
			        break;
			case 9: JOptionPane.showMessageDialog(null, "Finaliza Cadastro");
			        break;
			default: JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente: ");
			}
		}
		
	}

	private void CadastraVotacao2(Votacao[] votacao2, Cadastro_Eleitor[] eleitor) {
int i;
		
		for(i=0; i<5; i++) {
			if(eleitor[i].secao == 1 / 3 / 4) {
				votacao2[i].Secao = eleitor[i].secao;
				votacao2[i].NumEleitor = eleitor[i].NumeroEleitor;
				votacao2[i].CodCandidato = Candidatos();
				
			}
		}
		
	}
		

	private void CadastraVotacao1(Votacao[] votacao1, Cadastro_Eleitor[] eleitor) {
		int i;
		
		for(i=0; i<5; i++) {
			if(eleitor[i].secao == 1 / 3 / 4) {
				votacao1[i].Secao = eleitor[i].secao;
				votacao1[i].NumEleitor = eleitor[i].NumeroEleitor;
				votacao1[i].CodCandidato = Candidatos();
				
			}
		}
		
	}

	private int Candidatos() {
		int opc = 0, i , candidato = 0;
		
		for(i=0; i<5; i++ ) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Candidatos: \n 1 - José \n 2 - Maria \n 3 - Branco \n 4 - Nulo"));
			
			switch(opc) {
			case 1: candidato = 1;
			        break;
			case 2: candidato = 2;
			        break;
			case 3: candidato = 3;
			        break;
			case 4: candidato = 4;
			        break;
			default: candidato = 4;
			}
			return candidato;
		}
		return candidato;
	}

	public void AgrupaApuracao(Votacao[] apuracao, Votacao[] votacao1, Votacao[] votacao2) {
		int i, j, aux;
		
		for(i=0; i<10; i++) {
			apuracao[i].Secao = votacao1[i].Secao;
			apuracao[i].NumEleitor = votacao1[i].NumEleitor;
			apuracao[i].CodCandidato = votacao1[i].CodCandidato;
		    apuracao[i+5].Secao = votacao2[i].Secao;
		    apuracao[i+5].NumEleitor = votacao2[i].NumEleitor;
		    apuracao[i+5].CodCandidato = votacao2[i].CodCandidato;
	   }

    }

	public void MenuEstatistica() {
		int opc = 0;
		
		while(opc != 9) {
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha: \n 1 - Vencedor \n 2 - Segundo Colocado \n 3 - Quantidade de votos em Branco \n 4 - Quantidade de votos nulos \n 5 - Mostra Eleitores \n 6 - Mostra apuracao \n 9 - fim"));
			
			switch(opc) {
			case 1: Vencedor(apuracao);
			        break;
			case 2: SegundoColocado(apuracao);
			        break;
			case 3: VotosBranco(apuracao);
			        break;
			case 4: VotosNulo(apuracao);
			        break;
			case 5: MostraEleitores(apuracao);
			        break;
			case 6: MostraApuracao(apuracao);
			        break;
			case 9: JOptionPane.showMessageDialog(null, "Finaliza Consulta");
			       break;
			default: JOptionPane.showMessageDialog(null, "Opção Inválida");
			}
		}
		
	}

	private void MostraApuracao(Votacao[] apuracao) {
		int i;
		for(i=0; i<10; i++) {
			System.out.println("apuracao de número de eleitores: " + apuracao[i].NumEleitor);
			System.out.println("apuracao da secão: " + apuracao[i].Secao);
			System.out.println("apuracao do Candidato: " + apuracao[i].CodCandidato);
		}
		
	}

	private void MostraEleitores(Votacao[] apuracao) {
		int i;
		for(i=0; i<10; i++) {
			System.out.println("Eleitor: " + apuracao[i].NumEleitor);
		}
		System.out.println("_______________________________________________");
	}

	private void VotosNulo(Votacao[] apuracao) {
		int i, contador = 0;
		for(i=0; i<10; i++) {
			if(apuracao[i].CodCandidato == 3) {
				contador = contador + 1;
			}
		}
		System.out.println("Tiveram: " + contador + "Votos Nulos");
	}
		

	private void VotosBranco(Votacao[] apuracao2) {
		int i, contador = 0;
		for(i=0; i<10; i++) {
			if(apuracao[i].CodCandidato == 4) {
				contador = contador + 1;
			}
		}
		System.out.println("Tiveram: " + contador + "Votos em Branco");
	}

	private void SegundoColocado(Votacao[] apuracao2) {
        int i, maior = 0, maior2 = 0;
		
		for(i=0; i<10; i++) {
			if(apuracao[i].CodCandidato == 1) {
				maior = maior + 1;
			}
			else if(apuracao[i].CodCandidato == 2) {
				maior2 = maior2 + 1;
			}
		}
		if(maior2 <= maior) {
			System.out.println("O segundo colocado foi Maria com:" + maior2);
		}
		else {
			System.out.println("O segundo colocado foi o João com:" + maior);
		}
		
	}

	private void Vencedor(Votacao[] apuracao) {
		int i, maior = 0, maior2 = 0;
		
		for(i=0; i<10; i++) {
			if(apuracao[i].CodCandidato == 1) {
				maior = maior + 1;
			}
			else if(apuracao[i].CodCandidato == 2) {
				maior2 = maior2 + 1;
			}
		}
		if(maior2 >= maior) {
			System.out.println("O vencedor(a) foi Maria com:" + maior2);
		}
		else {
			System.out.println("O vencedor foi o João com:" + maior);
		}
	}
}
