package aula02.interfaces;

public class ExameLaboratorial extends Procedimento {

	@Override
	public boolean verificaPossibilidadeAgendamento() {
		if (existePessoaParaColeta()) {
			return true;
		}
		
		return false;
	}

	private boolean existePessoaParaColeta() {
		return true;
	}
}