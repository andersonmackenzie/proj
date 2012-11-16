package clienterepositorio;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.com.entidade.TelefoneEmpresa;

@Stateless
@Remote(TelefoneEmpresaRepositorio.class)
public class TelefoneEmpresaRepositorioImplement implements
		TelefoneEmpresaRepositorio {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adiciona(TelefoneEmpresa telefone) {
		// manager.getTransaction().begin();
		manager.persist(telefone);
		// manager.getTransaction().commit();
	}

	@Override
	public void atualiza(TelefoneEmpresa telefone) {
		manager.merge(telefone);

	}

	@Override
	public List<TelefoneEmpresa> getLista() {
		TypedQuery<TelefoneEmpresa> query = manager.createQuery(
				"select cl from TelefoneEmpresa cl ", TelefoneEmpresa.class);

		return query.getResultList();
	}

	@Override
	public TelefoneEmpresa getUsuario(int cod) {
		return manager.find(TelefoneEmpresa.class, cod);
	}

}
