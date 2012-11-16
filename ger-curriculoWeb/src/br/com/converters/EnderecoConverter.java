package br.com.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import clienterepositorio.EnderecoRepositorio;


import br.com.entidade.Endereco;


@FacesConverter(value = "converteEndereco", forClass = Endereco.class)
public class EnderecoConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.equals(""))
			return null;
		InitialContext ctx;
		EnderecoRepositorio remote = null;
		try {
			ctx = new InitialContext();
			remote = (EnderecoRepositorio) ctx
					.lookup("java:global/ger-curriculoEAR/ger-curriculo/EnderecoRepositorioImplement");

		} catch (NamingException e) {

			e.printStackTrace();
		}

	
		return remote.getEndereco(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null && value instanceof Endereco) {
			return String.valueOf(((Endereco) value).getId());
		}
		return null;

	}
}
