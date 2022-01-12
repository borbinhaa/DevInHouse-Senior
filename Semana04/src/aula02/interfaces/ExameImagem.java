package aula02.interfaces;

public class ExameImagem extends Procedimento {

	@Override
	public boolean verificaPossibilidadeAgendamento() {
		if (equipamentoEstaFuncionando() && existeProfissionalDisponivel()) {
			return true;
		}
		
		return false;
	}

	private boolean equipamentoEstaFuncionando() {
		return true;
	}
	
	private boolean existeProfissionalDisponivel() {
		return true;
	}
}