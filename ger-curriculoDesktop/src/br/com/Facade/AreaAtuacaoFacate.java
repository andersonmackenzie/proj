package br.com.Facade;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.entidade.AreaAtuacao;

import clienterepositorio.AreaAtuacaoRepositorio;
import clienterepositorio.EmpresaRepositorio;

public class AreaAtuacaoFacate {
	List<AreaAtuacao> lista;

	public void adiciona(AreaAtuacao area) {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			AreaAtuacaoRepositorio remote = (AreaAtuacaoRepositorio) ctx
					.lookup("java:global/ger-curriculoEAR/ger-curriculo/AreaAtuacaoRepositorioImplement");
	
			remote.adiciona(area);

		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	public List<AreaAtuacao> getLista() {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			AreaAtuacaoRepositorio remote = (AreaAtuacaoRepositorio) ctx
					.lookup("java:global/ger-curriculoEAR/ger-curriculo/AreaAtuacaoRepositorioImplement");

			lista = remote.getListaArea();

		} catch (NamingException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
