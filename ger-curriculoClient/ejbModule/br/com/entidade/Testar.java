package br.com.entidade;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Testar {

	public static void main(String[] args) {
		Testar.getConexao();
	}

	public static Connection getConexao() {
		DataSource ds = null;
		Connection con = null;
		InitialContext ic;
		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("jdbc/projeto");
			con = ds.getConnection();
			System.out.println("conectado");
		} catch (Exception e) {
			System.out.println("Erro a pegar conexao: " + e.getMessage());
			e.printStackTrace();
		}
		return con;
	}
}
