package br.com.Facade;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.entidade.Universidade;

import clienterepositorio.UniversidadeRepositorio;

public class UniversidadeFacate {
	List<Universidade> lista;

	public void adiciona(Universidade area) {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			UniversidadeRepositorio remote = (UniversidadeRepositorio) ctx
					.lookup("java:global/ger-curriculoEAR/ger-curriculo/UniversidadeRepositorioImplement");

			remote.adiciona(area);

		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	public List<Universidade> getLista() {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			UniversidadeRepositorio remote = (UniversidadeRepositorio) ctx
					.lookup("java:global/ger-curriculoEAR/ger-curriculo/UniversidadeRepositorioImplement");

			lista = remote.getLista();
			for (Universidade item : lista)
				System.out.println(item.getNome());
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
