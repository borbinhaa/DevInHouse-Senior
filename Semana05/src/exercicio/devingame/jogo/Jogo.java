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
			new Inimigo("Orque Horrendo 2", 20, 50, 10), new Inimigo("Líder", 30, 100, 15));
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
				System.out.println("Você desistiu, tente novamente outra vez.");
				break;
			}
			this.decisao03();
			System.out.println();
			this.decisao04();
			if (desistiu) {
				System.out.println("Você desistiu, tente novamente outra vez.");
				break;
			}
			this.decisao05();
			if (desistiu) {
				System.out.println("Você desistiu, tente novamente outra vez.");
				break;
			}
			this.decisao06();
			
			if (desistiu) {
				System.out.println("Você desistiu, tente novamente outra vez.");
				break;
			}
			
			this.textoFinal(motivacao);
			System.out.println("Você se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos vocês saem em\n"
					+ "direção à noite, retornando à cidade. Seu dever está cumprido.\n\n" 
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
				System.out.println("Você deseja atacar");
				System.out.println("(1) - SIM");
				System.out.println("(2) - NÃO");

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
			System.out.println("Ataque crítico.");
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
				"A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo, e sob a luz do crepúsculo você está\n"
						+ "prestes a entrar na fase final da sua missão. Você olha para o portal à sua frente, e sabe que a partir desse\n"
						+ "ponto, sua vida mudará para sempre.\n" + "\n"
						+ "Memórias do caminho percorrido para chegar até aqui invadem sua mente. Você se lembra de todos os\n"
						+ "inimigos já derrotados para alcançar o covil do líder maligno. Olha para seu equipamento de combate,\n"
						+ "já danificado e desgastado depois de tantas lutas. Você está a um passo de encerrar para sempre esse mal.\n"
						+ "\n" + "Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.");

		this.askDecision01();

	}

	private void decisao02() {
		System.out.println("Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas,\n"
				+ "suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado.\n"
				+ "Você avança pelo portal.\n" + "\n"
				+ "A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas. À sua\n"
				+ "frente, só é possível perceber que você se encontra em um corredor extenso. Você só pode ir\n"
				+ "à frente, ou desistir.");

		this.askDecision02();
	}

	private void decisao03() {
		System.out.println("Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha,zn"
				+ "e pondera sobre como passar pela porta.");

		this.askDecision03();

	}

	private void decisao04() {
		System.out.println("Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede.\n"
				+ "Uma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão\n"
				+ "fechadas. A porta à sua frente é a maior das quatro, com inscrições em seu entorno em\n"
				+ "uma língua que você não sabe ler, mas reconhece como sendo a língua antiga utilizada\n"
				+ "pelo inimigo. Você se aproxima da porta e percebe que ela está trancada por duas\n"
				+ "fechaduras douradas, e você entende que precisará primeiro derrotar o que estiver nas\n"
				+ "outras duas portas laterais, antes de conseguir enfrentar o líder.");

		System.out.println("\nVocê se dirige para a porta à direita.\n");

		System.out.println(
				"PORTA DIREITA: Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
						+ "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
						+ "Ao entrar, você se depara com uma sala espaçosa, com vários equipamentos de batalha\n"
						+ "pendurados nas paredes e dispostos em armários e mesas. Você imagina que este seja o\n"
						+ "arsenal do inimigo, onde estão guardados os equipamentos que seus soldados utilizam\n"
						+ "quando saem para espalhar o terror nas cidades e vilas da região.\n\n"
						+ "Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente\n"
						+ "para olhar para trás. Ali, de pé entre você e a porta fechada, bloqueando o caminho\n"
						+ "do seu destino, está um dos capitães do inimigo. Um orque horrendo, de armadura,\n"
						+ "capacete e espada em punho, em posição de combate. Ele avança em sua direção.");

		this.combate(this.getPersonagem(), this.inimigos.get(0));
		if (!desistiu) {
			System.out
					.println("\nApós derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados,\n"
							+ "e olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo\n"
							+ "estado.");

			this.askDecision04();
		}

	}

	private void decisao05() {
		System.out.println(
				"Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras\n"
						+ " da porta do líder inimigo. Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.\n\n"
						+ "PORTA ESQUERDA: Você retorna à sala anterior e se dirige à porta da esquerda. Você se aproxima,\n"
						+ "tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura com mais força sua arma\n"
						+ "com uma mão, enquanto empurra a porta com a outra. Ao entrar, você se depara com uma sala parecida\n"
						+ "com a do arsenal, mas em vez de armaduras, existem vários potes e garrafas de vidro com conteúdos\n"
						+ "misteriosos e de cores diversas, e você entende que o capitão que vive ali, realiza experimentos com\n"
						+ "diversos ingredientes, criando poções utilizadas pelos soldados para aterrorizar a região.\n\n"
						+ "No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo. Um orque horrendo,\n"
						+ "de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.");

		this.combate(this.getPersonagem(), this.inimigos.get(1));

		if (!desistiu) {
			System.out.println(
					"\nApós derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque\n"
							+ "do inimigo. Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente\n"
							+ "rosado, pega a garrafa e pondera se deve beber um gole.");

			this.askDecision05();
		}
	}

	private void decisao06() {
		System.out.println(
				"Ao lado da porta, você vê uma chave dourada em cima de uma mesa, e sabe que aquela chave abre a outra\n"
						+ "fechadura da porta do líder inimigo. Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.\n\n"
						+ "De volta à sala das portas, você se dirige à porta final. Coloca as chaves nas fechaduras, e a porta se\n"
						+ "abre. Seu coração acelera, memórias de toda a sua vida passam pela sua mente, e você percebe que está\n"
						+ " muito próximo do seu objetivo final. Segura sua arma com mais firmeza, foca no combate que você sabe\n"
						+ " que irá se seguir, e adentra a porta.\n\n"
						+ "Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e\n"
						+ "prisioneiros acorrentados às paredes.\n\n"
						+ "Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.");
		
		this.askDecision06();
	}
	
	private void textoFinal(Decisao1 motivo) {
		if (motivo == Decisao1.GLORIA) {
			System.out.println("O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria.\n"
					+ "A glória o aguarda, você a conquistou.");
		} else {
			System.out.println("Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio \n"
					+ "e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.");
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
				System.out.println("Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços\n"
						+ "abertos, bardos criando canções sobre seus feitos heróicos, nobres te presenteando\n"
						+ "com jóias e diversas riquezas, taberneiros se recusando a cobrar por suas bebedeiras\n"
						+ "e comilanças. Desde já, você sente o amor do público, te louvando a cada passo que\n"
						+ "dá pelas ruas, depois de destruir o vilão que tanto assombrou a paz de todos. Porém,\n"
						+ "você sabe que ainda falta o último ato dessa história. Você se concentra na missão.\n"
						+ "A glória o aguarda, mas não antes da última batalha.");

				break;
			}
			case "2": {
				this.setMotivacao(Decisao1.VINGANÇA);
				System.out.println(
						"Imagens daquela noite trágica invadem sua mente. Você nem precisa se esforçar para lembrar,\n"
								+ "pois essas memórias estão sempre presentes, mesmo que de pano de fundo, quando você tem outros\n"
								+ "pensamentos em foco, elas nunca o deixaram. Elas são o combustível que te fizeram chegar até\n"
								+ "aqui. E você sabe que não irá desistir até ter vingado a morte daqueles que foram - e pra sempre\n"
								+ "serão - sua fonte de amor e desejo de continuar vivo. O maldito líder finalmente pagará por tanto\n"
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
				System.out.println("Você caminha, atento a todos os seus sentidos, por vários metros, até visualizar\n"
						+ "a frente uma fonte de luz, que você imagina ser a chama de uma tocha, vindo de\n"
						+ "dentro de uma porta aberta.");
				break;
			}

			case "2": {
				System.out.println("O medo invade o seu coração e você sente que ainda não está à altura do desafio.\n"
						+ "Você se volta para a noite lá fora e corre em direção à segurança.");

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
						"Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.");
				break;
			}
			case "2": {
				System.out.println(
						"Você toma cuidado e vai caminhando vagarosamente em direção à luz. Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta. Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor. Flechas voam da escotilha em sua direção, e você salta para dentro da sala,\n"
								+ "porém uma delas te acerta na perna.");

				int dado = this.girarDado(10);
				int dano = 10 - dado;
				this.getPersonagem().setVida(this.getPersonagem().getVida() - dano);
				System.out.println("Você rola o dado e sai: " + dado + ". Logo você toma " + dano + " de dano.");
				System.out.println("Vida atual = " + this.getPersonagem().getVida());
				break;
			}
			case "3": {
				System.out.println("Você respira fundo e desata a correr em direção à sala. Quando passa pela porta, \n"
						+ "sente que pisou em uma pedra solta, mas não dá muita importância e segue para dentro\n"
						+ "da sala, olhando ao redor à procura de inimigos. Não tem ninguém, mas você ouve sons\n"
						+ "de flechas batendo na pedra atrás de você, e quando se vira, vê várias flechas no chão.\n"
						+ "Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha\n"
						+ "aberta no teto, mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.");
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
				System.out.println("Você resolve usar os equipamentos do inimigo contra ele, e trocar\n"
						+ "algumas peças suas, que estavam danificadas, pelas peças de armaduras existentes\n"
						+ "na sala. De armadura nova, você se sente mais protegido para os desafios à sua\n"
						+ "frente.");
				System.out.println("Seu personagem ganha mais 5 de armadura");

				this.getPersonagem().setArmadura(this.getPersonagem().getArmadura() + 5);
				System.out.println("Nova Armadura = " + this.getPersonagem().getArmadura() + ".\n");
				break;
			}
			case "2": {
				System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.");
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
				System.out.println("Você se sente revigorado para seguir adiante!");
				System.out.println("Seu personagem recupera toda a vida.");

				this.getPersonagem().setVida(100);
				break;
			}
			case "2": {
				System.out.println("Você fica receoso de beber algo produzido pelo inimigo");
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
