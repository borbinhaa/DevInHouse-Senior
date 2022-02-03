package exercicio.devingame.personagens;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import exercicio.devingame.exceptions.NoClasseException;
import exercicio.devingame.interfaces.EscolhidoPorOpcao;
import lombok.Getter;
import lombok.Setter;

public class PersonagemPrincipal extends Personagem implements EscolhidoPorOpcao {

	@Getter @Setter
	private Sexo sexo;
	@Getter @Setter
	private Classe classe;
	@Getter @Setter
	private Arma arma;
	@Getter @Setter
	private Scanner scanner = new Scanner(System.in);
	public PersonagemPrincipal() {

	}

	public PersonagemPrincipal(String nome, Sexo sexo) {
		this.nome = nome;
		this.sexo = sexo;
	}

	public void escolherClasse() {
		try {
			Classe[] classesArray = Classe.values();
			List<Classe> classes = Arrays.asList(classesArray);
			System.out.println("Escolha sua classe:");

			this.showOptions(classes);

			String escolhaClasse = scanner.nextLine();

			if (!isValidValue(escolhaClasse, classes)) {
				throw new IllegalArgumentException("Valor inserido errado");
			}

			int escolhaClasseLong = Integer.valueOf(escolhaClasse);
			Classe classeEscolhida = classes.get(escolhaClasseLong - 1);

			this.setClasse(classeEscolhida);
			this.setArmadura(classeEscolhida.getArmadura());

			System.out.println();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			this.escolherClasse();
		}
	}

	public void escolherArma() {
		try {
			if (this.getClasse() == null) {
				throw new NoClasseException("Você precisa primeiro selecionar uma classe.");
			}

			List<Arma> armas = this.getClasse().getArmasClasse();
			System.out.println("Escolha sua arma:");

			this.showOptions(armas);

			String escolhaArma = scanner.nextLine();

			if (!isValidValue(escolhaArma, armas)) {
				throw new IllegalArgumentException("Valor inserido errado");
			}

			int escolhaArmaLong = Integer.valueOf(escolhaArma);
			Arma armaEscolhida = armas.get(escolhaArmaLong - 1);

			this.setArma(armaEscolhida);
			this.setDano(armaEscolhida.getDano() + this.getClasse().getDano());
			
			System.out.println();
		} catch (IllegalArgumentException | NoClasseException e) {
			System.out.println(e.getMessage());
			this.escolherArma();
		}

	}
	
	public void escolherNomeESexo() {
		try {
			
			this.askName();
			this.askSex();
			System.out.println();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.escolherNomeESexo();
		}
		
	}
	
	private void askName() throws IllegalArgumentException {
		System.out.println("Escolha seu nome: ");
		nome = scanner.nextLine();
		
		if (nome.isEmpty()) {
			throw new IllegalArgumentException("Você precisa digitar um nome.");
		}
		
		this.setNome(nome);
	}
	
	private void askSex() {
		Sexo[] sexos = Sexo.values();
		List<Sexo> sexosList = Arrays.asList(sexos);
		
		System.out.println("Escolha seu sexo:");
		this.showOptions(sexosList);
		
		String escolhaSexo = scanner.nextLine();

		if (!isValidValue(escolhaSexo, sexosList)) {
			throw new IllegalArgumentException("Valor inserido errado");
		}

		int escolhaSexoLong = Integer.valueOf(escolhaSexo);
		Sexo sexoEscolhido = sexosList.get(escolhaSexoLong - 1);

		this.setSexo(sexoEscolhido);
	}
	
}
