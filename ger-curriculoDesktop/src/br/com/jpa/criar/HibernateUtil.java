package br.com.jpa.criar;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import br.com.entidade.*;

public class HibernateUtil {

	private static SessionFactory factory;
	static {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
	
		cfg.addAnnotatedClass(AreaAtuacao.class);
		cfg.addAnnotatedClass(CandidatoVaga.class);
		cfg.addAnnotatedClass(Curriculo.class);
		cfg.addAnnotatedClass(CurriculoCursos.class);
		cfg.addAnnotatedClass(CurriculoEmpresa.class);
		cfg.addAnnotatedClass(Curso.class);
		cfg.addAnnotatedClass(Empresa.class);
		cfg.addAnnotatedClass(Endereco.class);
		cfg.addAnnotatedClass(EnderecoEmpresa.class);
		cfg.addAnnotatedClass(Login.class);
		cfg.addAnnotatedClass(Telefone.class);
		cfg.addAnnotatedClass(TelefoneEmpresa.class);
		cfg.addAnnotatedClass(TipoDeTelefone.class);
		cfg.addAnnotatedClass(TipoLogin.class);
		cfg.addAnnotatedClass(Usuario.class);
		cfg.addAnnotatedClass(Vagas.class);
		
		
		
		
		
		
		
		
		
		
		factory = cfg.buildSessionFactory();

	}

	public Session getSession() {
		return factory.openSession();
	}
}
