package aula03;

public class For {

	public static void main(String[] args) {
//		int valorFinal = 10;

//		for (int i = 0; i <= valorFinal; i++) {
//			System.out.println("Valor de i: " + i);
//		}

//		for (int i = 0; i <= valorFinal; i = i + 2) { // assim vai de 2 em 2
//			System.out.println("Valor de i: " + i);
//		}

//  	continue - vai pro proximo loop
//      break - termina o loop

//		for (int x = 10;; x++) { // é possivel deixar algo em branco, nesse caso ele não tem uma condição final
//			if (x == 11) {
//				continue;
//			} else if (x == 15) {
//				break;
//			}
//			System.out.println(x);
//		}

		for (int x = 10; x < 20; x++) {
			for (int y = 15; y > 10; y--) {
				System.out.println("y = " + y);
				if (y == 13) {
					break;
				}
			}
			System.out.println("x = " + x);
		}

	}
}
