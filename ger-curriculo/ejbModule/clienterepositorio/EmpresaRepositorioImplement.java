package clienterepositorio;

import java.util.List;


import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.com.entidade.Empresa;

@Stateless
@Remote(EmpresaRepositorio.class)
public class EmpresaRepositorioImplement implements EmpresaRepositorio {

	@PersistenceContext
	private EntityManager manager;

	public void adiciona(Empresa empresa) {
		manager.persist(empresa);
	}

	public List<Empresa> getEmpresas() {

		TypedQuery<Empresa> query = manager.createQuery(
				"select cl from Empresa cl", Empresa.class);

		return query.getResultList();
	}

	@Override
	public void atualiza(Empresa empresa) {
		manager.merge(empresa);
		
	}

	@Override
	public Empresa getEmpresa(int cod) {
		return manager.find(Empresa.class, cod);
	}
}
