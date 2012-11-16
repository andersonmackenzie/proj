package br.com.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import clienterepositorio.UniversidadeRepositorio;
import br.com.entidade.Universidade;

@FacesConverter(value = "converteUniversidade", forClass = Universidade.class)
public class UniversidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.equals(""))
			return null;
		InitialContext ctx;
		UniversidadeRepositorio remote = null;
		try {
			ctx = new InitialContext();
			remote = (UniversidadeRepositorio) ctx
					.lookup("java:global/ger-curriculoEAR/ger-curriculo/UniversidadeRepositorioImplement");

		} catch (NamingException e) {

			e.printStackTrace();
		}

		return remote.getUniversidade(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null && value instanceof Universidade) {
			return String.valueOf(((Universidade) value).getId());
		}
		return null;

	}
}
