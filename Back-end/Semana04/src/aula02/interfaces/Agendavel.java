package aula02.interfaces;

public interface Agendavel {

	public String MINHA_CONSTANTE = "MINHA CONSTANTE";
	
	public boolean verificaPossibilidadeAgendamento();
	
	public default boolean verificaPossiblidade() {
		return false;
	}
	
}