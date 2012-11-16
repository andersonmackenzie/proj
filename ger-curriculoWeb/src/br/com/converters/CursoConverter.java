package br.com.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import clienterepositorio.CursosRepositorio;
import br.com.entidade.Curso;

@FacesConverter(value = "convertecurso", forClass = Curso.class)
public class CursoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.equals(""))
			return null;
		InitialContext ctx;
		CursosRepositorio remote = null;
		try {
			ctx = new InitialContext();
			remote = (CursosRepositorio) ctx
					.lookup("java:global/ger-curriculoEAR/ger-curriculo/CursosRepositorioImplement");

		} catch (NamingException e) {

			e.printStackTrace();
		}

		return remote.getCurso(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null && value instanceof Curso) {
			return String.valueOf(((Curso) value).getCodCurso());
		}
		return null;

	}
}
