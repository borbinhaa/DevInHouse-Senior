package aula02;

import java.util.Scanner;

public class Switch {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		String nomeDoMes, estacao;
		int mes = scanner.nextInt();
		
		String nomeDoMes2 = switch (mes) {
			case 1 -> "Janeiro";
			case 2 -> "Fevereiro";
			case 3 -> "Marco";
			case 4 -> "Abril";
			default -> "Invalido";
		};
		
		
//		switch (mes) {
//		case 1:
//			nomeDoMes = "Janeiro";
//			estacao = "Verao";
//			break;
//		case 2:
//			nomeDoMes = "Fevereiro";
//			estacao = "Verao";
//			break;
//		case 3:
//			nomeDoMes = "Março";
//			estacao = "Verao";
//			break;
//		case 4:
//			nomeDoMes = "Abril";
//			estacao = "Outono";
//			break;
//		case 5:
//			nomeDoMes = "Maio";
//			estacao = "Outono";
//			break;
//			
//		default:
//			nomeDoMes = "Invalido";
//			estacao = "Estacao invalida";
//			break;
//		}
//		
//		System.out.println("Mes:" + nomeDoMes + " Estacao:" + estacao);
	
		System.out.println(nomeDoMes2);
		
		scanner.close();
		
	}
}