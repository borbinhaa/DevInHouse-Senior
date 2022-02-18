import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Pessoa> lista = new ArrayList<Pessoa>();
	
	
	public void adiciona(String nome) {
		Pessoa pessoa = new Pessoa(nome);
		lista.add(pessoa);
	}
	
	public List<Pessoa> listar() {
		return lista;
	}
}	
