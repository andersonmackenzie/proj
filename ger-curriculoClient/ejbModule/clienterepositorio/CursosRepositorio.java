package clienterepositorio;

import java.util.List;

import br.com.entidade.Curso;

public interface CursosRepositorio {
	public void adiciona(Curso curso);

	public void atualiza(Curso curso);

	public List<Curso> getLista();
	
	public Curso getCurso(int cod);
}
