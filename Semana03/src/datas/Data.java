package datas;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Data {
	
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		
		LocalDate dataAniversario = LocalDate.of(2004, 1, 9);
		System.out.println(dataAniversario);
		
		System.out.println(ChronoUnit.DAYS.between(localDate, dataAniversario));
	}
	
}
