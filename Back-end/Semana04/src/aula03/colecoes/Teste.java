package aula03.colecoes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


public class Teste {

	public static void main(String[] args) {
		
		ArrayList<Integer> intArray = new ArrayList<>();
		intArray.add(24);
		System.out.println(intArray);
		
		
		LinkedList<String> stringLinkedList = new LinkedList<>();
		stringLinkedList.add("To no meio");
		stringLinkedList.addFirst("oi");
		stringLinkedList.addLast("Tchau");
		System.out.println(stringLinkedList);
		
		
//		Sets não permitem objetos repetidos
		Set<Integer> conjuntoInt = new HashSet<>();
		conjuntoInt.add(1);
		conjuntoInt.add(1);
		conjuntoInt.add(1);
		System.out.println(conjuntoInt);
		
		
//		Map seriam os dicionarios
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("1", "Pedro");
		maps.put("2", "Antonio");
		maps.put("3", "Maria");
		System.out.println(maps);
		System.out.println(maps.size());
		maps.remove("1");
		System.out.println(maps.size());
		System.out.println(maps);
		System.out.println(maps.get("2"));
		
		for (String key : maps.keySet()) {
			System.out.println("Chave: " + key + ", Valor: " + maps.get(key));
		}
	
	}
	
}
