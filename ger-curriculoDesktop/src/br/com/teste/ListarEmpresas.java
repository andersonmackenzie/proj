package br.com.teste;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.entidade.Empresa;

import clienterepositorio.EmpresaRepositorio;

public class ListarEmpresas {
	public static void main(String[] args) {

		try {

			Properties jndiProps = new Properties();
			jndiProps.put("java.naming.factory.initial",
					"com.sun.enterprise.naming.impl.SerialInitContextFactory");
			jndiProps.put("java.naming.factory.url.pkgs",
					"com.sun.enterprise.naming");
			jndiProps
					.put("java.naming.factory.state",
							"com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
			jndiProps.setProperty("org.omg.CORBA.ORBInitialHost",
					"192.168.0.100");
			jndiProps.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

			InitialContext ctx = new InitialContext(jndiProps);

			EmpresaRepositorio remote = (EmpresaRepositorio) ctx
					.lookup("java:global/ger-curriculoEAR/ger-curriculo/EmpresaRepositorioImplement");

			for (Empresa emp : remote.getEmpresas())
			System.out.println(emp.getCodEmpresa() + " - " + emp.getNome());

		} catch (NamingException e) {

			e.printStackTrace();
		}

	}
}
