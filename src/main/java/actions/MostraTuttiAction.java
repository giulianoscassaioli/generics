package actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import business.GenericsEJB;
import entity.Corso;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MostraTuttiAction<T> implements Actions<T> {

	private Class<T> tipo;

	public MostraTuttiAction(Class tipo) {
		this.tipo = tipo;
	}

	@Override
	public void esegui(HttpServletRequest request, HttpServletResponse response, GenericsEJB ej) throws ServletException, IOException {

		String path = request.getPathInfo().split("/")[1];// <----l'1 è il mostratutti del esempio sopra

		String jsp = "/" + path + "show.jsp";

		List<T> listaGenerica = ej.<T>trova(tipo);

		request.setAttribute("lista", listaGenerica);

		request.getServletContext().getRequestDispatcher(jsp).include(request, response);


	}

}
