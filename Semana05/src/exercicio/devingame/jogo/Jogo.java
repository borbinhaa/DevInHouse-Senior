package exercicio.devingame.jogo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import exercicio.devingame.interfaces.EscolhidoPorOpcao;
import exercicio.devingame.personagens.Inimigo;
import exercicio.devingame.personagens.Personagem;
import exercicio.devingame.personagens.PersonagemPrincipal;
import lombok.Getter;
import lombok.Setter;

public class Jogo implements EscolhidoPorOpcao {

	@Setter
	@Getter
	private Dificuldade dificuldade;
	private String nome;
	private Scanner scanner = new Scanner(System.in);
	@Getter
	private PersonagemPrincipal personagem = new PersonagemPrincipal();
	@Getter
	private List<Inimigo> inimigos = Arrays.asList(new Inimigo("Orque Horrendo", 20, 50, 10),
			new Inimigo("Orque Horrendo 2", 20, 50, 10), new Inimigo("L�der", 30, 100, 15));
	@Getter
	@Setter
	private boolean desistiu = false;
	@Getter @Setter
	private Decisao1 motivacao;

	public Jogo(String nome) {
		this.nome = nome;
	}

	public void iniciarJogo() {

		this.introducao();

		while (!desistiu) {
			this.decisao01();
			System.out.println();
			this.decisao02();
			System.out.println();
			if (desistiu) {
				System.out.println("Voc� desistiu, tente novamente outra vez.");
				break;
			}
			this.decisao03();
			System.out.println();
			this.decisao04();
			if (desistiu) {
				System.out.println("Voc� desistiu, tente novamente outra vez.");
				break;
			}
			this.decisao05();
			if (desistiu) {
				System.out.println("Voc� desistiu, tente novamente outra vez.");
				break;
			}
			this.decisao06();
			
			if (desistiu) {
				System.out.println("Voc� desistiu, tente novamente outra vez.");
				break;
			}
			
			this.textoFinal(motivacao);
			System.out.println("Voc� se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos voc�s saem em\n"
					+ "dire��o � noite, retornando � cidade. Seu dever est� cumprido.\n\n" 
					+ "O jogo encerra.");

			this.setDesistiu(true);
		}

	}

	private void introducao() {
		this.escolherDificuldade();
		this.personagem.escolherNomeESexo();
		this.personagem.escolherClasse();
		this.personagem.escolherArma();
		this.personagem.setVida(100);

		if (this.dificuldade == Dificuldade.FACIL) {
			inimigos.forEach(e -> e.setDano(e.getDano() * 0.8));
		} else if (this.dificuldade == Dificuldade.DIFICIL) {
			this.personagem.setDano(this.personagem.getDano() * 0.9);
		}
	}

	private void escolherDificuldade() {
		try {
			Dificuldade[] dificuldades = Dificuldade.values();
			System.out.println("Escolha a dificuldade:");

			List<Dificuldade> dificuldaesList = Arrays.asList(dificuldades);

			this.showOptions(dificuldaesList);

			String dificuldadeEscolhidaStr = scanner.nextLine();

			switch (dificuldadeEscolhidaStr) {
			case "1": {
				this.setDificuldade(Dificuldade.FACIL);
				break;
			}
			case "2": {
				this.setDificuldade(Dificuldade.NORMAL);
				break;
			}
			case "3": {
				this.setDificuldade(Dificuldade.DIFICIL);
				break;
			}
			default:
				throw new IllegalArgumentException("Valor incorreto");
			}

			System.out.println();

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			this.escolherDificuldade();
		}

	}

