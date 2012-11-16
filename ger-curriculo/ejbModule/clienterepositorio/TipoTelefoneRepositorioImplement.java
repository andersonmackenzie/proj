package clienterepositorio;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.com.entidade.TipoDeTelefone;

@Stateless
@Remote(TipoDeTelefoneRepositorio.class)
public class TipoTelefoneRepositorioImplement implements TipoDeTelefoneRepositorio {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adiciona(TipoDeTelefone tipo) {
		// manager.getTransaction().begin();
		manager.persist(tipo);
		// manager.getTransaction().commit();
	}

	@Override
	public void atualiza(TipoDeTelefone tipo) {
		manager.merge(tipo);

	}

	@Override
	public List<TipoDeTelefone> getLista() {
		TypedQuery<TipoDeTelefone> query = manager.createQuery(
				"select cl from TipoDeTelefone cl ", TipoDeTelefone.class);

		return query.getResultList();
	}

	@Override
	public TipoDeTelefone getTipo(int cod) {
		return manager.find(TipoDeTelefone.class, cod);
	}

}
