package exercicios.usuarios;

import java.time.LocalDate;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class Conta {

	@Getter
	@Setter
	private String login;
	@Getter
	@Setter
	private String senha;
	@Getter
	@Setter
	private String email;
	@Getter
	private LocalDate ultimoPagamento;
	@Getter
	private ArrayList<Usuario> usuarios = new ArrayList<>();

	private double precoPagamento() {
		if (this.getUsuarios().size() <= 1) {
			return 9.9;
		} else if (this.getUsuarios().size() > 1 && this.getUsuarios().size() < 5) {
			return 6.9 * this.getUsuarios().size();
		}
		return 29.0;
	}

	public Conta(String login, String senha, String email) {
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.ultimoPagamento = LocalDate.now();
	}

	public void registrarUsuario(Usuario user) {
		user.setConta(this);
		if (usuarios.size() < 5) {
			usuarios.add(user);
		} else {
			System.out.println("Você já possui 3 perfis nessa conta, se deseja criar "
					+ "mais um é necessário remover um ou criar outra conta.");
		}
	}

	public void removerUsuario(Usuario user) {
		usuarios.remove(user);
		user.setConta(null);
	}

	public void pagar() {
		this.ultimoPagamento = LocalDate.now();
	}

	public double getPrecoPagamento() {
		return this.precoPagamento();
	}

}