	public void combate(Personagem p1, Personagem p2) {

		boolean isFighting = true;
		while (isFighting) {
			try {
				System.out.println("Voc� deseja atacar");
				System.out.println("(1) - SIM");
				System.out.println("(2) - N�O");

				String value = scanner.nextLine();

				switch (value) {
				case "1": {
					double danoAtaquep1 = this.getDanoAtaque(p1, p2);
					p1.atacar(p2, danoAtaquep1);
					if (p2.isDead()) {
						isFighting = false;
						System.out.println(p1.getNome() + " eliminou " + p2.getNome());
						break;
					}

					double danoAtaquep2 = this.getDanoAtaque(p2, p1);
					p2.atacar(p1, danoAtaquep2);

					if (p1.isDead()) {
						isFighting = false;
						System.out.println(p2.getNome() + " eliminou " + p1.getNome());
						break;
					}
					break;
				}
				case "2": {
					isFighting = false;
					this.setDesistiu(true);
					break;
				}
				default:
					throw new IllegalArgumentException("Valor incorreto, tente novamente.");
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	private double getDanoAtaque(Personagem p1, Personagem p2) {
		int numDado = this.girarDado(20);
		if (numDado == 1) {
			return 0;
		} else if (numDado == 20) {
			System.out.println("Ataque cr�tico.");
			return p1.getDano() + numDado;
		}

		return p1.getDano() + numDado - p2.getArmadura();
	}

	private int girarDado(int numTeto) {
		Random random = new Random();
		int numDado = (random.nextInt(numTeto) + 1);
		return numDado;
	}

	private void decisao01() {
		System.out.println(
				"A noite se aproxima, a lua j� surge no c�u, estrelas v�o se acendendo, e sob a luz do crep�sculo voc� est�\n"
						+ "prestes a entrar na fase final da sua miss�o. Voc� olha para o portal � sua frente, e sabe que a partir desse\n"
						+ "ponto, sua vida mudar� para sempre.\n" + "\n"
						+ "Mem�rias do caminho percorrido para chegar at� aqui invadem sua mente. Voc� se lembra de todos os\n"
						+ "inimigos j� derrotados para alcan�ar o covil do l�der maligno. Olha para seu equipamento de combate,\n"
						+ "j� danificado e desgastado depois de tantas lutas. Voc� est� a um passo de encerrar para sempre esse mal.\n"
						+ "\n" + "Buscando uma inje��o de �nimo, voc� se for�a a lembrar o que te trouxe at� aqui.");

		this.askDecision01();

	}

	private void decisao02() {
		System.out.println("Inspirado pelo motivo que te trouxe at� aqui, voc� sente seu cora��o ardendo em chamas,\n"
				+ "suas m�os formigarem em volta da sua arma. Voc� a segura com firmeza. Seu foco est� renovado.\n"
				+ "Voc� avan�a pelo portal.\n" + "\n"
				+ "A escurid�o te envolve. Uma ilumina��o muito fraca entra pelo portal �s suas costas. � sua\n"
				+ "frente, s� � poss�vel perceber que voc� se encontra em um corredor extenso. Voc� s� pode ir\n"
				+ "� frente, ou desistir.");

		this.askDecision02();
	}

	private void decisao03() {
		System.out.println("Voc� se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha,zn"
				+ "e pondera sobre como passar pela porta.");

		this.askDecision03();

	}

	private void decisao04() {
		System.out.println("Voc� se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede.\n"
				+ "Uma delas foi aquela pela qual voc� entrou, que estava aberta, e as outras tr�s est�o\n"
				+ "fechadas. A porta � sua frente � a maior das quatro, com inscri��es em seu entorno em\n"
				+ "uma l�ngua que voc� n�o sabe ler, mas reconhece como sendo a l�ngua antiga utilizada\n"
				+ "pelo inimigo. Voc� se aproxima da porta e percebe que ela est� trancada por duas\n"
				+ "fechaduras douradas, e voc� entende que precisar� primeiro derrotar o que estiver nas\n"
				+ "outras duas portas laterais, antes de conseguir enfrentar o l�der.");

		System.out.println("\nVoc� se dirige para a porta � direita.\n");

		System.out.println(
				"PORTA DIREITA: Voc� se aproxima, tentando ouvir o que acontece porta adentro, mas n�o escuta nada.\n"
						+ "Segura com mais for�a sua arma com uma m�o, enquanto empurra a porta com a outra.\n"
						+ "Ao entrar, voc� se depara com uma sala espa�osa, com v�rios equipamentos de batalha\n"
						+ "pendurados nas paredes e dispostos em arm�rios e mesas. Voc� imagina que este seja o\n"
						+ "arsenal do inimigo, onde est�o guardados os equipamentos que seus soldados utilizam\n"
						+ "quando saem para espalhar o terror nas cidades e vilas da regi�o.\n\n"
						+ "Enquanto seu olhar percorre a sala, voc� ouve a porta se fechando e gira rapidamente\n"
						+ "para olhar para tr�s. Ali, de p� entre voc� e a porta fechada, bloqueando o caminho\n"
						+ "do seu destino, est� um dos capit�es do inimigo. Um orque horrendo, de armadura,\n"
						+ "capacete e espada em punho, em posi��o de combate. Ele avan�a em sua dire��o.");

		this.combate(this.getPersonagem(), this.inimigos.get(0));
		if (!desistiu) {
			System.out
					.println("\nAp�s derrotar o Armeiro, voc� percebe que seus equipamentos est�o muito danificados,\n"
							+ "e olha em volta, encarando todas aquelas pe�as de armaduras resistentes e em �timo\n"
							+ "estado.");

			this.askDecision04();
		}

	}

	private void decisao05() {
		System.out.println(
				"Em uma mesa, voc� encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras\n"
						+ " da porta do l�der inimigo. Voc� pega a chave e guarda numa pequena bolsa que leva presa ao cinto.\n\n"
						+ "PORTA ESQUERDA: Voc� retorna � sala anterior e se dirige � porta da esquerda. Voc� se aproxima,\n"
						+ "tentando ouvir o que acontece porta adentro, mas n�o escuta nada. Segura com mais for�a sua arma\n"
						+ "com uma m�o, enquanto empurra a porta com a outra. Ao entrar, voc� se depara com uma sala parecida\n"
						+ "com a do arsenal, mas em vez de armaduras, existem v�rios potes e garrafas de vidro com conte�dos\n"
						+ "misteriosos e de cores diversas, e voc� entende que o capit�o que vive ali, realiza experimentos com\n"
						+ "diversos ingredientes, criando po��es utilizadas pelos soldados para aterrorizar a regi�o.\n\n"
						+ "No fundo da sala, olhando em sua dire��o, est� outro dos capit�es do inimigo. Um orque horrendo,\n"
						+ "de armadura, cajado em punho, em posi��o de combate. Ele avan�a em sua dire��o.");

		this.combate(this.getPersonagem(), this.inimigos.get(1));

		if (!desistiu) {
			System.out.println(
					"\nAp�s derrotar o Alquimista, voc� olha em volta, tentando reconhecer alguma po��o do estoque\n"
							+ "do inimigo. Em uma mesa, voc� reconhece uma pequena garrafa de vidro contendo um l�quido levemente\n"
							+ "rosado, pega a garrafa e pondera se deve beber um gole.");

			this.askDecision05();
		}
	}

	private void decisao06() {
		System.out.println(
				"Ao lado da porta, voc� v� uma chave dourada em cima de uma mesa, e sabe que aquela chave abre a outra\n"
						+ "fechadura da porta do l�der inimigo. Voc� pega a chave e guarda na pequena bolsa que leva presa ao cinto.\n\n"
						+ "De volta � sala das portas, voc� se dirige � porta final. Coloca as chaves nas fechaduras, e a porta se\n"
						+ "abre. Seu cora��o acelera, mem�rias de toda a sua vida passam pela sua mente, e voc� percebe que est�\n"
						+ " muito pr�ximo do seu objetivo final. Segura sua arma com mais firmeza, foca no combate que voc� sabe\n"
						+ " que ir� se seguir, e adentra a porta.\n\n"
						+ "L� dentro, voc� v� o l�der sentado em uma poltrona dourada, com duas fogueiras de cada lado, e\n"
						+ "prisioneiros acorrentados �s paredes.\n\n"
						+ "Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de l�mina dupla.");
		
		this.askDecision06();
	}
	
	private void textoFinal(Decisao1 motivo) {
		if (motivo == Decisao1.GLORIA) {
			System.out.println("O �xtase em que voc� se encontra n�o cabe dentro de si. Voc� se ajoelha e grita de alegria.\n"
					+ "A gl�ria o aguarda, voc� a conquistou.");
		} else {
			System.out.println("Voc� obteve sua vingan�a. Voc� se ajoelha e cai no choro, invadido por uma sensa��o de al�vio \n"
					+ "e felicidade. Voc� se vingou, tudo que sempre quis, est� feito. Agora voc� pode seguir sua vida.");
		}
	}

	private void askDecision01() {
		Decisao1[] decisoesArray = Decisao1.values();
		List<Decisao1> decisoes = Arrays.asList(decisoesArray);

		try {
			this.showOptions(decisoes);

			String decisao = scanner.nextLine();
			System.out.println();
			switch (decisao) {
			case "1": {
				this.setMotivacao(Decisao1.GLORIA);
				System.out.println("Voc� j� consegue visualizar na sua mente o povo da cidade te recebendo de bra�os\n"
						+ "abertos, bardos criando can��es sobre seus feitos her�icos, nobres te presenteando\n"
						+ "com j�ias e diversas riquezas, taberneiros se recusando a cobrar por suas bebedeiras\n"
						+ "e comilan�as. Desde j�, voc� sente o amor do p�blico, te louvando a cada passo que\n"
						+ "d� pelas ruas, depois de destruir o vil�o que tanto assombrou a paz de todos. Por�m,\n"
						+ "voc� sabe que ainda falta o �ltimo ato dessa hist�ria. Voc� se concentra na miss�o.\n"
						+ "A gl�ria o aguarda, mas n�o antes da �ltima batalha.");

				break;
			}
			case "2": {
				this.setMotivacao(Decisao1.VINGAN�A);
				System.out.println(
						"Imagens daquela noite tr�gica invadem sua mente. Voc� nem precisa se esfor�ar para lembrar,\n"
								+ "pois essas mem�rias est�o sempre presentes, mesmo que de pano de fundo, quando voc� tem outros\n"
								+ "pensamentos em foco, elas nunca o deixaram. Elas s�o o combust�vel que te fizeram chegar at�\n"
								+ "aqui. E voc� sabe que n�o ir� desistir at� ter vingado a morte daqueles que foram - e pra sempre\n"
								+ "ser�o - sua fonte de amor e desejo de continuar vivo. O maldito l�der finalmente pagar� por tanto\n"
								+ "mal causado na vida de tantos (e principalmente na sua).");
				break;
			}
			default:
				throw new IllegalArgumentException("Valor inserido incorretamente");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.askDecision01();
		}

	}

	private void askDecision02() {
		Decisao2[] decisoesArray = Decisao2.values();
		List<Decisao2> decisoes = Arrays.asList(decisoesArray);

		try {
			this.showOptions(decisoes);

			String decisao = scanner.nextLine();
			System.out.println();
			switch (decisao) {
			case "1": {
				System.out.println("Voc� caminha, atento a todos os seus sentidos, por v�rios metros, at� visualizar\n"
						+ "a frente uma fonte de luz, que voc� imagina ser a chama de uma tocha, vindo de\n"
						+ "dentro de uma porta aberta.");
				break;
			}

			case "2": {
				System.out.println("O medo invade o seu cora��o e voc� sente que ainda n�o est� � altura do desafio.\n"
						+ "Voc� se volta para a noite l� fora e corre em dire��o � seguran�a.");

				this.setDesistiu(true);
				break;
			}
			default:
				throw new IllegalArgumentException("Valor inserido incorretamente");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.askDecision02();
		}

	}

	private void askDecision03() {
		Decisao3[] decisoesArray = Decisao3.values();
		List<Decisao3> decisoes = Arrays.asList(decisoesArray);

		try {
			this.showOptions(decisoes);

			String decisao = scanner.nextLine();
			System.out.println();
			switch (decisao) {
			case "1": {
				System.out.println(
						"Voc� se concentra e pula em dire��o � luz, saltando de antes da porta at� o interior da sala.");
				break;
			}
			case "2": {
				System.out.println(
						"Voc� toma cuidado e vai caminhando vagarosamente em dire��o � luz. Quando voc� pisa exatamente embaixo da porta, voc� sente o ch�o ceder levemente, como se tivesse pisado em uma pedra solta. Voc� ouve um ru�do de mecanismos se movimentando, e uma escotilha se abre no teto atr�s de voc�, no corredor. Flechas voam da escotilha em sua dire��o, e voc� salta para dentro da sala,\n"
								+ "por�m uma delas te acerta na perna.");

				int dado = this.girarDado(10);
				int dano = 10 - dado;
				this.getPersonagem().setVida(this.getPersonagem().getVida() - dano);
				System.out.println("Voc� rola o dado e sai: " + dado + ". Logo voc� toma " + dano + " de dano.");
				System.out.println("Vida atual = " + this.getPersonagem().getVida());
				break;
			}
			case "3": {
				System.out.println("Voc� respira fundo e desata a correr em dire��o � sala. Quando passa pela porta, \n"
						+ "sente que pisou em uma pedra solta, mas n�o d� muita import�ncia e segue para dentro\n"
						+ "da sala, olhando ao redor � procura de inimigos. N�o tem ningu�m, mas voc� ouve sons\n"
						+ "de flechas batendo na pedra atr�s de voc�, e quando se vira, v� v�rias flechas no ch�o.\n"
						+ "Espiando pela porta, voc� entende que pisou em uma armadilha que soltou flechas de uma escotilha\n"
						+ "aberta no teto, mas por sorte voc� entrou correndo e conseguiu escapar desse ataque surpresa.");
				break;
			}
			default:
				throw new IllegalArgumentException("Valor inserido incorretamente");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.askDecision03();
		}
	}

	private void askDecision04() {
		Decisao4[] decisoesArray = Decisao4.values();
		List<Decisao4> decisoes = Arrays.asList(decisoesArray);

		try {
			this.showOptions(decisoes);

			String decisao = scanner.nextLine();
			System.out.println();
			switch (decisao) {
			case "1": {
				System.out.println("Voc� resolve usar os equipamentos do inimigo contra ele, e trocar\n"
						+ "algumas pe�as suas, que estavam danificadas, pelas pe�as de armaduras existentes\n"
						+ "na sala. De armadura nova, voc� se sente mais protegido para os desafios � sua\n"
						+ "frente.");
				System.out.println("Seu personagem ganha mais 5 de armadura");

				this.getPersonagem().setArmadura(this.getPersonagem().getArmadura() + 5);
				System.out.println("Nova Armadura = " + this.getPersonagem().getArmadura() + ".\n");
				break;
			}
			case "2": {
				System.out.println("Voc� decide que n�o precisa utilizar nada que venha das m�os do inimigo.");
				break;
			}
			default:
				throw new IllegalArgumentException("Valor inserido incorretamente");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.askDecision04();
		}
	}

	private void askDecision05() {
		Decisao5[] decisoesArray = Decisao5.values();
		List<Decisao5> decisoes = Arrays.asList(decisoesArray);

		try {
			this.showOptions(decisoes);

			String decisao = scanner.nextLine();
			System.out.println();
			switch (decisao) {
			case "1": {
				System.out.println("Voc� se sente revigorado para seguir adiante!");
				System.out.println("Seu personagem recupera toda a vida.");

				this.getPersonagem().setVida(100);
				break;
			}
			case "2": {
				System.out.println("Voc� fica receoso de beber algo produzido pelo inimigo");
				break;
			}
			default:
				throw new IllegalArgumentException("Valor inserido incorretamente");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.askDecision05();
		}
	}
	
	private void askDecision06() {
		Decisao6[] decisoesArray = Decisao6.values();
		List<Decisao6> decisoes = Arrays.asList(decisoesArray);

		try {
			this.showOptions(decisoes);

			String decisao = scanner.nextLine();
			System.out.println();
			switch (decisao) {
			case "1": {
				this.combate(this.getPersonagem(), this.getInimigos().get(2));
				break;
			}
			case "2": {
				this.combate(this.getInimigos().get(2), this.getPersonagem());
				break;
			}
			default:
				throw new IllegalArgumentException("Valor inserido incorretamente");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.askDecision06();
		}
	}

}
