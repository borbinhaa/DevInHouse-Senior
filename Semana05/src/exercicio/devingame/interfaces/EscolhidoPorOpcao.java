package exercicio.devingame.interfaces;

import java.util.List;

public interface EscolhidoPorOpcao {
	
	default boolean isValidValue(String value, List<?> list) {
		if (!isLongPositive(value)) {
			return false;
		} 
		Long newValue = Long.valueOf(value);

		if (newValue > list.size() || newValue == 0) {
			return false;
		}
		
		
		return true;
	}
	
	default boolean isLongPositive(String value) {
		try {
			Long value2 = Long.parseLong(value);
			if (value2 < 0) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}
	
	default void showOptions(List<?> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("(" + (i + 1) + ") - " + list.get(i));
		}
	}
}
