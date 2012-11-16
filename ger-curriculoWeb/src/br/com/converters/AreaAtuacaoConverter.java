package br.com.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import clienterepositorio.AreaAtuacaoRepositorio;
import br.com.entidade.AreaAtuacao;

@FacesConverter(value = "convertearea", forClass = AreaAtuacao.class)
public class AreaAtuacaoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.equals(""))
			return null;
		InitialContext ctx;
		AreaAtuacaoRepositorio remote = null;
		try {
			ctx = new InitialContext();
			remote = (AreaAtuacaoRepositorio) ctx
					.lookup("java:global/ger-curriculoEAR/ger-curriculo/AreaAtuacaoRepositorioImplement");

		} catch (NamingException e) {

			e.printStackTrace();
		}

		return remote.getArea(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null && value instanceof AreaAtuacao) {
			return String.valueOf(((AreaAtuacao) value).getCodTipo());
		}
		return null;

	}
}
