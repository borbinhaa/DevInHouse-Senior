// Crie um software que oferece ao usuário três sabores diferentes de pizza fixos 
// (exemplo: mussarela, calabresa, portuguesa) identificadas por um número. Enquanto o usuário
// escolher um sabor válido, pergunte se ele deseja uma nova fatia. Caso contrário, exiba quantas
// fatias ele comeu e encerre o programa.

// Exemplo:
//  	“Você deseja uma pizza? Envie “1” para calabresa, “2” para mussarela, “3” para portuguesa
//       ou “0” caso esteja satisfeito”

package exercicios;

import java.util.Scanner;

public class Exercicio09 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int pedacosCalabresa = 0, pedacosMussarela = 0, pedacosPortugesa = 0, totalPedacos = 0;

		System.out.print("Você deseja uma pizza?\nEnvie \"1\" "
				+ "para calabresa, \"2\" para mussarela, \"3\" para portuguesa, \"0\" caso esteja satisfeito.");
		int resposta = scanner.nextInt();

		while (resposta != 0) {
			switch (resposta) {
			case 1 -> pedacosCalabresa++;
			case 2 -> pedacosMussarela++;
			case 3 -> pedacosPortugesa++;
			}
			System.out.println("Você deseja mais uma pizza?\nEnvie \"1\" "
					+ "para calabresa, \"2\" para mussarela, \"3\" para portuguesa, \"0\" caso esteja satisfeito.");
			resposta = scanner.nextInt();

		}

		totalPedacos = pedacosCalabresa + pedacosMussarela + pedacosPortugesa;

		System.out.println("Você comeu " + pedacosCalabresa + " fatias de calabresa.");
		System.out.println("Você comeu " + pedacosMussarela + " fatias de muzzarela.");
		System.out.println("Você comeu " + pedacosPortugesa + " fatias de portuguesa.");
		System.out.println("No total: " + totalPedacos + " fatias.");

		scanner.close();

	}
}