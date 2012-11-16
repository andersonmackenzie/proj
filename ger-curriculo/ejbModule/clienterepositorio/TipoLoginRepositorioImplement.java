package clienterepositorio;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.entidade.Login;
import br.com.entidade.TipoLogin;

@Stateless
@Remote(TipoLoginRepositorio.class)
public class TipoLoginRepositorioImplement implements TipoLoginRepositorio {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adiciona(TipoLogin tipo) {
		// manager.getTransaction().begin();
		manager.persist(tipo);
		// manager.getTransaction().commit();
	}

	@Override
	public List<TipoLogin> getTipoLogin() {
		TypedQuery<TipoLogin> query = manager.createQuery(
				"select cl from TipoLogin cl", TipoLogin.class);

		return query.getResultList();
	}

	@Override
	public TipoLogin getTipo(int codigo) {
		return manager.find(TipoLogin.class, codigo);
	}

	@Override
	public void atualiza(Login login) {
		manager.merge(login);

	}

}
