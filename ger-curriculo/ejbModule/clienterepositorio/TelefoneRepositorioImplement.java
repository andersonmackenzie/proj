package clienterepositorio;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.com.entidade.Telefone;

@Stateless
@Remote(TelefoneRepositorio.class)
public class TelefoneRepositorioImplement implements TelefoneRepositorio {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adiciona(Telefone telefone) {
		// manager.getTransaction().begin();
		manager.persist(telefone);
		// manager.getTransaction().commit();
	}

	@Override
	public void atualiza(Telefone telefone) {
		manager.merge(telefone);

	}

	@Override
	public List<Telefone> getLista() {
		TypedQuery<Telefone> query = manager.createQuery(
				"select cl from Telefone cl ", Telefone.class);

		return query.getResultList();
	}

	@Override
	public Telefone getUsuario(int cod) {
		return manager.find(Telefone.class, cod);
	}

}
