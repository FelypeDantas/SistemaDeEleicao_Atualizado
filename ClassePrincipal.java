package Eleicao;

import javax.swing.JOptionPane;
import java.io.IOException;

public class ClassePrincipal {
  public static void main(String[] args) throws IOException {
	  Votacao[] votacao1 = new Votacao[5];
	  Votacao[] votacao2 = new Votacao[5];
	  Votacao[] apuracao = new Votacao[10];
	  Cadastro_Eleitor[] eleitor = new Cadastro_Eleitor[10];
	  Metodos m = new Metodos();
	  int i, opc = 0;
	  
	  for(i=0; i<5; i++) {
		  votacao1[i] = new Votacao();
		  votacao2[i] = new Votacao();
	  }
	  for(i=0; i<10; i++) {
		  eleitor[i] = new Cadastro_Eleitor();
		  apuracao[i] = new Votacao();
	  }
	  
	  while(opc != 9) {
		  
		  opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha: \n 1 - Cadastra Eleitor \n 2 - Cadastra Votacao 1 e 2 \n 3 - Agrupa apuracão \n 4 - Menu estatistica \n 9 - Finaliza"));
		  
		  switch(opc) {
		  case 1: eleitor = m.CadastraEleitor(eleitor);
		          break;
		  case 2: m.CadastraVotacao();
		          break;
		  case 3: m.AgrupaApuracao(apuracao, votacao1, votacao2);
		          break;
		  case 4: m.MenuEstatistica();
		          break;
		  case 9: JOptionPane.showMessageDialog(null, "Finaliza Programa");
		          break;
		  default: JOptionPane.showMessageDialog(null, "Opção Inválida, digite novamente: ");
		  }
	  }
  }
}
