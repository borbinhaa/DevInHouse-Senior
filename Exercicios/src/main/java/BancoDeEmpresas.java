import java.util.ArrayList;
import java.util.List;

public class BancoDeEmpresas {
	
	private static List<Empresa> listaEmpresas = new ArrayList<Empresa>();
	
	public static List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void addEmpresa(Empresa empresa) {
		listaEmpresas.add(empresa);
	}

}
