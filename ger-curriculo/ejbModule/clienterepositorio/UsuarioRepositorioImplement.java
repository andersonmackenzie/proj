package clienterepositorio;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.com.entidade.Usuario;

@Stateless
@Remote(UsuarioRepositorio.class)
public class UsuarioRepositorioImplement implements UsuarioRepositorio {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adiciona(Usuario user) {
		manager.persist(user);
	}

	@Override
	public List<Usuario> getLista() {
		TypedQuery<Usuario> query = manager.createQuery(
				"select cl from Usuario cl ", Usuario.class);

		return query.getResultList();
	}

	@Override
	public Usuario getUsuario(int cod) {
		return manager.find(Usuario.class, cod);
	}

	@Override
	public void atualiza(Usuario user) {
		System.out.println("atualizando " + "" + user.getCodUsuario()
				+ user.getNome());
		manager.merge(user);

	}

}
