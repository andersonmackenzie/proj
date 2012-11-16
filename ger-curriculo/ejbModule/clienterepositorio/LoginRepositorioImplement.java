package clienterepositorio;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.com.entidade.Login;

@Stateless
@Remote(LoginRepositorio.class)
public class LoginRepositorioImplement implements LoginRepositorio {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adiciona(Login login) {
		manager.persist(login);
	}

	@Override
	public List<Login> getLista() {

		TypedQuery<Login> query = manager.createQuery(
				"select cl from Login cl", Login.class);

		return query.getResultList();
	}

	@Override
	public void atualiza(Login login) {
	manager.merge(login);
		
	}

}
