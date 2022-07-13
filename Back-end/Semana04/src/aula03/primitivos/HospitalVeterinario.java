package aula03.primitivos;

public class HospitalVeterinario {

	public static void main(String[] args) {
		
		
//                              4 inteiros na lista
		int[] notasDosProjetos = new int[4];
		
		notasDosProjetos[2] = 5;
		
		System.out.println(notasDosProjetos.length);
		
//		foreach + ctrl + espaço
		for (int i : notasDosProjetos) {
			System.out.println(i);
		}
		
		boolean[] arrayBooleanos = new boolean[3];
		System.out.println(arrayBooleanos[0]);
		System.out.println(arrayBooleanos[1]);
		System.out.println(arrayBooleanos[2]);
		
		char[] arrayChar = new char[2];
		System.out.println(arrayChar[0]);
		System.out.println(arrayChar[1]);
//		 sai vazio pois ele registra o ''
	}
	
}
